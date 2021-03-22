package com.giovanederenevickfilho.gws.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GitRepositoryDetails implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String fileExtension;
	
	private Long countLines;
	private Double countBytes;
	
	public GitRepositoryDetails() {
	}

	public GitRepositoryDetails(String fileExtension, Long countLines, Double countBytes) {
		super();
		this.fileExtension = fileExtension;
		this.countLines = countLines;
		this.countBytes = countBytes;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public Long getCountLines() {
		return countLines;
	}

	public void setCountLines(Long countLines) {
		this.countLines = countLines;
	}

	public Double getCountBytes() {
		return countBytes;
	}

	public void setCountBytes(Double countBytes) {
		this.countBytes = countBytes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileExtension == null) ? 0 : fileExtension.hashCode());
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
		GitRepositoryDetails other = (GitRepositoryDetails) obj;
		if (fileExtension == null) {
			if (other.fileExtension != null)
				return false;
		} else if (!fileExtension.equals(other.fileExtension))
			return false;
		return true;
	}
}
