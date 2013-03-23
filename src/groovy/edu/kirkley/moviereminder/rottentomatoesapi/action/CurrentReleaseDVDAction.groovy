package edu.kirkley.moviereminder.rottentomatoesapi.action

class CurrentReleaseDVDAction extends AbstractDVDMovieListAction {

    CurrentReleaseDVDAction(String baseUrl, String apiKey, int itemsPerPage = 16, int pageNumber = 1) {
        this.baseUrl = baseUrl
        this.itemsPerPage = itemsPerPage
        this.pageNumber = pageNumber
        this.apiKey = apiKey
    }

    def createInstance(baseUrl, apiKey, itemsPerPage, pageNumber) {
        new CurrentReleaseDVDAction(baseUrl,apiKey,itemsPerPage,pageNumber)
    }

    def getEndPointJsonFilename() {
        "new_releases"
    }

}
