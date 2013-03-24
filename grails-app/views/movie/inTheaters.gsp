<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Movie Reminder!</title>

        <style type="text/css">
            .inTheaterMovieRow {
                text-align:center;
                margin-bottom:50px;
            }
            
            .moviePoster {
                width:120px;
                height:170px;
            }

            .logoImageContainer {
                float:left;
                margin-right:35px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div style="margin-top:10px" class="hero-unit">
                <div class="logoImageContainer">
                    <g:img dir="images" file="film_reel.png"/>
                </div>
    <h1>Movie Reminder</h1>
                <p>Set reminders for when movies in theaters become available on DVD</p>
            </div>
        
            <g:set var="movieRows" value="${movies.collate(3)}"/>
            <g:each in="${movieRows}">
                <div class="row-fluid inTheaterMovieRow">
                    <g:each in="${it}">
                        <div class="span4">
                            <div class="thumbnail">
                                <img class="moviePoster" src="${it.profilePosterUrl}" alt="movie_poster"/>
                                <div class="caption">
                                    <p>${it.title}</p>
                                    <p><a href="#" class="btn btn-primary">Remind!</a>
                                </div>
                            </div>
                        </div>
                    </g:each>
                </div>
            </g:each>
        </div>
    </body>
</html>
