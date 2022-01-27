<%-- 
    Document   : Historico_Firmas_Inventario
    Created on : 18/11/2021, 09:54:28 AM
    Author     : kcordon
--%>

<%@page import="modelo.SAT"%>
<%@page import="controlador.BeanRX"%>
<%@page import="java.util.LinkedList"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    if (session.getAttribute("usuario") == null) {
        System.out.println(session.getAttribute("usuario") == null);
        response.sendRedirect("Login.jsp");
    }
%>
<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Compiled and minified JavaScript -->
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>     
        <link href="datatables_export/buttons.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <link href="datatables_export/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>


        <title>INFORMACION RX</title>
        <jsp:include page="head.jsp" flush="true"></jsp:include>

            <style>
                h3{
                    text-align: center;
                }
            </style>
        </head>


        <div class="container-fluid">
            <div class="row gy-4">
                <div class="col-lg-4">
                    <div class="card mb-0">

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table mb-0 table-striped table-sm display" id="example">
                                    <thead>
                                        <tr>
                                            <th colspan="3">PREDIO MARIA LUISA / SALA DE CONTROL</th>
                                        </tr>
                                        <tr>
                                            <th>#</th>
                                            <th>Contenedor</th>
                                            <th>Fecha Hora Recepcion</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        LinkedList<BeanRX> lista = SAT.Sala_de_Control();

                                        for (int i = 0; i < lista.size(); i++) {
                                            out.println("<tr>");
                                            //out.println("<td class='text-center'>" + lista.get(i).getVIAJE_EMPORNAC() + "</td>");
                                            out.println("<td class='text-center'>" + (i + 1) + "</td>");
                                            out.println("<td class='text-center'>" + lista.get(i).getPREFIJO() + "</td>");
                                            out.println("<td class='text-center'>" + lista.get(i).getFECHA_ESCANEO() + "</td>");
                                            out.println("</tr>");
                                        }

                                    %>


                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="card mb-0">
                    <div class="card-header">
                        <div class="card-close">
                            <div class="dropdown">
                                <button class="dropdown-toggle text-sm" type="button" id="closeCard1" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-ellipsis-v"></i></button>
                                <div class="dropdown-menu dropdown-menu-end shadow-sm" aria-labelledby="closeCard1"><a class="dropdown-item py-1 px-3 remove" href="#"> <i class="fas fa-times"></i>Close</a><a class="dropdown-item py-1 px-3 edit" href="#"> <i class="fas fa-cog"></i>Edit</a></div>
                            </div>
                        </div>
                        <h3 class="h4 mb-0">Compact Table</h3>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table mb-0 table-striped table-sm display" id="example">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Contenedor</th>
                                        <th>Fecha Hora Recepcion</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%                                    LinkedList<BeanRX> lista1 = SAT.Sala_de_Control();

                                        for (int i = 0; i < lista.size(); i++) {
                                            out.println("<tr>");
                                            //out.println("<td class='text-center'>" + lista.get(i).getVIAJE_EMPORNAC() + "</td>");
                                            out.println("<td class='text-center'>" + (i + 1) + "</td>");
                                            out.println("<td class='text-center'>" + lista.get(i).getPREFIJO() + "</td>");
                                            out.println("<td class='text-center'>" + lista.get(i).getFECHA_ESCANEO() + "</td>");
                                            out.println("</tr>");
                                        }

                                    %>


                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="card mb-0">
                    <div class="card-header">
                        <div class="card-close">
                            <div class="dropdown">
                                <button class="dropdown-toggle text-sm" type="button" id="closeCard1" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-ellipsis-v"></i></button>
                                <div class="dropdown-menu dropdown-menu-end shadow-sm" aria-labelledby="closeCard1"><a class="dropdown-item py-1 px-3 remove" href="#"> <i class="fas fa-times"></i>Close</a><a class="dropdown-item py-1 px-3 edit" href="#"> <i class="fas fa-cog"></i>Edit</a></div>
                            </div>
                        </div>
                        <h3 class="h4 mb-0">Compact Table</h3>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table mb-0 table-striped table-sm display" id="example">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Contenedor</th>
                                        <th>Fecha Hora Recepcion</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%                                    LinkedList<BeanRX> lista2 = SAT.Sala_de_Control();

                                        for (int i = 0; i < lista.size(); i++) {
                                            out.println("<tr>");
                                            //out.println("<td class='text-center'>" + lista.get(i).getVIAJE_EMPORNAC() + "</td>");
                                            out.println("<td class='text-center'>" + (i + 1) + "</td>");
                                            out.println("<td class='text-center'>" + lista.get(i).getPREFIJO() + "</td>");
                                            out.println("<td class='text-center'>" + lista.get(i).getFECHA_ESCANEO() + "</td>");
                                            out.println("</tr>");
                                        }

                                    %>


                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script><!--
    
    <script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    -->        <script src="datatables_export/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="datatables_export/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="datatables_export/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="datatables_export/jszip.min.js" type="text/javascript"></script>
    <script src="datatables_export/pdfmake.min.js" type="text/javascript"></script>
    <script src="datatables_export/vfs_fonts.js" type="text/javascript"></script>
    <script src="datatables_export/buttons.html5.min.js" type="text/javascript"></script><!--
    
    -->        <script>


        $(document).ready(function () {

            $('example tfoot th').each(function () {
                var title = $(this).text();
                $(this).html('<input type="text" placeholder="Search ' + title + '" />');
            });
            
            var table = $('table.display').DataTable({
                "order": [[2, "asc"]],
                "aLengthMenu": [[16, 50, 75, -1], [25, 50, 75, "All"]],
                "iDisplayLength": 16,
                dom: 'Bfrtip',
                buttons: [

//                        {
//                            extend: 'copyHtml5',
//                            title: 'INVENTARIO DE CONTENEDORES'
//                        },
                    {
                        extend: 'excelHtml5',
                        title: 'INVENTARIO DE CONTENEDORES'
                    },
//                        {
//                            extend: 'csvHtml5',
//                            title: 'INVENTARIO DE CONTENEDORES'
//                        },
                    {
                        extend: 'pdfHtml5',
                        title: 'INVENTARIO DE CONTENEDORES',

                        pageSize: 'LEGAL'

                    }
                ],
                initComplete: function () {
                    // Apply the search
                    this.api().columns().every(function () {
                        var that = this;

                        $('input', this.footer()).on('keyup change clear', function () {
                            if (that.search() !== this.value) {
                                that
                                        .search(this.value)
                                        .draw();
                            }
                        });
                    });
                }
            });
            
            
        });



    </script>

    <jsp:include page="foot.jsp" flush="true"></jsp:include>
