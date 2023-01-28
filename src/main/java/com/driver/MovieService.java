package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }

    // 2 Add a director
    public String addDirector(Director movie){
        return movieRepository.addDirector(movie);
    }

    // 3 Pair an existing movie and director
    public String addMovieDirectorPair( String movieName,  String directorName){
        return movieRepository.addMovieDirectorPair(movieName, directorName);
    }

    // 4 Get Movie by movie name
    public Movie getMovieByName( String name){
        return movieRepository.getMovieByName(name);
    }

    // 5 Get Director by director name
    public Director getDirectorByName( String name){
        return movieRepository.getDirectorByName(name);
    }

    // 6 Get List of movies name for a given director name
    public List<String> getMoviesByDirectorName(String director){
        return movieRepository.getMoviesByDirectorName(director);
    }

    // 7 Get List of all movies added
    public List<String> findAllMovies(){

        return movieRepository.findAllMovies();
    }

    // 8 Delete a director and its movies from the records
    public String deleteDirectorByName( String directorName){
        return movieRepository.deleteDirectorByName(directorName);
    }

    // 9 Delete all directors and all movies by them from the records
    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }
}
