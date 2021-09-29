<%-- 
    Document   : vendedores_form
    Created on : 29/09/2021, 10:26:30 a. m.
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <title>Registrar Vendedor</title>
    <div class="container mt-5">
        <h3 class="mb-3">Registro de Vendedores</h3>
        <hr>
        <div class="row">
            <div class="col">
                <form method="post" action="vendedores_ctrl.jsp">
                    <div class="form- mb-2">
                        <label for="txtId">Email</label>
                        <input type="email" class="form-control" id="txtEmail" name="txtEmail" required>
                    </div>
                    <div class="form- mb-2">
                        <label for="txtNombre">Nombre</label>
                        <input type="text" class="form-control" id="txtNombre" name="txtNombre" required>
                    </div>
                    <div class="form- mb-2">
                        <label for="txtApe">Apellidos</label>
                        <input type="text" class="form-control" id="txtApe" name="txtApe" required>
                    </div>
                    <div class="form- mb-2">
                        <label for="txtTel">Telefono</label>
                        <input type="text" class="form-control" id="txtTel" name="txtTel" required>
                    </div>
                    <div class="form- mb-2">
                        <label for="txtNomTienda">Nombre de la Tienda</label>
                        <input type="text" class="form-control" id="txtNomTienda" name="txtNomTienda" required>
                    </div>
                    <div class="form- mb-2">
                        <label for="txtDept">Departamento</label>
                        <input type="text" class="form-control" id="txtDept" name="txtDept" required>
                    </div>
                    <div class="form- mb-2">
                        <label for="txtCiu">Ciudad</label>
                        <input type="text" class="form-control" id="txtCiu" name="txtCiu" required>
                    </div>
                    <div class="form- mb-2">
                        <label for="txtCiu">Ciudad</label>
                        <input type="text" class="form-control" id="txtCiu" name="txtCiu" required>
                    </div>
                    <div class="form- mb-2">
                        <label for="txtCiu">Ciudad</label>
                        <input type="text" class="form-control" id="txtCiu" name="txtCiu" required>
                    </div>
                    <div class="form- mb-2">
                        <label for="txtCiu">Ciudad</label>
                        <input type="text" class="form-control" id="txtCiu" name="txtCiu" required>
                    </div>
                    <div class="form- mb-2">
                        <label for="txtCiu">Ciudad</label>
                        <input type="text" class="form-control" id="txtCiu" name="txtCiu" required>
                    </div>                    
                    <button type="submit" class="btn btn-primary" id="btnSubmit" name="btnSubmit">Guardar</button>
                    <button type="reset" class="btn btn-secondary" id="btnCancel" name="btnCancel">Cancelar</button>                    
                </form>
            </div>
        </div>
    </div>
</head>

<body>

</body>

</html>
