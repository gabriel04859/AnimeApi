package com.gabriel.demo.models.requestbody;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

public class AnimeRequestBody {

	@NotNull(message = "name cannot be empty")
	@NotEmpty(message = "name cannot be empty")
	private String name;
	@NotNull(message = "gender cannot be empty")
	@NotEmpty(message = "gender cannot be empty")
	private String gender;
	@NotNull(message = "releaseDate cannot be empty")
	private int releaseDate;
	@NotEmpty(message = "url cannot be empty")
	@NotNull(message = "url cannot be empty")
	@URL(message = "url is not valid")
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	public AnimeRequestBody(String name, String gender, int releaseDate, String url) {
		super();
		this.name = name;
		this.gender = gender;
		this.releaseDate = releaseDate;
		this.url = url;
	}
	
}
