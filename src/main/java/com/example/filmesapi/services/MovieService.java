package com.example.filmesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.filmesapi.entities.Movie;
import com.example.filmesapi.repositories.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        List<Movie> result = movieRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));

        return result;
    }

    public Movie findById(Long id) {
        Movie movie = movieRepository.findById(id).get();

        return movie;
    }

    public void create(Movie movie) {
        movieRepository.save(movie);
    }

    public void update(Long id, Movie newMovie) {
        Optional<Movie> oldMovie = movieRepository.findById(id);

        if(oldMovie.isPresent()) {
            Movie movie = oldMovie.get();
            movie.setTitle(newMovie.getTitle());
            movie.setDescription(newMovie.getDescription());
            movie.setYear(newMovie.getYear());
            movie.setImgUrl(newMovie.getImgUrl());

            movieRepository.save(movie);
        }
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
