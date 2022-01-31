<%-- 
    Document   : head
    Created on : 15/10/2021, 01:11:40 PM
    Author     : kcordon
--%>

<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!--
        <title>Bootstrap Material Admin by Bootstrapious.com</title>-->
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="robots" content="all,follow">
        <!-- Google fonts - Poppins -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
        <!-- Choices CSS-->
        <link rel="stylesheet" href="vendor/choices.js/public/assets/styles/choices.min.css">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/style.blue.css" id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Favicon-->
        <!--<img src="img/EMPORNAC_logo.png" alt=""/>-->
        <link rel="shortcut icon" href="img/Logo (2).png">
        <!-- Tweaks for older IEs--><!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->

        <%

            String usuario = String.valueOf(session.getAttribute("usuario"));

            BeanUsuarios user1 = new BeanUsuarios();
            user1 = Usuario.Usuario_Menu(usuario);

            BeanUsuarios user = new BeanUsuarios();
            user = Usuario.ObtenerUsuario(user1.getCORREO());
            System.out.println("SAT_EMBARQUES");
            if (usuario == "null") {
                System.out.println("entro al if");
                response.sendRedirect("Login.jsp");
            } else {
        %>
    </head>
    <body>
        <div class="page">
            <!-- Main Navbar-->
            <header class="header z-index-50">
                <nav class="navbar py-3 px-0 shadow-sm text-white position-relative">
                    <!-- Search Box-->
                    <div class="search-box shadow-sm">
                        <button class="dismiss d-flex align-items-center">
                            <svg class="svg-icon svg-icon-heavy">
                            <use xlink:href="#close-1"> </use>
                            </svg>
                        </button>
                        <form id="searchForm" action="#" role="search">
                            <input class="form-control shadow-0" type="text" placeholder="What are you looking for...">
                        </form>
                    </div>
                    <div class="container-fluid w-100">
                        <div class="navbar-holder d-flex align-items-center justify-content-between w-100">
                            <!-- Navbar Header-->
                            <div class="navbar-header">
                                <!-- Navbar Brand --><a class="navbar-brand d-none d-sm-inline-block" href="menu.jsp">
                                    <div class="brand-text d-none d-lg-inline-block"><span>EMPORNAC</span><strong>EN LINEA</strong></div>
                                    <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>EMPORNAC</strong></div></a>
                                <!-- Toggle Button--><a class="menu-btn active" id="toggle-btn" href="#"><span></span><span></span><span></span></a>
                            </div>
                            <!-- Navbar Menu -->
                            <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                                <!-- Search-->
                                <li class="nav-item d-flex align-items-center"><a id="search" href="#">
                                        <svg class="svg-icon svg-icon-xs svg-icon-heavy">
                                        <use xlink:href="#find-1"> </use>
                                        </svg></a></li>

                                <li class="nav-item"><a class="nav-link text-white" href="Login.jsp"> <span class="d-none d-sm-inline">Logout</span>
                                        <svg class="svg-icon svg-icon-xs svg-icon-heavy">
                                        <use xlink:href="#security-1"> </use>
                                        </svg></a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <div class="page-content d-flex align-items-stretch"> 
                <!-- Side Navbar -->
                <nav class="side-navbar z-index-40">
                    <!-- Sidebar Header-->
                    <div class="sidebar-header d-flex align-items-center py-4 px-3"><img class="avatar shadow-0 img-fluid rounded-circle" src="img/Logo (2).png" alt="...">
                        <div class="ms-3 title">
                            <h1 class="h4 mb-2">SAT</h1>
                            <p class="text-sm text-gray-500 fw-light mb-0 lh-1"><%= user1.getCORREO()%></p>
                            <!--<p class="text-sm text-gray-500 fw-light mb-0 lh-1"><%= user.getCORREO()%></p>-->
                        </div>
                    </div>
                    <!-- Sidebar Navidation Menus--><span class="text-uppercase text-gray-400 text-xs letter-spacing-0 mx-3 px-2 heading">Menu</span>
                    <ul class="list-unstyled py-4">
                        <li class="sidebar-item active"><a class="sidebar-link" href="menu.jsp"> 
                                <svg class="svg-icon svg-icon-sm svg-icon-heavy me-xl-4">
                                <use xlink:href="#real-estate-1"> </use>
                                </svg>Inicio </a></li>                        


                        <li class="sidebar-item"><a class="sidebar-link" href="#RX" data-bs-toggle="collapse"> 
                                <img src="img/truck.svg" class="svg-icon svg-icon-sm svg-icon-heavy me-xl-4">
                                Rayos X </a></li>
                        <ul class="collapse list-unstyled " id="RX">
                            <li><a class="sidebar-link" href="SAT_HISTORICO_RX.jsp">Consulta Listado</a></li>
                            <!--<li><a class="sidebar-link" href="SAT_ESTADO_RX.jsp">Consulta Estado</a></li>-->
                            <!--<li><a class="sidebar-link" href="Usuarios_Listado_Solicitud.jsp">Listado Solicitudes</a></li>-->
                        </ul>

                        

                    </ul><span class="text-uppercase text-gray-400 text-xs letter-spacing-0 mx-3 px-2 heading">Extras</span>
                    <ul class="list-unstyled py-4">
                        <li class="sidebar-item"><a class="sidebar-link" href="login.html"> 
                                <svg class="svg-icon svg-icon-sm svg-icon-heavy me-xl-2">
                                <use xlink:href="#disable-1"> </use>
                                </svg>Login page </a></li>
                    </ul>
                    <i class="fal fa-truck-container"></i>
                </nav>
                <div id="back" class="content-inner w-100">
                    <!-- Page Header-->

                    <%
                        }

                    %>