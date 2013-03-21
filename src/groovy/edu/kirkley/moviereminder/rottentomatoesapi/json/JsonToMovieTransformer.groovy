package edu.kirkley.moviereminder.rottentomatoesapi.json

import edu.kirkley.moviereminder.domain.Movie
import groovy.json.JsonSlurper

class JsonToMovieTransformer {

    private def dateFormat = 'yyyy-MM-dd'

    def transformAll(String json) {
        if (!json) {
            throw new IllegalArgumentException("blank json passed.")
        }

        def jsonMap = new JsonSlurper().parseText(json)  

        jsonMap.movies.collect { movieJson ->
            def movie = new Movie()
            movie.movieId = movieJson.id as Long
            movie.title = movieJson.title
            movie.mpaaRating = movieJson.mpaa_rating
            movie.runtime = toIntegerOrNull(movieJson.runtime)
            movie.synopsis = movieJson.synopsis
            movie.thumbnailPosterUrl = movieJson.posters.thumbnail
            movie.profilePosterUrl = movieJson.posters.profile
            movie.detailedPosterUrl = movieJson.posters.detailed
            movie.originalPosterUrl = movieJson.posters.original
            movie.dvdReleaseDate = toDateOrNull(movieJson.release_dates.dvd)
            movie.theaterReleaseDate = toDateOrNull(movieJson.release_dates.theater)
            movie
        }
    }

    private Integer toIntegerOrNull(possibleNull) {
        try {
            return possibleNull as Integer
        } catch (Exception e) {
            return null
        }
    }

    private Date toDateOrNull(String date) {
        if (date) {
            return Date.parse(dateFormat, date)
        }
        return null
    }

}
