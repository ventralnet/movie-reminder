package edu.kirkley.moviereminder.service

import groovy.json.JsonSlurper

class MovieService {

    def baseUrl = "http://api.rottentomatoes.com/api/public/v1.0/"
    
    def apiKey = "a8nefdgjj5b9y482v453vmtn"
    
    def pageSize = 9
    
    def getMoviesInTheaters(pageNumber = 1) {
        def movies = Movie.findAll
    }
    
}
