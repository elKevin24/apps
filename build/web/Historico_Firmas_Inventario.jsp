<%-- 
    Document   : Historico_Firmas_Inventario
    Created on : 18/11/2021, 09:54:28 AM
    Author     : kcordon
--%>
<title>Historico Firmas Inventario</title>
<jsp:include page="head.jsp" flush="true"></jsp:include>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>     
    <link href="datatables_export/buttons.dataTables.min.css" rel="stylesheet" type="text/css"/>
    <link href="datatables_export/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>

    </br>
    <h3>Consulta Firmas de Inventarios de Contenedores Generados</h3>
    </br>
    <div class="container-fluid">
        <div id="calendars">
            <label for="Inicio">Inicio:</label>
            <input type="date" id="Inicio" name="Inicio"><!-- comment -->

            <label for="Final">Final:</label>
            <input type="date" id="Final" name="Final"><!-- comment -->
            <button id="buscar" type="button" class="btn btn-primary btn-sm">Buscar</button>
        </div>
        <div>

        </div>
        <div id="result">
            
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="datatables_export/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="datatables_export/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="datatables_export/dataTables.buttons.min.js" type="text/javascript"></script>
    <script src="datatables_export/jszip.min.js" type="text/javascript"></script>
    <script src="datatables_export/pdfmake.min.js" type="text/javascript"></script>
    <script src="datatables_export/vfs_fonts.js" type="text/javascript"></script>
    <script src="datatables_export/buttons.html5.min.js" type="text/javascript"></script>

    <script>

        $("#buscar").click(function () {
            if ($('#Inicio').val().length == 0 || $('#Final').val().length == 0) {
                alert("Inicio Vacio");
            } else {
                var var1 = $('#Inicio').val();
                var var2 = $('#Final').val();
                var Inicio = var1.split("-").reverse().join("-");
                var Final = var2.split("-").reverse().join("-");
//                console.log(Inicio + " " + Final);

                $.ajax({
                    url: "Invetario",

                    data: {
                        Inicio: Inicio,
                        Final: Final,
                        param: 3
                    },

                    success: function (data) {

                        $("#result").html(data);
                        $(document).ready(function () {
                            $('#example').DataTable({
                                dom: 'Bfrtip',
                                buttons: [

                                    {
                                        extend: 'copyHtml5',
                                        title: 'INVENTARIO DE CONTENEDORES'
                                    },
                                    {
                                        extend: 'excelHtml5',
                                        title: 'INVENTARIO DE CONTENEDORES'
                                    }, {
                                        extend: 'csvHtml5',
                                        title: 'INVENTARIO DE CONTENEDORES'
                                    },
                                    {
                                        extend: 'pdfHtml5',
                                        title: 'INVENTARIO DE CONTENEDORES',
                                        orientation: 'landscape',
                                        pageSize: 'LEGAL'

                                    }
                                ]
                            });
                        });

                    },
                    error: function (jqXHR, textStatus, errorThrown) {

//                        document.getElementById("spinner").style.display = "none";
                    }

                });

            }
        });

        $("#consultar").click(function () {

            $.ajax({
                url: "Invetario",

                data: {
                    firma: $("#firma").val(),
                    usuario: $('#usuario').val(),
                    param: 1
                },

                success: function (data) {
                    $("#datos").html(data);
                    $(document).ready(function () {
                        $('#example').DataTable({
                            dom: 'Bfrtip',
                            buttons: [

                                {
                                    extend: 'copyHtml5',
                                    title: 'INVENTARIO DE CONTENEDORES'
                                },
                                {
                                    extend: 'excelHtml5',
                                    title: 'INVENTARIO DE CONTENEDORES'
                                }, {
                                    extend: 'csvHtml5',
                                    title: 'INVENTARIO DE CONTENEDORES'
                                },
                                {
                                    extend: 'pdfHtml5',
                                    title: 'INVENTARIO DE CONTENEDORES'
                                }
                            ]
                        });
                    });

                }
            });
        });

    </script>

<jsp:include page="foot.jsp" flush="true"></jsp:include>
