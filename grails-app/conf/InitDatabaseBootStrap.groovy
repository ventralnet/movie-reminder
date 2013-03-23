import grails.util.GrailsUtil

import grails.util.Environment
import edu.kirkley.moviereminder.rottentomatoesapi.json.JsonToMovieTransformer

class InitDatabaseBootStrap {

    def init = { servletContext -> 
        switch(GrailsUtil.environment) {
            case "development":
                def sampleJsonFilenames = getSampleJsonFilenames()
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

    private def getSampleJsonFilenames() {
        ["box_office1.json",
        "current_releases1.json",
        "current_releases2.json",
        "current_releases3.json",
        "current_releases4.json",
        "in_theater_page1.json",
        "in_theater_page2.json",
        "in_theater_page3.json",
        "in_theater_page4.json",
        "in_theater_page5.json",
        "in_theater_page6.json",
        "in_theater_page7.json",
        "in_theater_page8.json",
        "in_theater_page9.json",
        "in_theaters1.json",
        "in_theaters2.json",
        "in_theaters3.json",
        "in_theaters4.json",
        "in_theaters5.json",
        "in_theaters6.json",
        "in_theaters7.json",
        "in_theaters8.json",
        "new_releases1.json",
        "new_releases2.json",
        "new_releases3.json",
        "new_releases4.json",
        "opening1.json",
        "upcoming1.json",
        "upcoming2.json",
        "upcoming3.json"]
    }
}
