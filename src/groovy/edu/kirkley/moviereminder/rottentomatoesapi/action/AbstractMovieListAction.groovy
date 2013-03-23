package edu.kirkley.moviereminder.rottentomatoesapi.action

import groovy.json.JsonSlurper

abstract class AbstractMovieListAction {

    String baseUrl

    int itemsPerPage

    int pageNumber

    String firstPageUrl

    String apiKey

    AbstractMovieListAction() {}

    AbstractMovieListAction(String baseUrl, String apiKey, int itemsPerPage = 50, int pageNumber = 1) {
        this.baseUrl = baseUrl
        this.itemsPerPage = itemsPerPage
        this.pageNumber = pageNumber
        this.apiKey = apiKey
    }

    def getResult() {
        def currentUrl = getUrl()

        def json = currentUrl.toURL().getText()

        def jsonMap = new JsonSlurper().parseText(json)

        def nextUrl = jsonMap.links.next

        def nextPageAction
        if (nextUrl) {
            nextPageAction = createInstance(baseUrl, apiKey, itemsPerPage, pageNumber+1)
        }

        [thisAction:this,json:json,movies:jsonMap,nextPage:nextPageAction]
    }

    
    abstract createInstance(baseUrl, apiKey, itemsPerPage, pageNumber)

    def getUrl() {
        "${baseUrl}/lists/${getURLListType()}/${getEndPointJsonFilename()}.json?apikey=${apiKey}&page_limit=${itemsPerPage}&page=${pageNumber}&limit=${itemsPerPage}"
    }
    
    def getURLListType() {
        "movies"
    }
    
    abstract getEndPointJsonFilename()
}
