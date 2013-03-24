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

    def register = { UserRegistrationCommand urc ->
        render(template: 'registerForm',model:[urc:urc])
    }

}

class UserRegistrationCommand {
    String email
    String password
    String passwordConfirm
    String firstName
    String lastName
    
    static constraints = {
        email(blank:false)
        firstName(blank:false)
        lastName(blank:false)
        password(blank:false)
        passwordConfirm(
            validator: { passwordConfirm, userRegistrationCommand ->
                 if (passwordConfirm != userRegistrationCommand.password) {
                    return ["passwordmatch"]
                 }
            })
        
        email(email:true,
            validator: { enteredEmail, userRegistrationCommand ->
                def user = User.findByEmail(enteredEmail)
                if (user) {
                    return ["emailunique"]
                }   
            })
    }
}
