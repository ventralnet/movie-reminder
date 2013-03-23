package edu.kirkley.moviereminder.job

import edu.kirkley.moviereminder.domain.Movie
import edu.kirkley.moviereminder.rottentomatoesapi.action.InTheatersAction
import edu.kirkley.moviereminder.rottentomatoesapi.action.BoxOfficeAction
import edu.kirkley.moviereminder.rottentomatoesapi.action.OpeningsAction
import edu.kirkley.moviereminder.rottentomatoesapi.action.CurrentReleaseDVDAction
import edu.kirkley.moviereminder.rottentomatoesapi.action.UpcomingDvdAction
import edu.kirkley.moviereminder.rottentomatoesapi.action.NewReleaseDVDAction
import edu.kirkley.moviereminder.rottentomatoesapi.json.JsonToMovieTransformer

import groovy.json.JsonBuilder

class InTheaterCachePopulateJob {
    def cronExpression = "0 0 1 * * ?"

    def baseUrl = "http://api.rottentomatoes.com/api/public/v1.0"
    def apiKey = "a8nefdgjj5b9y482v453vmtn"
    def rottenTomatoesAPIService

    def execute() {
        def transformer = new JsonToMovieTransformer()
        def actions = [new InTheatersAction(baseUrl,apiKey),
                       new OpeningsAction(baseUrl,apiKey),
                       new BoxOfficeAction(baseUrl,apiKey),
                       new CurrentReleaseDVDAction(baseUrl,apiKey),
                       new UpcomingDvdAction(baseUrl,apiKey),
                       new NewReleaseDVDAction(baseUrl,apiKey)]

        actions.each { baseAction ->
            def result = baseAction.getResult()
            def action = baseAction
            while(action){
                result = action.getResult()
                def movies = transformer.transformAll(result.json)

                movies.each {
                    def existingMovie = Movie.findByMovieId(it.movieId)
                    if (!existingMovie) {
                        it.insertDate = new Date()
                        it.save() 
                    } else {
                        existingMovie = updateMovie(existingMovie, it)
                        existingMovie.save()
                    }
                    saveJsonToDisk(result)
                }


                action = result.nextPage
            }
        }
    }

    def updateMovie(existingMovie, updateMovie) {
        existingMovie.movieId = updateMovie.movieId
        existingMovie.title = updateMovie.title
        existingMovie.dvdReleaseDate = updateMovie.dvdReleaseDate
        existingMovie.theaterReleaseDate = updateMovie.theaterReleaseDate
        existingMovie.mpaaRating = updateMovie.mpaaRating
        existingMovie.runtime = updateMovie.runtime
        existingMovie.synopsis = updateMovie.synopsis
        existingMovie.thumbnailPosterUrl = updateMovie.thumbnailPosterUrl
        existingMovie.profilePosterUrl = updateMovie.profilePosterUrl
        existingMovie.detailedPosterUrl = updateMovie.detailedPosterUrl
        existingMovie.originalPosterUrl = updateMovie.originalPosterUrl
        existingMovie.updateDate = new Date()
        existingMovie
    }

    def saveJsonToDisk(result) {
        File jsonFile = getJsonFile(result.thisAction)
        jsonFile.getParentFile().mkdirs()

        jsonFile.createNewFile()
        
        jsonFile.withWriter("UTF-8") { it << result.json }//prettyString }
    }

    def getJsonFile(action) {
        File destinationFolder = new File("C:\\temp\\json")
        Date today = new Date()
        String folderPath = today.format("yyyy\\MM\\dd")
        destinationFolder = new File(destinationFolder, folderPath)
        
        File destinationFile = new File(destinationFolder,"${action.getEndPointJsonFilename()}${action.pageNumber}.json")
        return destinationFile
    }

}
