package com.gabriel.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gabriel.demo.exception.ApiRequestException;
import com.gabriel.demo.models.Anime;
import com.gabriel.demo.models.requestbody.AnimeRequestBody;
import com.gabriel.demo.repository.AnimeRepository;


import java.util.List;
import java.util.Optional;


@Service
public class AnimeService {
	
	@Autowired
	private AnimeRepository animeRepository;	

	public List<Anime> getAllAnimes(){
		 
		 try {
			 return animeRepository.findAll();
			}catch(Exception e) {
				throw new ApiRequestException(e.getMessage());
			}
		
		}
	
	public Anime findAnimeById(long id) {
		return animeRepository.findById(id).orElseThrow(() 
				-> new ApiRequestException("Anime not found"));
	}
	public Anime save(AnimeRequestBody animeRequestBody) {
		try {
			return animeRepository.save(new Anime(animeRequestBody.getName(),
					animeRequestBody.getGender(),
					animeRequestBody.getReleaseDate(),
					animeRequestBody.getUrl()));
		}catch(Exception e) {
			 throw new ApiRequestException(e.getMessage());
		}

		
	}
	
	public void delete(long id) {
		try {
			animeRepository.delete(findAnimeById(id));
		}catch(Exception e) {
			 throw new ApiRequestException(e.getMessage());
		}
	}
	
	public void update(Anime anime) {
		try {
			Anime animeUpdate = findAnimeById(anime.getId());
			animeUpdate.setName(anime.getName());
			animeUpdate.setGender(anime.getGender());
			animeUpdate.setReleaseDate(anime.getReleaseDate());
			animeUpdate.setUrl(anime.getUrl());
			
			animeRepository.save(animeUpdate);
		}catch(Exception e) {
			 throw new ApiRequestException(e.getMessage());
		}
	
	}


}
