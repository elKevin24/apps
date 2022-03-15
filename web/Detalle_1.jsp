<%-- 
    Document   : Detalle
    Created on : 17/11/2020, 10:06:01 AM
    Author     : kcordon
--%>



<%@page import="controlador.BeanCarta_Detalle"%>
<%@page import="modelo.detalle_carta"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modelo.Carta"%>
<%@page import="controlador.BeanCarta"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="head.jsp" flush="true"></jsp:include>

    <link href="css/timeline.css" rel="stylesheet" type="text/css"/>
    <link href="css/color.css" rel="stylesheet" type="text/css"/>

<%
    String consulta = request.getParameter("consulta");
    BeanCarta enc = new BeanCarta();
    enc = Carta.ConsultarVer(consulta);
    String Entrada = Carta.Consultar_Entrada(consulta);
    String autorizacion_recepcion = Carta.Consulta_Recepcion(consulta);
    String Bascula = Carta.Consulta_Bascula(autorizacion_recepcion);
    System.err.println("+Bascula+" + Bascula);

    System.err.println(" " + Entrada);
    int numero = 0;

    if (enc.getRW_ESTADO().equals("1")) {
        numero = 0;
    } else if (enc.getRW_ESTADO().equals("2")) {
        numero = 20;

    } else if (enc.getRW_ESTADO().equals("3") || enc.getRW_ESTADO().equals("4")) {
        numero = 40;

    } else if (enc.getRW_ESTADO().equals("5") || enc.getRW_ESTADO().equals("6")) {
        numero = 60;

    }

    if (!Entrada.equalsIgnoreCase(" ")) {
        numero = 80;
    }
    if (!Bascula.equalsIgnoreCase(" ")) {
        numero = 100;
    }


%>



</head>
<body>
    <div class="container">

        <br>

        <h5 class="text-center"> Estado de Carta Porte del Contenedor <%= enc.getRW_PREFIJO_CONT() + enc.getRW_IDENTIFICACION_CONT()%> </h5>

        <br>

        <div class="position-relative">
            <p class="parraf" style=" left:0%;">Creacion</p>
            <p class="parraf" style=" left:14%;">Enviado a Empornac</p>
            <p class="parraf" style=" left:35%;">Agendamiento</p>
            <p class="parraf" style=" left:55%;">Recepcion</p>
            <p class="parraf" style=" left:76%;">Entrada</p>
            <p class="parraf" style=" left:96%;">Bascula</p>
        </div>
        <br>

        <div class="position-relative m-4">
            <div class="progress" style="height: 1px;">
                <div class="progress-bar" role="progressbar" style="width: <%= numero%>%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
            <button type="button" class="position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill" data-bs-toggle="tooltip" data-bs-placement="top" title="Hora creacion: <%= enc.getRW_FECHA_RECEPCION_WEB()%>" style="width: 2rem; height:2rem; left:0">1</button>
            <button type="button" class="position-absolute top-0 translate-middle btn btn-sm btn-secondary rounded-pill" data-bs-toggle="tooltip" data-bs-placement="top" title="" style="width: 2rem; height:2rem; left:20%">2</button>
            <button type="button" class="position-absolute top-0 translate-middle btn btn-sm btn-secondary rounded-pill" data-bs-toggle="tooltip" data-bs-placement="top" title="" style="width: 2rem; height:2rem; left:40%">3</button>
            <button type="button" class="position-absolute top-0 translate-middle btn btn-sm btn-secondary rounded-pill" data-bs-toggle="tooltip" data-bs-placement="top" title="" style="width: 2rem; height:2rem; left:60%">4</button>
            <button type="button" class="position-absolute top-0 translate-middle btn btn-sm btn-secondary rounded-pill" data-bs-toggle="tooltip" data-bs-placement="top" title="" style="width: 2rem; height:2rem; left:80%">5</button>
            <button type="button" class="position-absolute top-0 translate-middle btn btn-sm btn-secondary rounded-pill" data-bs-toggle="tooltip" data-bs-placement="top" title="" style="width: 2rem; height:2rem; left:100%">6</button>
            <!--<button type="button" class="position-absolute top-0 translate-middle btn btn-sm btn-secondary rounded-pill" data-bs-toggle="tooltip" data-bs-placement="top" title="" style="width: 2rem; height:2rem; left:100%">5</button>-->

            <%

                LinkedList<BeanCarta> lista = Carta.ConsultarT(consulta);

                for (int i = 0; i < lista.size(); i++) {
                    int a = 25;
                    if (lista.get(i).getRWTE_RWE().equals("2")) {

                        //out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='"+lista.get(i).getRWTE_FECHA()+"' style='width: 2rem; height:2rem; left:"+ (25+i*25)+"%'>"+(i+2)+"</button>");
                        out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='" + lista.get(i).getRWTE_FECHA() + "' style='width: 2rem; height:2rem; left:20%'>2</button>");
                    }
                    if (lista.get(i).getRWTE_RWE().equals("3")) {

                        //out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='"+lista.get(i).getRWTE_FECHA()+"' style='width: 2rem; height:2rem; left:"+ (25+i*25)+"%'>"+(i+2)+"</button>");
                        out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='" + lista.get(i).getRWTE_FECHA() + "' style='width: 2rem; height:2rem; left:40%'>3</button>");
                    }
                    if (lista.get(i).getRWTE_RWE().equals("4")) {

                        //out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='"+lista.get(i).getRWTE_FECHA()+"' style='width: 2rem; height:2rem; left:"+ (25+i*25)+"%'>"+(i+2)+"</button>");
                        out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-danger rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='RECHAZADA: " + lista.get(i).getRWTE_FECHA() + " Motivo:  " + lista.get(i).getRw_observaciones_opip() + "' style='width: 2rem; height:2rem; left:40%'>3</button>");
                    }

                    if (lista.get(i).getRWTE_RWE().equals("5")) {

                        //out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='"+lista.get(i).getRWTE_FECHA()+"' style='width: 2rem; height:2rem; left:"+ (25+i*25)+"%'>"+(i+2)+"</button>");
                        out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='" + lista.get(i).getRWTE_FECHA() + "' style='width: 2rem; height:2rem; left:60%'>4</button>");
                    }

                    if (lista.get(i).getRWTE_RWE().equals("6")) {

                        //out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='"+lista.get(i).getRWTE_FECHA()+"' style='width: 2rem; height:2rem; left:"+ (25+i*25)+"%'>"+(i+2)+"</button>");
                        out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-danger rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='" + lista.get(i).getRWTE_FECHA() + "' style='width: 2rem; height:2rem; left:60%'>4</button>");
                    }
//                        if (lista.get(i).getRWTE_RWE().equals("7")) {
//
//                            //out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='"+lista.get(i).getRWTE_FECHA()+"' style='width: 2rem; height:2rem; left:"+ (25+i*25)+"%'>"+(i+2)+"</button>");
//                            out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='" + lista.get(i).getRWTE_FECHA() + "' style='width: 2rem; height:2rem; left:100%'>5</button>");
//                        }

                    if (!Entrada.equalsIgnoreCase(" ")) {
                        out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='" + Entrada + "' style='width: 2rem; height:2rem; left:80%'>5</button>");

                    }
                    if (!Bascula.equalsIgnoreCase(" ")) {
                         out.println("<button type='button' class='position-absolute top-0 translate-middle btn btn-sm btn-primary rounded-pill' data-bs-toggle='tooltip' data-bs-placement='top' title='" + Entrada + "' style='width: 2rem; height:2rem; left:100%'>6</button>");

                    }

                }

            %>  

        </div>
    </div>


    <!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>-->

    <script type="text/javascript">
        $(function () {
            $("[data-bs-toggle='tooltip']").tooltip();
        });
    </script>

    <jsp:include page="foot.jsp" flush="true"></jsp:include>
