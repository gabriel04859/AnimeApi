package com.gabriel.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.gabriel.demo.exception.ApiRequestException;
import com.gabriel.demo.models.Anime;
import com.gabriel.demo.models.requestbody.AnimeRequestBody;
import com.gabriel.demo.service.AnimeService;

@RestController
@RequestMapping("v1/anime")
public class AnimeController {
	
	@Autowired
	private AnimeService animeService;
	

	@GetMapping
	public List<Anime> getAllMaps() {
	
		return animeService.getAllAnimes();
		
			
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Anime> getAnimeById(@PathVariable long id){
		return new ResponseEntity<>(animeService.findAnimeById(id), HttpStatus.FOUND);
		
	}
	
	@PostMapping
	public ResponseEntity<Anime> saveAnime(@RequestBody AnimeRequestBody
			animeRequestBody){
		return new ResponseEntity<>(animeService.save(animeRequestBody),
				HttpStatus.CREATED);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Anime> deleteAnime(@PathVariable long id){
		animeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping()
	public ResponseEntity<Anime> updateAnime(@RequestBody Anime anime){
		animeService.update(anime);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
