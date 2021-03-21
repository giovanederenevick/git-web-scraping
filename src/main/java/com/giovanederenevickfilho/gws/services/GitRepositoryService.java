package com.giovanederenevickfilho.gws.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.giovanederenevickfilho.gws.domain.GitRepository;

@Service
public class GitRepositoryService {
	
	public List<GitRepository> find(String gitUrlRepository){
		
		GitRepository gr1 = new GitRepository("html", 1000, 500);
		GitRepository gr2 = new GitRepository("js", 120, 5);
		
		List<GitRepository> listGr = new ArrayList<>();
		
		listGr.add(gr1);
		listGr.add(gr2);
		
		return listGr;
	}
}
