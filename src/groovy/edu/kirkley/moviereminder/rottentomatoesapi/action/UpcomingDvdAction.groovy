package edu.kirkley.moviereminder.rottentomatoesapi.action

class UpcomingDvdAction extends AbstractDVDMovieListAction{

    UpcomingDvdAction() {}

    UpcomingDvdAction(String baseUrl, String apiKey, int itemsPerPage = 16, int pageNumber = 1) {
        this.baseUrl = baseUrl
        this.itemsPerPage = itemsPerPage
        this.pageNumber = pageNumber
        this.apiKey = apiKey
    }

    def createInstance(baseUrl, apiKey, itemsPerPage, pageNumber) {
        return new UpcomingDvdAction(baseUrl,apiKey,itemsPerPage,pageNumber)
    }

    def getEndPointJsonFilename() {
        "upcoming"
    }

}
