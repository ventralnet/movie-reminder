package edu.kirkley.moviereminder.rottentomatoesapi.action

class NewReleaseDVDAction extends AbstractDVDMovieListAction {

    NewReleaseDVDAction(String baseUrl, String apiKey, int itemsPerPage = 16, int pageNumber = 1) {
        this.baseUrl = baseUrl
        this.itemsPerPage = itemsPerPage
        this.pageNumber = pageNumber
        this.apiKey = apiKey
    }

    def createInstance(baseUrl, apiKey, itemsPerPage, pageNumber) {
        new NewReleaseDVDAction(baseUrl,apiKey,itemsPerPage,pageNumber)
    }

    def getEndPointJsonFilename() {
        "current_releases"
    }

}
