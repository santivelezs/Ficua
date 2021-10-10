package tests;

import com.misiontic.ficua.logica.Producto;
import com.misiontic.ficua.persistencia.ConexionBD;
import com.misiontic.ficua.persistencia.ProductoDAO;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestGeneral {


    @Test
    public void verificarConexion() {
        ConexionBD con = new ConexionBD();
        Assert.assertTrue(con.isConectado(), "No hay conexión creada. ");
        con.desconectar();
        Assert.assertFalse(con.isConectado(), "No se cerró conexión. ");
    }

    @Ignore
    public void verificarInsercionJuguete() {
        ProductoDAO dao = new ProductoDAO();
        Producto producto = new Producto("mouse", "url foto", 200, "mouse de bamnbu ecologico");
        try {
            boolean created = dao.save(producto);
            Assert.assertTrue(created);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Ignore
    public void verificarEliminar(){
        ProductoDAO productoDAO = new ProductoDAO();
        Producto producto = new Producto(5, "mouse", "url foto", 200, "mouse de bamnbu ecologico");
        try {
            boolean deleted = productoDAO.delete(producto);
            Assert.assertTrue(deleted);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Ignore
    public void verificarActualizar(){
        ProductoDAO productoDAO = new ProductoDAO();
        Producto producto = new Producto(4, "mouse", "url foto 2", 400, "mouse logitech");
        try {
            boolean updated = productoDAO.update(producto);
            Assert.assertTrue(updated);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
