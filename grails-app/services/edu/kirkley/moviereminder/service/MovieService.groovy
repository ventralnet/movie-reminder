package edu.kirkley.moviereminder.service

import groovy.json.JsonSlurper
import edu.kirkley.moviereminder.domain.Movie
import edu.kirkley.moviereminder.job.InTheaterCachePopulateJob


class MovieService {
    def pageSize = 200

    
    def getMoviesInTheaters(pageNumber = 1) {
        pageNumber = pageNumber as Integer
        def movies = Movie.findAllByDvdReleaseDateIsNullOrDvdReleaseDateGreaterThan(new Date(),[max:pageSize, offset: (pageNumber-1)*pageSize, sort: "theaterReleaseDate", order:"desc"])
        movies
    }

    def runJob() {
        InTheaterCachePopulateJob.triggerNow()
    }
}
