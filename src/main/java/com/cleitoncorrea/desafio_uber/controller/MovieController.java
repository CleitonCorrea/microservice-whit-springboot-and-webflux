package com.cleitoncorrea.desafio_uber.controller;

import com.cleitoncorrea.desafio_uber.model.MovieLocation;
import com.cleitoncorrea.desafio_uber.service.MovieLocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieLocationService movieLocationService;

    public MovieController(MovieLocationService movieLocationService){
        this.movieLocationService = movieLocationService;
    }

    @GetMapping
    public List<MovieLocation> getAll(@RequestParam Optional<String> title){
        return title
                .map(movieLocationService::getByTitle)
                .orElseGet(movieLocationService::getAllMovies);
    }
}
