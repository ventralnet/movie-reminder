package edu.kirkley.moviereminder.domain

class Movie {

    static mapping = {
        version false
    }

    static constraints = {
        dvdReleaseDate nullable:true
        mpaaRating nullable:true
        runtime nullable:true
        synopsis nullable:true,maxSize:150000
        thumbnailPosterUrl nullable:true
        profilePosterUrl nullable:true
        detailedPosterUrl nullable:true
        originalPosterUrl nullable:true
    }

    long dbId

    long id

    int pageNumber

    String title

    Date dvdReleaseDate

    Date theaterReleaseDate

    String mpaaRating 

    Integer runtime

    String synopsis

    String thumbnailPosterUrl

    String profilePosterUrl

    String detailedPosterUrl

    String originalPosterUrl

}
