package com.gabriel.demo.models.requestbody;

import com.gabriel.demo.models.Anime;

public class AuthorRequestBody {
	private String name;
	private String sex;
	private String birthday;
	private Anime anime;
	
	public String getName() {
		return name;
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




	public AuthorRequestBody(String name, String sex, String birthday, Anime anime) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.anime = anime;
	}

}
