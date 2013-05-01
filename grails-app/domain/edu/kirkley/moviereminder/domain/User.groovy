package edu.kirkley.moviereminder.domain

class User {

    static mapping = {
        version false
    }

    static constraints = {
    }

    static hasMany = [reminders: Reminder]

    long id

    String email

    String password
    
    String firstName

    String lastName

    

}
