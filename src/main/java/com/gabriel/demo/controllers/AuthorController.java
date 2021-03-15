package com.gabriel.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.demo.models.Author;
import com.gabriel.demo.models.requestbody.AuthorRequestBody;
import com.gabriel.demo.service.AuthorService;

@RestController
@RequestMapping("v1/author")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping
	public ResponseEntity<Author> saveAuthor(@RequestBody AuthorRequestBody authorRequestBody){
		
		return new ResponseEntity<>(authorService.save(authorRequestBody), HttpStatus.CREATED);
		

	}

}
