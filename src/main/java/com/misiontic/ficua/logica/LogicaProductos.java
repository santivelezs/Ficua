package com.misiontic.ficua.logica;

import com.misiontic.ficua.persistencia.ProductoDAO;

import java.util.List;

public class LogicaProductos {

    /**
     * Carga la información de todos los productos de la base de datos
     * @return Lista de productos
     */
    public List<Producto> cargarTodosLosUsuarios() throws Exception {
        ProductoDAO productoDAO = new ProductoDAO();
        return productoDAO.getAll();
    }

    /**
     * Guarda la información de un producto
     * @param producto un objeto con los datos de un producto específico
     * @return true si guarda el producto en la base de datos, o false si no lo guarda
     */
    public boolean guardarProducto(Producto producto) {
        ProductoDAO dao = new ProductoDAO();
        try {
            dao.save(producto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Producto cargarProducto(int id) {
        ProductoDAO dao = new ProductoDAO();
        try {
            return dao.getBy(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean actualizarProducto(Producto producto) {
        ProductoDAO dao = new ProductoDAO();
        try {
            dao.update(producto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean borrarProducto(Producto producto) {
        ProductoDAO dao = new ProductoDAO();
        try {
            dao.delete(producto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
