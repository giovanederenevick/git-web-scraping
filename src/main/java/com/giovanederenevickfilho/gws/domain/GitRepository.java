package com.giovanederenevickfilho.gws.domain;

import java.io.Serializable;

public class GitRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String fileExtension;
	private Integer countLines;
	private Integer countBytes;
	
	public GitRepository() {
	}

	public GitRepository(String fileExtension, Integer countLines, Integer countBytes) {
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

	public Integer getCountLines() {
		return countLines;
	}

	public void setCountLines(Integer countLines) {
		this.countLines = countLines;
	}

	public Integer getCountBytes() {
		return countBytes;
	}

	public void setCountBytes(Integer countBytes) {
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
		GitRepository other = (GitRepository) obj;
		if (fileExtension == null) {
			if (other.fileExtension != null)
				return false;
		} else if (!fileExtension.equals(other.fileExtension))
			return false;
		return true;
	}
}
