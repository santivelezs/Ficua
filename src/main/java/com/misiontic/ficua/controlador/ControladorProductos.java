package com.misiontic.ficua.controlador;

import com.misiontic.ficua.logica.LogicaProductos;
import com.misiontic.ficua.logica.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ControladorProductos extends HttpServlet {


    public ControladorProductos() {
    }

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
        String accion = request.getParameter("accion") + "";

        switch (accion){
            case "nuevo":
            case "editar":
                request.getRequestDispatcher("producto_nuevo.jsp").forward(request, response);
                break;
            case "borrar":
                int id = Integer.parseInt(request.getParameter("id"));
                LogicaProductos logicaProductos = new LogicaProductos();
                logicaProductos.borrarProducto(logicaProductos.cargarProducto(id));
                request.getRequestDispatcher("productos.jsp").forward(request, response);
            default:
                request.getRequestDispatcher("productos.jsp").forward(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        LogicaProductos logicaProductos = new LogicaProductos();

        if (request.getParameter("id") == null){
            String nombre = request.getParameter("nombre");
            String foto = request.getParameter("foto");
            String valorUnitario = request.getParameter("valorUnitario");
            String descripcion = request.getParameter("descripcion");
            Producto producto = new Producto(nombre, foto, Float.parseFloat(valorUnitario), descripcion);
            boolean guardado = logicaProductos.guardarProducto(producto);
            request.getRequestDispatcher("productos.jsp").forward(request, response);
        }
        else {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String foto = request.getParameter("foto");
            String valorUnitario = request.getParameter("valorUnitario");
            String descripcion = request.getParameter("descripcion");
            Producto producto = new Producto(id,nombre,foto,Float.parseFloat(valorUnitario),descripcion);
            boolean actualizar  = logicaProductos.actualizarProducto(producto);
            request.getRequestDispatcher("productos.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
