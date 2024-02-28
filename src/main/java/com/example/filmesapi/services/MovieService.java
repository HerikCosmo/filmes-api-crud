package com.example.filmesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.filmesapi.entities.Movie;
import com.example.filmesapi.repositories.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        List<Movie> result = movieRepository.findAll();

        return result;
    }
}
