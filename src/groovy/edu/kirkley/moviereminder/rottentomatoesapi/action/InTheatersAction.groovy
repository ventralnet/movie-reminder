package edu.kirkley.moviereminder.rottentomatoesapi.action

import groovy.json.JsonSlurper

class InTheatersAction {

    String baseUrl

    int itemsPerPage

    int pageNumber

    String firstPageUrl

    String apiKey

    InTheatersAction() {}

    InTheatersAction(String baseUrl, String apiKey, int itemsPerPage = 16, int pageNumber = 1) {
        this.baseUrl = baseUrl
        this.itemsPerPage = itemsPerPage
        this.pageNumber = pageNumber
        this.apiKey = apiKey
    }

    def getResult() {
        def currentUrl = getUrl() 

        def json = currentUrl.toURL().getText()

        def jsonMap = new JsonSlurper().parseText(json)  

        //def prevUrl = jsonMap.links.self

        def nextUrl = jsonMap.links.next

        def nextPageTheaterAction
        if (nextUrl) {
            nextPageTheaterAction = new InTheatersAction(baseUrl, apiKey, itemsPerPage, pageNumber+1)
        }

        [thisAction:this,json:json,movies:jsonMap,nextPage:nextPageTheaterAction]
    }

    def getUrl() {
        "${baseUrl}/lists/movies/in_theaters.json?apikey=${apiKey}&page_limit=${itemsPerPage}&page=${pageNumber}"
    }
}
