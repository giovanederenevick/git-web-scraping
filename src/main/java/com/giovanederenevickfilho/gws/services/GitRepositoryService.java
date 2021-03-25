package com.giovanederenevickfilho.gws.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovanederenevickfilho.gws.domain.GitRepository;
import com.giovanederenevickfilho.gws.domain.GitRepositoryDetails;
import com.giovanederenevickfilho.gws.repositories.GitRepositoryDetailsRepository;
import com.giovanederenevickfilho.gws.utis.WebScrapingUtils;

@Service
public class GitRepositoryService {
	
	@Autowired
	GitRepositoryDetailsRepository repo;
	
	private Document doc;
	
	private void listAllLinks(String url) throws IOException {		
		try {
			doc = Jsoup.connect(WebScrapingUtils.getGitHubUrl() + url).get();
		} catch (HttpStatusException e) {
			e.printStackTrace();
			return;
		}
		
		Elements elements = doc.getElementsByClass("js-navigation-open Link--primary");
		
		for (Element element : elements) {
			String link = element.attributes().get("href");
			String extension = getExtensionFromHref(link);
			if(extension != null) {
				doc = Jsoup.connect(WebScrapingUtils.getGitHubUrl() + link).get();
				Elements elementsFile = doc.getElementsByClass("text-mono f6 flex-auto pr-3 flex-order-2 flex-md-order-1 mt-2 mt-md-0");
				for (Element elementFile : elementsFile) {
					Long countLines = WebScrapingUtils.getCountLines(elementFile.text());
					Double countBytes = WebScrapingUtils.getCountBytes(elementFile.text());;
										
					GitRepositoryDetails grd = find(extension);
					if(grd == null) {
						GitRepositoryDetails newGrd = new GitRepositoryDetails(extension, countLines, countBytes);
						repo.save(newGrd);
					} else {
						grd.setCountLines(grd.getCountLines() != null ? grd.getCountLines() + countLines : countLines);
						grd.setCountBytes(grd.getCountBytes() != null ? grd.getCountBytes() + countBytes : countBytes);
						repo.save(grd);
					}
				}
			} else {
				listAllLinks(link);
			}
		}
	}

	private void cleanDb() {
		
		repo.deleteAll();
	}

	public GitRepository listAll(String gitUser, String userRepository){		
		try {
			cleanDb();
			
			listAllLinks("/" + gitUser + "/" + userRepository);

			List<GitRepositoryDetails> listGrd = repo.findAll();
			
			GitRepository gr = new GitRepository(gitUser, userRepository, listGrd);
			
			return gr;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getExtensionFromHref(String link) {
		
		String[] linkFormatted = link.split("/");
		String[] extension = linkFormatted[linkFormatted.length - 1].split("\\.");
		if(extension.length > 1) {
			return extension[extension.length - 1];
		}
		return null;
	}
	
	public GitRepositoryDetails find(String fileExtension) {
		
		Optional<GitRepositoryDetails> obj = repo.findById(fileExtension);
		return obj.orElse(null);
	}
}
