package edu.kirkley.moviereminder.service

import groovy.json.JsonSlurper

class RottenTomatoesAPIService {

    def baseUrl = "http://api.rottentomatoes.com/api/public/v1.0/"
    
    def apiKey = "a8nefdgjj5b9y482v453vmtn"
    
    def executeInTheaterMovieQuery(url) {
        
        def json
        if (url) {
            url += "&apikey=${apiKey}"
            json = url.toURL().getText()
        } else {
            url = "${baseUrl}lists/movies/in_theaters.json?apikey=${apiKey}&page_limit=20&country=us"
            json = url.toURL().getText()
        }
        
        json = new JsonSlurper().parseText(json)
        
        def nextUrl = json.links.next
        
        def movies = json.movies
        
        [movies:movies,nextUrl:nextUrl]
                
    }
}
