package com.giovanederenevickfilho.gws.domain;

import java.io.Serializable;
import java.util.List;

public class GitRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String gitUsername;
	private String gitRepositoryName;
	private List<GitRepositoryDetails> gitRepositoryDetails;
	
	public GitRepository() {
	}

	public GitRepository(String gitUsername, String gitRepositoryName, List<GitRepositoryDetails> gitRepositoryDetails) {
		super();
		this.gitUsername = gitUsername;
		this.gitRepositoryName = gitRepositoryName;
		this.gitRepositoryDetails = gitRepositoryDetails;
	}

	public String getGitUsername() {
		return gitUsername;
	}

	public void setGitUsername(String gitUsername) {
		this.gitUsername = gitUsername;
	}

	public String getGitRepositoryName() {
		return gitRepositoryName;
	}

	public void setGitRepositoryName(String gitRepositoryName) {
		this.gitRepositoryName = gitRepositoryName;
	}

	public List<GitRepositoryDetails> getGitRepositoryDetails() {
		return gitRepositoryDetails;
	}

	public void setGitRepositoryDetails(List<GitRepositoryDetails> gitRepositoryDetails) {
		this.gitRepositoryDetails = gitRepositoryDetails;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gitRepositoryName == null) ? 0 : gitRepositoryName.hashCode());
		result = prime * result + ((gitUsername == null) ? 0 : gitUsername.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GitRepository other = (GitRepository) obj;
		if (gitRepositoryName == null) {
			if (other.gitRepositoryName != null)
				return false;
		} else if (!gitRepositoryName.equals(other.gitRepositoryName))
			return false;
		if (gitUsername == null) {
			if (other.gitUsername != null)
				return false;
		} else if (!gitUsername.equals(other.gitUsername))
			return false;
		return true;
	}
}
