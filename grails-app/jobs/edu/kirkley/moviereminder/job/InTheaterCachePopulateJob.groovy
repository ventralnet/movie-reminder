package edu.kirkley.moviereminder.job

class InTheaterCachePopulateJob {
    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def rottenTomatoesAPIService
    static onlyOnceHack = 0
    def execute() {
        if (onlyOnceHack == 0){
        def result = rottenTomatoesAPIService.executeInTheaterMovieQuery()
        def nextUrl = result.nextUrl
        println nextUrl
        onlyOnceHack++;
        while (nextUrl) {
            nextUrl = rottenTomatoesAPIService.executeInTheaterMovieQuery(nextUrl).nextUrl
            println nextUrl  
            Thread.sleep(500)       
        }
        }
        
    }
}
