package edu.kirkley.moviereminder.controller

import edu.kirkley.moviereminder.domain.User

class UserController {

    def login = {
        def user = new User(firstname:'Matthew',lastname:'Kirkley',email:'matt.kirkley@gmail.com')
        session.user = user
        redirect(controller:'movie',action:'inTheaters')
    }

    def logout = {
        session.user = null
        redirect(controller:'movie',action:'inTheaters')
    }

    def register = {

    }

}
