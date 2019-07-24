package com.geesoo.bookSearch.books.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.data.querydsl.binding.QuerydslPredicate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited //이력관리용 어노테이션
public class SearchingRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5344816605425983673L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
    private String userName;
    
    @Column
	private String query;
    
    @Column
	private String sort;
    
    @Column
	private int page;
    
    @Column
	private int size;
     
    @Column
    @CreationTimestamp
    private Timestamp publishedAt;
	
	public SearchingRequest(String query, String userName) {
		this.userName=userName;
		this.query=query;
		this.page=1;
		this.size=10;
		this.sort="accuracy";
	}
	

	
}
