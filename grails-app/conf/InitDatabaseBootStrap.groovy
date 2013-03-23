import grails.util.GrailsUtil

import grails.util.Environment
import edu.kirkley.moviereminder.rottentomatoesapi.json.JsonToMovieTransformer

class InitDatabaseBootStrap {

    def init = { servletContext -> 
        switch(GrailsUtil.environment) {
            case "development":
                def sampleJsonFilenames = ["in_theater_page1.json", "in_theater_page2.json", "in_theater_page3.json", "in_theater_page4.json", "in_theater_page5.json", "in_theater_page6.json", "in_theater_page7.json", "in_theater_page8.json", "in_theater_page9.json"]
                sampleJsonFilenames.each { filename ->
                    final URL resource = this.getClass().getClassLoader().getResource("resources/${filename}");
                    def jsonToMovieTransformer = new JsonToMovieTransformer()
                    def movies = jsonToMovieTransformer.transformAll(resource.text)
                    movies*.insertDate = new Date()
                    movies.each{ it.save() }
                }
                
            case "production":
            break
        } 
    }

    def destroy = {
    }

}
