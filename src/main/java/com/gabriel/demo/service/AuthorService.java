package com.gabriel.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.demo.exception.ApiRequestException;
import com.gabriel.demo.models.Author;
import com.gabriel.demo.models.requestbody.AuthorRequestBody;
import com.gabriel.demo.repository.AuthorRepository;

@Service
public class AuthorService {
	
@Autowired
private AuthorRepository authorRepository;



public Author save(AuthorRequestBody authorRequestBody) {
	try {
		return authorRepository.save(new Author(authorRequestBody.getName(),
				authorRequestBody.getSex(),
				authorRequestBody.getBirthday(),
				authorRequestBody.getAnime()));
	}catch(Exception e) {
		throw new ApiRequestException(e.getMessage());
	}
	
}


}
