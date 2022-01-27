<%-- 
    Document   : cambia_pass
    Created on : 9/12/2021, 03:42:24 PM
    Author     : kcordon
--%>

<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>EMPORNAC</title>
        <style>

            .ocultar {
                display: none;
            }

            .mostrar {
                display: block;
            }
            input {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-top: 6px;
                margin-bottom: 16px;
            }

            /* Style the submit button */
            input[type=submit] {
                background-color: #04AA6D;
                color: white;
            }

            /* Style the container for inputs */
            .container {
                background-color: #f1f1f1;
                padding: 20px;
            }

            /* The message box is shown when the user clicks on the password field */
            #message {
                display:none;
                background: #f1f1f1;
                color: #000;
                position: relative;
                padding: 20px;
                margin-top: 10px;
            }

            #message p {
                padding: 10px 35px;
                font-size: 18px;
            }

            /* Add a green text color and a checkmark when the requirements are right */
            .valid {
                color: green;
            }

            .valid:before {
                position: relative;
                left: -35px;
                content: "✔";
            }

            /* Add a red text color and an "x" when the requirements are wrong */
            .invalid {
                color: red;
            }

            .invalid:before {
                position: relative;
                left: -35px;
                content: "✖";
            }


        </style>
        <%

            String usuario = String.valueOf(session.getAttribute("usuario"));
            BeanUsuarios user = new BeanUsuarios();

            BeanUsuarios user1 = new BeanUsuarios();
            user1 = Usuario.Usuario_Menu(usuario);

            user = Usuario.ObtenerUsuario(user1.getCORREO());

            System.err.println("Usuario " + usuario);
            System.err.println("USUARIO_DE_SERVICIO " + user.getUSUARIO_DE_SERVICIO());
            System.err.println("USER ID " + user.getUSERID());


        %>
    </head>
    <body>
        <!--<div class="container">-->
        <div class="col-md-6 offset-md-3">
            <span class="anchor" id="formChangePassword"></span>
            <!--<hr class="mb-5">-->
            <div class="card card-outline-secondary">
                <div class="card-header">
                    <h3 class="mb-0">Cambiar Contraseña</h3>
                </div>
                <div class="card-body">
                    <div id="msg"></div>

                    <!-- Mensajes de Verificación -->
                    <div id="error" class="alert alert-danger ocultar" role="alert">
                        Las Contraseñas no coinciden, vuelve a intentar !
                    </div>
                    <div id="ok" class="alert alert-success ocultar" role="alert">
                        Las Contraseñas coinciden ! (Procesando formulario ... )
                    </div>

                    <form id="miformulario" onsubmit="return verificarPasswords();" autocomplete="off" action="ServletPass" method="post">
                        <div class="form-group">
                            <label for="usuario">Usuario</label>
                            <input type="text" class="form-control" id="usuario" value="<%= user1.getCORREO()%>" required disabled>
                            <input type="hidden" class="form-control" id="id_usuario" name="id_usuario" value="<%= usuario%>" required>
                        </div>
                        <div class="form-group">
                            <label for="pass1">Contraseña</label>
                            <input type="password" class="form-control" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" id="pass1" name="pass1" required>
                        </div>
                        <div class="form-group">
                            <label for="pass2">Vuelve a escribir la Contraseña</label>
                            <input type="password" class="form-control" id="pass2" required>
                        </div>

                        <button type="submit" id="login" class="btn btn-primary">Cambiar Contraseña</button>
                    </form>

                    <div id="message">
                        <h3>La contraseña debe contener los siguientes elementos   </h3>
                        <p id="letter" class="invalid">1 <b>letra</b> minuscula</p>
                        <p id="capital" class="invalid">1 <b>letra</b> mayuscula</p>
                        <p id="number" class="invalid">1<b>numero</b></p>
                        <p id="length" class="invalid">8 <b>caracteres minimo</b></p>
                    </div>
                </div>
            </div>
        </div>





        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        -->
        <script>
                        var myInput = document.getElementById("pass1");
                        var letter = document.getElementById("letter");
                        var capital = document.getElementById("capital");
                        var number = document.getElementById("number");
                        var length = document.getElementById("length");

                        // When the user clicks on the password field, show the message box
                        myInput.onfocus = function () {
                            document.getElementById("message").style.display = "block";
                        }

                        // When the user clicks outside of the password field, hide the message box
                        myInput.onblur = function () {
                            document.getElementById("message").style.display = "none";
                        }

                        // When the user starts to type something inside the password field
                        myInput.onkeyup = function () {
                            // Validate lowercase letters
                            var lowerCaseLetters = /[a-z]/g;
                            if (myInput.value.match(lowerCaseLetters)) {
                                letter.classList.remove("invalid");
                                letter.classList.add("valid");
                            } else {
                                letter.classList.remove("valid");
                                letter.classList.add("invalid");
                            }

                            // Validate capital letters
                            var upperCaseLetters = /[A-Z]/g;
                            if (myInput.value.match(upperCaseLetters)) {
                                capital.classList.remove("invalid");
                                capital.classList.add("valid");
                            } else {
                                capital.classList.remove("valid");
                                capital.classList.add("invalid");
                            }

                            // Validate numbers
                            var numbers = /[0-9]/g;
                            if (myInput.value.match(numbers)) {
                                number.classList.remove("invalid");
                                number.classList.add("valid");
                            } else {
                                number.classList.remove("valid");
                                number.classList.add("invalid");
                            }

                            // Validate length
                            if (myInput.value.length >= 8) {
                                length.classList.remove("invalid");
                                length.classList.add("valid");
                            } else {
                                length.classList.remove("valid");
                                length.classList.add("invalid");
                            }
                        }
        </script>

        <script>

            function verificarPasswords() {

                // Ontenemos los valores de los campos de contraseñas 
                pass1 = document.getElementById('pass1');
                pass2 = document.getElementById('pass2');

                // Verificamos si las constraseñas no coinciden 
                if (pass1.value != pass2.value) {

                    // Si las constraseñas no coinciden mostramos un mensaje 
                    document.getElementById("error").classList.add("mostrar");

                    return false;
                } else {

                    // Si las contraseñas coinciden ocultamos el mensaje de error
                    document.getElementById("error").classList.remove("mostrar");

                    // Mostramos un mensaje mencionando que las Contraseñas coinciden 
                    document.getElementById("ok").classList.remove("ocultar");

                    // Desabilitamos el botón de login 
//                    document.getElementById("login").disabled = true;

                    // Refrescamos la página (Simulación de envío del formulario) 


                    return true;
                }

            }


        </script>
    </body>
</html>