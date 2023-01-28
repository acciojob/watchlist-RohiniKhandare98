package com.driver;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private String name;
    private int numberOfMovies;
    private double imdbRating;


    public Director(){

    }

    public Director(String name, int numberOfMovies, double imdbrating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbrating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbrating) {
        this.imdbRating = imdbrating;
    }

}
