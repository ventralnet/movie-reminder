package edu.kirkley.moviereminder.rottentomatoesapi.action

class InTheatersActionUnitTest extends GroovyTestCase {


    def testConstructsWithDefaultPageNumber() {
        def action = new InTheatersAction(randomString(), randomString(), 16)
        assertEquals(1, action.pageNumber)
    }

    def testConstructsWithDefaultItemsPerPage() {
        def action = new InTheatersAction(randomString(), randomString())
        assertEquals(16, action.itemsPerPage)
    }

    def testGetUrlConstructsCorrectUrl() {
        def baseUrl = randomString()
        def apiKey = randomString()
        def action = new InTheatersAction(baseUrl, apiKey)
        
        def expectedUrl = "${baseUrl}/lists/movies/in_theaters.json?apikey=${apiKey}&page_limit=${action.itemsPerPage}&page=${action.pageNumber}"

        assertEquals(expectedUrl, action.getUrl())
    }

    def randomString() {
        UUID.randomUUID().toString()
    }

}
