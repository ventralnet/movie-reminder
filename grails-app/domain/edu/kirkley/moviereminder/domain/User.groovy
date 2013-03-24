package edu.kirkley.moviereminder.domain

class User {

    static mapping = {
        version false
    }

    static constraints = {
    }

    long id

    String email

    String password
    
    String firstname

    String lastname

}
