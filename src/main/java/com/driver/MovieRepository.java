package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Repository
public class MovieRepository {

    Map<String, Movie> movieMap ;
    Map<String, Director> directorMap;
    Map<String, List<String>> pairMap;


    public MovieRepository(){
        this.pairMap = new HashMap<>();
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
    }


    public String addMovie(Movie movie){
        String name = movie.getName();
        if(!movieMap.containsKey(name)) {
            movieMap.put(name, movie);
        }
        return "Movie added successfully";
    }

    // 2 Add a director
    public String addDirector(Director dir){
        String name = dir.getName();
        if(!directorMap.containsKey(name)){
            directorMap.put(name, dir);
        }
        return "Director added successfully";
    }

    // 3 Pair an existing movie and director
    public String addMovieDirectorPair( String movieName,  String directorName){
        if(!movieMap.containsKey(movieName) || !directorMap.containsKey(directorName)) return "Movie or Director not found in data base";
        if(pairMap.containsKey(directorName)){
            pairMap.get(directorName).add(movieName);
        }else{
            List<String> ans = new ArrayList<>();
            ans.add(movieName);
            pairMap.put(directorName, ans);
        }
        return "Movie-Director Pair added successfully";
    }

    // 4 Get Movie by movie name
    public Movie getMovieByName( String name){
        if(!movieMap.containsKey(name)) return null;
        return movieMap.get(name);
    }

    // 5 Get Director by director name
    public Director getDirectorByName( String name){
        if(!directorMap.containsKey(name))return null;

        return directorMap.get(name);
    }

    // 6 Get List of movies name for a given director name
    public List<String> getMoviesByDirectorName( String director){
        return pairMap.get(director);
    }

    // 7 Get List of all movies added
    public List<String> findAllMovies(){
        List<String> ans = new ArrayList<>();
        for (String name: movieMap.keySet()) {
            ans.add(name);
        }
        return ans;
    }

    // 8 Delete a director and its movies from the records
    public String deleteDirectorByName( String directorName){
        List<String> movies = pairMap.get(directorName);
        for (int i = 0; i < movies.size(); i++) {
            if(movieMap.containsKey(movies.get(i))){
                movieMap.remove(movies.get(i));
            }
        }
        pairMap.remove(directorName);
        if(directorMap.containsKey(directorName)){
            directorMap.remove(directorName);
        }
        return "Director and its movies removed successfully";
    }

    // 9 Delete all directors and all movies by them from the records
    public String deleteAllDirectors(){
        for (String dir: pairMap.keySet()) {
            List<String> lis = pairMap.get(dir);
            for (String name: lis) {
                if(movieMap.containsKey(name)){
                    movieMap.remove(name);
                }
            }
            directorMap.remove(dir);
        }
        for (String d: directorMap.keySet()) {
            directorMap.remove(d);
        }

        return "All directors and all of their movies removed successfully";
    }
}
