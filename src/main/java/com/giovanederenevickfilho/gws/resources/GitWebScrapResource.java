package com.giovanederenevickfilho.gws.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.giovanederenevickfilho.gws.domain.GitRepository;
import com.giovanederenevickfilho.gws.services.GitRepositoryService;

@RestController
@RequestMapping(value="/repositories")
public class GitWebScrapResource {
	
	@Autowired
	private GitRepositoryService gitRepositoryService;

	@RequestMapping(value="/{giturl}", method = RequestMethod.GET)
	public ResponseEntity<?> list(@PathVariable String giturl) {
				
		List<GitRepository> listGr = gitRepositoryService.find(giturl);
		
		return ResponseEntity.ok().body(listGr);
	}
}
