package edu.kirkley.moviereminder.rottentomatoesapi.action

import groovy.json.JsonSlurper

class BoxOfficeAction extends AbstractMovieListAction {

    BoxOfficeAction() {}

    BoxOfficeAction(String baseUrl, String apiKey, int itemsPerPage = 16, int pageNumber = 1) {
        this.baseUrl = baseUrl
        this.itemsPerPage = itemsPerPage
        this.pageNumber = pageNumber
        this.apiKey = apiKey
    }

    def createInstance(baseUrl, apiKey, itemsPerPage, pageNumber) {
        return new BoxOfficeAction(baseUrl,apiKey,itemsPerPage,pageNumber)
    }

    def getEndPointJsonFilename() {
        "box_office"
    }
}
