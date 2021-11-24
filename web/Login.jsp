<%-- 
    Document   : Login
    Created on : 27/10/2021, 03:35:54 PM
    Author     : kcordon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.84.0">
        <title>Signin Empornac</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">


        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Bootstrap core CSS -->
        <!--<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">-->

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>


        <!-- Custom styles for this template -->

        <link href="css/signin.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                background-image: url('img/portada.JPG');
                background-repeat: no-repeat;
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                position: relative;
            }
        </style>
    </head>

    <body class="text-center">

        <main class="form-signin">
            <div class="user_card">
                <form action="Controlador" method="post">
                    <!--<img src="img/EMPORNAC_logo.png" alt=""/>-->


                    <div class="d-flex justify-content-center">
                        <div class="brand_logo_container">                                                                                   
                            <img src="img/Logo (2).png" class="brand_logo" alt="Logo">
                            

                        </div>
                    </div>

                    <!--<h1 class="h3 mb-3 fw-normal">Porfavor Inicie Sesion</h1>-->

                    <div class="form-floating">
                        <input name="usuario" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">Email</label>
                    </div>
                    <div class="form-floating">
                        <input name="clave" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                        <label for="floatingPassword">Contraseña</label>
                    </div>

                    <div class="checkbox mb-3">
                        <label>
                            <input type="checkbox" value="remember-me"> Remember me
                        </label>
                    </div>

                    <button class="w-100 btn btn-lg btn-primary" value="Ingresar" name="accion" type="submit">Sign in</button>


                </form>
                
                        <%
                            String resultado = (String) request.getAttribute("mensaje");
                            String mensaje = "";
                            
                            if (resultado != null) {
                                mensaje = resultado;
                            }
                            request.removeAttribute("mensaje");
                        %>
                       
                  
            </div>
        </main>

        <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
            <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="toast-header">
                    
                    <strong class="me-auto">EMPORNAC</strong>
                    
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
                <div class="toast-body">
                    Contraseña Incorrecta
                </div>
            </div>
        </div>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script>
            $(document).ready(function () {
                
                var msj2 = '<%= mensaje %>';
                
                
                
                if(msj2 == 'false')
                {
                    console.log(msj2);
                    $('.toast').toast('show');
                }
                msj2 = null;
                
            });
        </script>


    </body>
</html>