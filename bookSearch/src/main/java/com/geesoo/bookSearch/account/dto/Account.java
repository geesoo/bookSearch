package com.geesoo.bookSearch.account.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="account")
public class Account implements Serializable
{

	  /**
	 * 
	 */
	private static final long serialVersionUID = -6679866079339926828L;

	@Id
	  @GeneratedValue
	  private Long id;
	  
	  @NotEmpty
	  private String userName;
	  
	  @NotEmpty
	  private String passWord;
	  
	  @NotEmpty
	  private String role;
}
