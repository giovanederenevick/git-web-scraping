package com.giovanederenevickfilho.gws.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giovanederenevickfilho.gws.domain.GitRepository;
import com.giovanederenevickfilho.gws.services.GitRepositoryService;

@RestController
@RequestMapping(value="/githubrepositories")
public class GitWebScrapResource {
	
	@Autowired
	private GitRepositoryService gitRepositoryService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list(
			@RequestParam(value = "gitUser") String gitUser,
			@RequestParam(value = "userRepository") String userRepository) {
				
		GitRepository listGr;
		try {
			listGr = gitRepositoryService.listAll(gitUser, userRepository);
			return ResponseEntity.ok().body(listGr);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
}
