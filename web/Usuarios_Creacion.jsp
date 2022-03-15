<%-- 
    Document   : Usuarios_Creacion
    Created on : 22/02/2022, 01:44:22 PM
    Author     : kcordon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Santo Tomas Port</title>
<jsp:include page="head.jsp" flush="true"></jsp:include>

    <div class="col-lg-12 container-fluid">
        <div class="card">
            <div class="card-header">

                <h3 class="h4 mb-0">All form elements</h3>
            </div>
            <div class="card-body">
                <form class="row g-3 needs-validation" novalidate>
                    
                    <div class="col-md-4">
                        <label for="validationCustom01" class="form-label">Usuario</label>
                        <input type="text" class="form-control" id="validationCustom01"  name="Usuario" required>
                        <div class="valid-feedback">
                            Campo lleno
                        </div>
                    </div>
                    
                    <div class="col-md-4">
                        <label for="validationCustomUsername" class="form-label">Correo</label>
                        <div class="input-group has-validation">
                            <span class="input-group-text" id="inputGroupPrepend">@</span>
                            <input type="text" class="form-control" id="validationCustomUsername" aria-describedby="inputGroupPrepend" required>
                            <div class="invalid-feedback">
                                ingresar correo por favor
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-md-3">
                        <label for="validationCustom04" class="form-label">Entidad a la que pertenece</label>
                        <select class="form-select" id="validationCustom04" required>
                            <option selected disabled value="">Choose...</option>
                            <option>...</option>
                        </select>
                        <div class="invalid-feedback">
                            Please select a valid state.
                        </div>
                    </div>
                    <div class="col-md-3">
                        <label for="validationCustom04" class="form-label">Menu que se le asigna</label>
                        <select class="form-select" id="validationCustom04" required>
                            <option selected disabled value="">Choose...</option>
                            <option>...</option>
                        </select>
                        <div class="invalid-feedback">
                            Please select a valid state.
                        </div>
                    </div>
                    
                    
                    <div class="col-12">
                        <button class="btn btn-primary" type="submit">Crear Usuario</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<script>
    
    // Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })
})()
    
</script>



<jsp:include page="foot.jsp" flush="true"></jsp:include>
