package com.gcu.model;

import javax.validation.constraints.NotNull;

public class SearchModel
{
	@NotNull
	private String searchTerm;

	public String getSearchTerm()
	{
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm) 
	{
		this.searchTerm = searchTerm;
	}
}