package com.geesoo.bookSearch.books.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geesoo.bookSearch.books.dto.ResponseBook;
import com.geesoo.bookSearch.books.dto.SearchingRequest;

import reactor.core.publisher.Mono;

@Service
public interface BooksService {


	Mono<ResponseBook> findBookByQuery(SearchingRequest searchingRequest);

	List<SearchingRequest> findHistoryByName(SearchingRequest searchingRequest);

	List<SearchingRequest> findAllBestQuery();
}
