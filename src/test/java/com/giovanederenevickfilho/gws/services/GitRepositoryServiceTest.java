package com.giovanederenevickfilho.gws.services;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GitRepositoryServiceTest {

	@Test
	public void getExtensionFromHrefNull() {
		
		GitRepositoryService service = new GitRepositoryService();
		String pathInvalid = "https://github.com/giovanederenevick/git-web-scraping/blob/master/mvnw";
		
		assertNull(service.getExtensionFromHref(pathInvalid));
	}
	
	@Test
	public void getExtensionFromHrefNotNull() {
		
		GitRepositoryService service = new GitRepositoryService();
		String path = "https://github.com/giovanederenevick/git-web-scraping/blob/master/pom.xml";
		String extension = "xml";
		
		assertEquals(extension, service.getExtensionFromHref(path));
	}
}
