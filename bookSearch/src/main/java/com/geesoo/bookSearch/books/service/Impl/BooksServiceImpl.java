package com.geesoo.bookSearch.books.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.geesoo.bookSearch.books.dao.SearchHistroyRepository;
import com.geesoo.bookSearch.books.dto.ResponseBook;
import com.geesoo.bookSearch.books.dto.SearchingRequest;
import com.geesoo.bookSearch.books.service.BooksService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {

	//private final RestTemplate restTemplate;

	@Autowired
	private SearchHistroyRepository searchHistroyRepository;
	
	@Value("${kakao.openapi.book.url}")
    private String kakaoOpenApiBookUrl;

    @Value("${kakao.openapi.authorization}")
    private String kakaoOpenApiAuthorization;
    
    @Value("${naver.openapi.book.url}")
    private String naverOpenApiBookUrl;
    
    @Value("${naver.openapi.client.id}")
    private String naverOpenApiClientId;
    
    @Value("${naver.openapi.client.secret}")
    private String naverOpenApiClientSecret;


	@Override
	public Mono<ResponseBook> findBookByQuery(SearchingRequest searchingRequest) {
		// TODO Auto-generated method stub
		/*WebClient.create(naverOpenApiBookUrl) .method(HttpMethod.GET)
		  .uri("?query=" + query)
		  .header("X-Naver-Client-Id", naverOpenApiClientId)
		  .header("X-Naver-Client-Secret", naverOpenApiClientSecret) .retrieve()
		  .bodyToMono(ResponseBook.class);*/
		if(searchingRequest.getPage() == 0)
		{
			searchingRequest = new SearchingRequest(searchingRequest.getQuery(),searchingRequest.getUserName());
		}
		
		searchHistroyRepository.save(searchingRequest);
				
		return WebClient.create(kakaoOpenApiBookUrl)
                .method(HttpMethod.GET)
                .uri("?query=" + searchingRequest.getQuery() + "&page=" + searchingRequest.getPage() + "&size" + searchingRequest.getSize() + "&sort=" + searchingRequest.getSort())
                .header("Authorization", "KakaoAK " + kakaoOpenApiAuthorization)
                .retrieve()
                .bodyToMono(ResponseBook.class);
	}


	@Override
	public List<SearchingRequest> findHistoryByName(SearchingRequest searchingRequest) {
		
		return searchHistroyRepository.findByUserName(searchingRequest.getUserName());
	}


	@Override
	public List<SearchingRequest> findAllBestQuery() {
		
		return searchHistroyRepository.findAllBestQuery();
	}
}
