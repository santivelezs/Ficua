<%@page import="com.misiontic.ficua.persistencia.ConexionBD"%>
<%@page import="com.misiontic.ficua.persistencia.ProductoDAO"%>
<%@page import="com.misiontic.ficua.logica.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>


    <body>

        <div class="container mt-5">
            <h3 class="mb-3">Lista de Productos</h3>
            <hr>
            <div class="row mb-3">
                <label for="txt1" class="col-form-label col-sm-2">Filtrar por nombre</label>
                <input type="text" class="col-form-control col-sm-7" id="txt1" name="txt1" value="">
                <button type="button" class="btn btn-light col-sm-1"><i class="bi bi-search"></i></button>
                <a href="productos?accion=nuevo" class="col-sm-2"><button type="submit" class="btn btn-primary" id="btnNuevo">Nuevo producto</button></a>

            </div>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Imagen</th>
                    <th scope="col">Acciones</th>
                </tr>
                </thead>
                <%
                    ProductoDAO dao = new ProductoDAO();
                    boolean hayDatos = false;
                    try {
                        hayDatos = dao.getAll().size() > 0;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
                <tbody>
                <% if (hayDatos) { %>
                <% try {
                    for (Producto p : dao.getAll()) { %>
                <tr>
                    <td scope="row"><%= p.getId() %></td>
                    <td><%= p.getNombre() %></td>
                    <td> <img src="<%= p.getFoto() %>" width="100px" height="100px"> </td>
                    <td>
                        <a href="productos?accion=editar&id=<%= p.getId() %>" class="col-sm-2"><button type="button" class="btn btn-warning"><i class="bi bi-pencil-fill"></i></button></a>
                        <a href="productos?accion=borrar&id=<%= p.getId() %>" class="col-sm-2"><button type="button" class="btn btn-danger"><i class="bi bi-trash"></i></button></a>
                    </td>
                </tr>
                <% }
                } catch (Exception e) {
                    e.printStackTrace();
                } %>
                <% } else { %>
                <tr>
                    <td colspan="5">No hay datos</td>
                </tr>
                <% } %>
                </tbody>
            </table>

    </body>

</html>
