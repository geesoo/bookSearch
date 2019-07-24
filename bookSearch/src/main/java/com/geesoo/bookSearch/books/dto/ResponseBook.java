package com.geesoo.bookSearch.books.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ResponseBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1173094743309091499L;

	private ResponseBook.Meta meta;
	private List<document> documents;
	
	public List<document> getDocuments() {
		return documents;
	}
	
	@Data
	static class Meta{
		long total_count;
		long pageable_count;
		boolean is_end;
	}
	@Data
	public static class document{
		String title;
		String contents;
		String url;
		List<String> authors;
		String publisher;
		String thumbnail;
	}
}
