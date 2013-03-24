<!DOCTYPE html>
    <head>
        <r:require modules="bootstrap"/>
        <r:require modules="bootstrap-js"/>
        <g:layoutHead/>
        <r:layoutResources />
        <script type="text/javascript">
            $(document).ready(function() {
                <g:if test="!${session.user}">
                    showLoginForm();
                </g:if>    

                <g:if test="${session.user}">
                    displayUserWelcome();
                </g:if>

                function showLoginForm() {
                    $('.loginRegisterContainer').show();
                    $('.userWelcomeContainer').hide();
                }

                function displayUserWelcome() {
                    $('.userWelcomeContainer').show();
                    $('.loginRegisterContainer').hide();
                }
            });
        </script>

        <style type="text/css">
            .userWelcomeContainer {
                float:right;
                color:#999999;
                padding-top:10px;
            }
            .welcomeMessage {
                float:left;
            }
            .logoutLink {
                float:right;
                padding-left:15px;
            }
        </style>
    </head>
    
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <div class="nav-collapse collapse">
                        <div class="loginRegisterContainer">
                            <g:form class="navbar-form pull-right" name="loginForm" action="login" url="[controller:'user',action:'login']">
                                <input class="span2" name="email" id="email" type="text" placeholder="Email">
                                <input class="span2" name="password" id="password" type="password" placeholder="Password">
                                <button type="submit" class="btn">Sign in</button>
                                <p style="display:inline;padding-top:10px">| <a href="#registerModal" data-toggle="modal">Register</a></p>
                            </g:form>
                        </div>
                        <div class="userWelcomeContainer">
                            <p class="welcomeMessage">Welcome, ${session.user?.firstname}!</p>
                            <g:link class="logoutLink" action="logout" controller="user">Logout</g:link>
                        </div>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <!-- register modal --> 
        <div id="registerModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">Register, its free!</h3>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <legend>We will just need a couple pieces of info!</legend>
                    <div class="control-group"> 
                        <label class="control-label">Email</label>
                        <div class="controls">
                            <input type="email" required placeholder="me@me.com"/>
                        </div>
                    </div>
                    <div class="control-group"> 
                        <label class="control-label">First Name</label>
                        <div class="controls">
                            <input type="text" placeholder="First name..."/>
                        </div>
                    </div>
                    <div class="control-group"> 
                        <label class="control-label">Last Name</label>
                        <div class="controls">
                            <input type="text" placeholder="Last name..."/>
                        </div>
                    </div>
                    <div class="control-group"> 
                        <label class="control-label">Password</label>
                        <div class="controls">
                            <input type="password" placeholder="password..."/>
                        </div>
                    </div>
                    <div class="control-group"> 
                        <label class="control-label">Password Verification</label>
                        <div class="controls">
                            <input type="password" placeholder="password verification..."/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
                <button class="btn btn-primary">Register</button>
            </div>
        </div>

        <div class="container">
            <r:layoutResources />
            <g:layoutBody/>
        </div>
    </body>
</html>
