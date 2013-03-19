package edu.kirkley.moviereminder.rottentomatoesapi.action

import groovy.json.JsonSlurper

class InTheatersActionIntegrationTest extends GroovyTestCase {

    def apiKey = "a8nefdgjj5b9y482v453vmtn"

    def baseUrl = "http://api.rottentomatoes.com/api/public/v1.0"

    def endPointUrl = "${baseUrl}/lists/movies/in_theaters.json?apikey=${apiKey}"

    def testFirstPageJson() {
        def pageLimit = 16
        def page = 1
        def expectedJson = "${endPointUrl}&page_limit=${pageLimit}&page=${page}".toURL().getText()

        def parsed = new JsonSlurper().parseText(expectedJson)

        if (!expectedJson || parsed.error) {
            fail("Unable to connect to rotten tomatoes API to start testcase.")            
        }

        InTheatersAction action = new InTheatersAction(baseUrl, apiKey, pageLimit, page)

        def result = action.getResult()

        assertNotNull(result)
        assertEquals(expectedJson, result.json)
    }

    def testFirstAndSecondPageJson() {
        def pageLimit = 16
        def page = 1
        def expectedJsonPageOne = "${endPointUrl}&page_limit=${pageLimit}&page=${page}".toURL().getText()
        def expectedJsonPageTwo = "${endPointUrl}&page_limit=${pageLimit}&page=${page + 1}".toURL().getText()

        def parsed = new JsonSlurper().parseText(expectedJsonPageOne)
        def parsedTwo = new JsonSlurper().parseText(expectedJsonPageTwo)

        if (!expectedJsonPageOne || parsed.error) {
            fail("Unable to connect to rottem tomatoes API to start testcase.")            
        }

        if (!expectedJsonPageTwo || parsedTwo.error) {
            fail("Unable to connect to rottem tomatoes API to start testcase.")            
        }
        InTheatersAction action = new InTheatersAction(baseUrl, apiKey, pageLimit, page)

        def resultPageOne = action.getResult()
        
        assertNotNull(resultPageOne)
        assertEquals(expectedJsonPageOne, resultPageOne.json)

        assertNotNull(resultPageOne.nextPage)

        def resultPageTwo = resultPageOne.nextPage.getResult()
        assertNotNull(resultPageTwo)
        assertEquals(expectedJsonPageTwo, resultPageTwo.json)

        
    }

}
