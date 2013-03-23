package edu.kirkley.moviereminder.controller

class MovieController {

    def movieService
    
    def inTheaters() {
        def pageNumber = (params.pageNumber ?: 1) as Integer
        def movies = movieService.getMoviesInTheaters(pageNumber)       
        def nextPageOfMovies = movieService.getMoviesInTheaters(pageNumber+1)
        [movies:movies,nextPage:nextPageOfMovies]
    }

    def runJob() {
        movieService.runJob()
    }

}
