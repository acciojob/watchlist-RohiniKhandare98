package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    // 1 add movie
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String res = movieService.addMovie(movie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    // 2 Add a director
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director movie){
        String res = movieService.addDirector(movie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    // 3 Pair an existing movie and director
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        String res = movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    // 4 Get Movie by movie name
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
        Movie res = movieService.getMovieByName(name);
        return new ResponseEntity<>(res, HttpStatus.FOUND);
    }

    // 5 Get Director by director name
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        Director res = movieService.getDirectorByName(name);
        return new ResponseEntity<>(res, HttpStatus.FOUND);
    }

    // 6 Get List of movies name for a given director name
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String director){
        List<String> res = movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(res, HttpStatus.FOUND);
    }

    // 7 Get List of all movies added
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> res = movieService.findAllMovies();
        return new ResponseEntity<>(res, HttpStatus.FOUND);
    }

    // 8 Delete a director and its movies from the records
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("directorName") String directorName){
        String res = movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    // 9 Delete all directors and all movies by them from the records
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        String res = movieService.deleteAllDirectors();
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }
}
