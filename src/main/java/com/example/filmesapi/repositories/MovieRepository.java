package com.example.filmesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.filmesapi.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
