package com.gabriel.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	public String getName() {
		return name;
	}

	public Author(String name, String sex, String birthday, Anime anime) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.anime = anime;
	}
	public Author(String name, String sex, String birthday) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Anime getAnime() {
		return anime;
	}

	public void setAnime(Anime anime) {
		this.anime = anime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String sex;
	private String birthday;
	
	@OneToMany
	private Anime anime;

}
