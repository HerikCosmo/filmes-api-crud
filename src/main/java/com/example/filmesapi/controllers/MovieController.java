package com.example.filmesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.filmesapi.services.MovieService;
import com.example.filmesapi.entities.Movie;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    
    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Movie findById(@PathVariable Long id) {
        return movieService.findById(id);
    }
    
    @PostMapping
    public void create(@RequestBody Movie movie){
        movieService.create(movie);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody Movie movie) {
        movieService.update(id, movie);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }
}
