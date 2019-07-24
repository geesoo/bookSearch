package com.geesoo.bookSearch.books.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;

import com.geesoo.bookSearch.books.dto.SearchingRequest;

public interface SearchHistroyRepository extends JpaRepository<SearchingRequest, Long>, RevisionRepository<SearchingRequest, Long, Integer> {

	List<SearchingRequest> findByUserName(String userName);

	
	  @Query(nativeQuery = true,value="SELECT COUNT(QUERY) AS cnt , query FROM SEARCHING_REQUEST Group by QUERY HAVING COUNT(QUERY) ORDER BY COUNT(QUERY) DESC LIMIT 10") 
	  List<SearchingRequest> findAllBestQuery();

}
