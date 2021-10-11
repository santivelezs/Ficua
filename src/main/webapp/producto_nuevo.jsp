<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 10/10/2021
  Time: 8:32 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.misiontic.ficua.persistencia.ConexionBD"%>
<%@page import="com.misiontic.ficua.persistencia.ProductoDAO"%>
<%@page import="com.misiontic.ficua.logica.Producto"%>
<%@ page import="com.misiontic.ficua.logica.LogicaProductos" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Agregar producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>
<body>
<div class="container mt-5">
    <h3 class="mb-3">Formulario de productos</h3>
    <hr>
   <%
        String accion = request.getParameter("accion");
        int id;
        String nombre = "";
        String descripcion = "";
        float valorUnitario = 0;
        String foto= "";

        if (accion.equals("editar")) {
            id = Integer.parseInt(request.getParameter("id"));
            LogicaProductos logicaProductos = new LogicaProductos();
            Producto producto = logicaProductos.cargarProducto(id);
            nombre = producto.getNombre();
            descripcion = producto.getDescripcion();
            valorUnitario = producto.getValorUnitario();
            foto = producto.getFoto();

        }
        else {
            id = 0;
        }
    %>
    <form method="post" action="productos">
        <div class="row mb-3">
            <input type="hidden" class="col-form-control col-sm-10" id="id" name="id" value="<%= id %>" readonly>
        </div>
        <div class="row mb-3">
            <label for="nombre" class="col-form-label col-sm-2">Nombre</label>
            <input type="text" class="col-form-control col-sm-10" id="nombre" name="nombre" value="<%= nombre %>" required>
        </div>

        <div class="row mb-3">
            <label for="descripcion" class="col-form-label col-sm-2">Descripcion</label>
            <input type="text" class="col-form-control col-sm-10" id="descripcion" name="descripcion" value="<%= descripcion %>" required>
        </div>

        <div class="row mb-3">
            <label for="foto" class="col-form-label col-sm-2">Foto</label>
            <input type="text" class="col-form-control col-sm-10" id="foto" name="foto" value="<%= foto %>" required>
        </div>

        <div class="row mb-3">
            <label for="valorUnitario" class="col-form-label col-sm-2">Valor Unitario</label>
            <input type="number" step = "0.01" class="col-form-control col-sm-10" id="valorUnitario" name="valorUnitario" value="<%= valorUnitario %>" required>
        </div>


        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button type="submit" class="btn btn-primary" id="btnSubmitSave" name="btnSubmit" value="<%= accion %>">Guardar</button>
            <a href="productos"><button type="button" class="btn btn-secondary" id="btnSubmit" name="btnCancelar">Cancelar</button></a>
        </div>
    </form>
</div>
</body>
</html>
