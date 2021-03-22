package com.giovanederenevickfilho.gws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giovanederenevickfilho.gws.domain.GitRepositoryDetails;

@Repository
public interface GitRepositoryDetailsRepository extends JpaRepository<GitRepositoryDetails, String>{
	
}
