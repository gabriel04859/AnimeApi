package com.gabriel.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.demo.models.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long>   {

}
