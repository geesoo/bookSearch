package com.geesoo.bookSearch.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geesoo.bookSearch.books.dto.ResponseBook;
import com.geesoo.bookSearch.books.dto.SearchingRequest;
import com.geesoo.bookSearch.books.service.BooksService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BooksController {
	@Autowired
	private BooksService booksService;
	
	
	@GetMapping("/search")
    public Mono<ResponseBook> findBookByQuery(@ModelAttribute("searchingRequest") SearchingRequest searchingRequest,@AuthenticationPrincipal User user) {

		searchingRequest.setUserName(user.getUsername());
        return booksService.findBookByQuery(searchingRequest);
    }
	
	@GetMapping("/findHistory")
    public List<SearchingRequest> findHistoryByName(@AuthenticationPrincipal User user) {
		SearchingRequest searchingRequest = new SearchingRequest();
		searchingRequest.setUserName(user.getUsername());
        return booksService.findHistoryByName(searchingRequest);
    }
	
	@GetMapping("/findAllBestQuery")
    public List<SearchingRequest> findAllBestQuery(@AuthenticationPrincipal User user) {
		
        return booksService.findAllBestQuery();
    }
	

}
