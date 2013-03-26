package edu.kirkley.moviereminder.controller

import edu.kirkley.moviereminder.domain.User

class UserController {

    def login = {
        def user = User.findByEmailAndPassword(params.email, params.password)
        session.user = user
        redirect(controller:'movie',action:'inTheaters')
    }

    def logout = {
        session.user = null
        redirect(controller:'movie',action:'inTheaters')
    }

    def register = { UserRegistrationCommand urc ->
        if (request.method == 'POST') {
            if (!urc.hasErrors()) {
                def user = new User() 
                user.email = urc.email
                user.firstName = urc.firstName
                user.lastName = urc.lastName
                user.password = urc.password
                user.save()
                if (user.hasErrors()) {
                    throw new RuntimeException("problem saving user..")
                }
                session.user = user
                render "<script type='text/javascript'> window.location.href = '${createLink(controller:'movie',action:'inTheaters')}'  </script>"
            } else {
                render(template: 'registerForm',model:[urc:urc])
            }
        } else {
            render(template: 'registerForm',model:[urc:urc])
        }
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
