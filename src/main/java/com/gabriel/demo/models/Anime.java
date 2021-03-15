package com.gabriel.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

@Entity
public class Anime {
	public Anime() {
		
	}
	public Anime(String name, String gender, int releaseDate, String url) {
		this.name = name;
		this.gender = gender;
		this.releaseDate = releaseDate;
		this.url = url;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	@NotNull(message = "name cannot be empty")
	@NotEmpty(message = "name cannot be empty")
	private String name;
	@NotNull(message = "gender cannot be empty")
	@NotEmpty(message = "name cannot be empty")
	private String gender;
	@NotNull(message = "realese date cannot ve empty")
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
	
	@ManyToOne
	private Author author;
	
}
