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

        <g:render template="/user/registerPopup"></g:render>

        <div class="container">
            <r:layoutResources />
            <g:layoutBody/>
        </div>
    </body>
</html>
