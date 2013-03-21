package edu.kirkley.moviereminder.rottentomatoesapi.json

class JsonToMovieTransformerUnitTest extends GroovyTestCase {

    def sampleJson = """
        {
          "total": 115,
          "movies": [{
            "id": "770687943",
            "title": "Harry Potter and the Deathly Hallows - Part 2",
            "year": 2011,
            "mpaa_rating": "PG-13",
            "runtime": 130,
            "critics_consensus": "Thrilling, powerfully acted, and visually dazzling, Deathly Hallows Part II brings the Harry Potter franchise to a satisfying -- and suitably magical -- conclusion.",
            "release_dates": {"theater": "2011-07-15"},
            "ratings": {
              "critics_rating": "Certified Fresh",
              "critics_score": 97,
              "audience_rating": "Upright",
              "audience_score": 93
            },
            "synopsis": "Harry Potter and the Deathly Hallows - Part 2, is the final adventure in the Harry Potter film series. The much-anticipated motion picture event is the second of two full-length parts. In the epic finale, the battle between the good and evil forces of the wizarding world escalates into an all-out war. The stakes have never been higher and no one is safe. But it is Harry Potter who may be called upon to make the ultimate sacrifice as he draws closer to the climactic showdown with Lord Voldemort. It all ends here. -- (C) Warner Bros",
            "posters": {
              "thumbnail": "http://content8.flixster.com/movie/11/15/86/11158674_mob.jpg",
              "profile": "http://content8.flixster.com/movie/11/15/86/11158674_pro.jpg",
              "detailed": "http://content8.flixster.com/movie/11/15/86/11158674_det.jpg",
              "original": "http://content8.flixster.com/movie/11/15/86/11158674_ori.jpg"
            },
            "abridged_cast": [
              {
                "name": "Daniel Radcliffe",
                "characters": ["Harry Potter"]
              },
              {
                "name": "Rupert Grint",
                "characters": [
                  "Ron Weasley",
                  "Ron Wesley"
                ]
              },
              {
                "name": "Emma Watson",
                "characters": ["Hermione Granger"]
              },
              {
                "name": "Helena Bonham Carter",
                "characters": ["Bellatrix Lestrange"]
              },
              {
                "name": "Ralph Fiennes",
                "characters": ["Lord Voldemort"]
              }
            ],
            "alternate_ids": {"imdb": "1201607"},
            "links": {
              "self": "http://api.rottentomatoes.com/api/public/v1.0/movies/770687943.json",
              "alternate": "http://www.rottentomatoes.com/m/harry_potter_and_the_deathly_hallows_part_2/",
              "cast": "http://api.rottentomatoes.com/api/public/v1.0/movies/770687943/cast.json",
              "clips": "http://api.rottentomatoes.com/api/public/v1.0/movies/770687943/clips.json",
              "reviews": "http://api.rottentomatoes.com/api/public/v1.0/movies/770687943/reviews.json",
              "similar": "http://api.rottentomatoes.com/api/public/v1.0/movies/770687943/similar.json"
            }
          }],
          "links": {
            "self": "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/in_theaters.json?page_limit=1&country=us&page=1",
            "next": "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/in_theaters.json?page_limit=1&country=us&page=2",
            "alternate": "http://www.rottentomatoes.com/movie/in_theaters.php"
          },
          "link_template": "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/in_theaters.json?page_limit={results_per_page}&page={page_number}&country={country-code}"
        }
         
   """

    def testSetsMovieIdCorrectly() {
        def movies = new JsonToMovieTransformer().transformAll(sampleJson)
        assertEquals(1, movies.size())
        def movie = movies[0]
        assertEquals(770687943,movie.movieId)

    }

    def testSetsMovieTitleCorrectly() {
        def movies = new JsonToMovieTransformer().transformAll(sampleJson)
        assertEquals(1, movies.size())
        def movie = movies[0]
        assertEquals("Harry Potter and the Deathly Hallows - Part 2",movie.title)
    }

    def testSetsMovieMpaaRatingCorrectly() {
        def movies = new JsonToMovieTransformer().transformAll(sampleJson)
        assertEquals(1, movies.size())
        def movie = movies[0]
        assertEquals("PG-13",movie.mpaaRating)
    }

    def testSetsMovieRuntimeCorrectly() {
        def movies = new JsonToMovieTransformer().transformAll(sampleJson)
        assertEquals(1, movies.size())
        def movie = movies[0]
        assertEquals(130,movie.runtime)
    }

    def testSetsMovieThumbnailPosterUrlCorrectly() {
        def movies = new JsonToMovieTransformer().transformAll(sampleJson)
        assertEquals(1, movies.size())
        def movie = movies[0]
        assertEquals("http://content8.flixster.com/movie/11/15/86/11158674_mob.jpg",movie.thumbnailPosterUrl)
    }

    def testSetsMovieProfilePosterUrlCorrectly() {
        def movies = new JsonToMovieTransformer().transformAll(sampleJson)
        assertEquals(1, movies.size())
        def movie = movies[0]
        assertEquals("http://content8.flixster.com/movie/11/15/86/11158674_pro.jpg",movie.profilePosterUrl)
    }

    def testSetsMovieDetailedPosterUrlCorrectly() {
        def movies = new JsonToMovieTransformer().transformAll(sampleJson)
        assertEquals(1, movies.size())
        def movie = movies[0]
        assertEquals("http://content8.flixster.com/movie/11/15/86/11158674_det.jpg",movie.detailedPosterUrl)
    }

    def testSetsMovieOriginalPosterUrlCorrectly() {
        def movies = new JsonToMovieTransformer().transformAll(sampleJson)
        assertEquals(1, movies.size())
        def movie = movies[0]
        assertEquals("http://content8.flixster.com/movie/11/15/86/11158674_ori.jpg",movie.originalPosterUrl)
    }

    def testSetsMovieSynopsisCorrectly() {
        def movies = new JsonToMovieTransformer().transformAll(sampleJson)
        assertEquals(1, movies.size())
        def movie = movies[0]

        def expectedSynopsis = "Harry Potter and the Deathly Hallows - Part 2, is the final adventure in the Harry Potter film series. The much-anticipated motion picture event is the second of two full-length parts. In the epic finale, the battle between the good and evil forces of the wizarding world escalates into an all-out war. The stakes have never been higher and no one is safe. But it is Harry Potter who may be called upon to make the ultimate sacrifice as he draws closer to the climactic showdown with Lord Voldemort. It all ends here. -- (C) Warner Bros"

        assertEquals(expectedSynopsis,movie.synopsis)
    }
}

