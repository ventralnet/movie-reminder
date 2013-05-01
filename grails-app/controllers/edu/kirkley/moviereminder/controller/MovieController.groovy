package edu.kirkley.moviereminder.controller

class MovieController {

    def movieService
    
    def inTheaters() {
        def pageNumber = (params.pageNumber ?: 1) as Integer
        def movies = movieService.getMoviesInTheaters(pageNumber)       
        def totalMoviesInTheaters = movieService.countInTheaterMovies()
        def nextPageOfMovies = movieService.getMoviesInTheaters(pageNumber+1)
        [movies:movies,movieCount:totalMoviesInTheaters,nextPage:nextPageOfMovies]
    }

    def runJob() {
        movieService.runJob()
    }

}
