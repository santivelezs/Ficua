package com.misiontic.ficua.controlador;

import com.misiontic.ficua.logica.LogicaProductos;
import com.misiontic.ficua.logica.Producto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ControladorProductos extends HttpServlet {


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String pagFormulario = "usuarios_form.jsp";
        String pagLista = "usuarios_lista.jsp";

        String accion = request.getParameter("accion") + "";
        int id = request.getParameter("id")==null ? 0 : Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            case "nuevo":
            case "editar":
                request.setAttribute("id", id);
                request.setAttribute("accion", accion);
                request.getRequestDispatcher(pagFormulario).forward(request, response);
                break;

            case "guardar":
                String nombre = request.getParameter("nombre");
                String url = request.getParameter("url");
                String valorUnitario = request.getParameter("valorUnitario");
                String descripcion = request.getParameter("descripcion");
                Producto producto = new Producto(nombre, url, Float.parseFloat(valorUnitario), descripcion);
                LogicaProductos logica = new LogicaProductos();
                boolean guardado = logica.guardarProducto(producto);
                String html;
                if (guardado) {
                    html = "Producto guardado exitosamente";
                }
                else {
                    html = "Información de producto no se guardó.";
                }
                html += "<a href=\"usuarios\"><button type=\"submit\" class=\"btn btn-primary\" id=\"btnSubmit\">Volver a la lista</button></a>";
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println(html);
                break;

            default:
                request.getRequestDispatcher(pagLista).forward(request, response);
        }
    }
}
