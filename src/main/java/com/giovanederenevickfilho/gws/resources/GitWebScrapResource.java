package com.giovanederenevickfilho.gws.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.giovanederenevickfilho.gws.domain.GitRepository;

@RestController
@RequestMapping(value="/repositories")
public class GitWebScrapResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<GitRepository> list() {
		
		GitRepository gr1 = new GitRepository("html", 1000, 500);
		GitRepository gr2 = new GitRepository("js", 120, 5);
		
		List<GitRepository> listGr = new ArrayList<>();
		
		listGr.add(gr1);
		listGr.add(gr2);
		
		return listGr;
	}
}
