package com.misiontic.ficua.persistencia;

import com.misiontic.ficua.logica.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Karen Cuestas
 *@author Luis Cala
*/

 
 public class ProductoDAO implements Dao<Producto> {



    private final int ID_VENDEDOR_DEFECTO = 1;

    @Override
    public List<Producto> getAll() throws Exception {
        ArrayList<Producto> lista = new ArrayList<> ();
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.ejecutarQuery("select * from producto");
        try{
            while (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString ("nombre");
                float valorUnitario= rs.getFloat ("valor_unitario");
                String descripcion = rs.getString ("descripcion");
                String foto = rs.getString("foto");

                Producto F = new Producto (id,nombre,foto,valorUnitario,descripcion);
                lista.add (F);
            }
        } catch(SQLException ex){
            return null;
        }
        return lista;
    }

    @Override
    public Producto getBy(int id) throws Exception {
        return null;
    }

    @Override
    public boolean save(Producto producto) throws Exception {
        ConexionBD con = new ConexionBD();
        String nombre = producto.getNombre();
        float valorUnitario = producto.getValorUnitario();
        String descripcion = producto.getDescripcion();
        String foto = producto.getFoto();

        String sql = "INSERT INTO producto (nombre, valor_unitario, descripcion, foto, id_vendedor) "+
                "VALUES ('"+nombre+"', "+valorUnitario+", '"+descripcion+"', '"+foto+"', "+ID_VENDEDOR_DEFECTO+") ";
        ResultSet rs = con.ejecutarUpdate(sql);
        int id = 0;
        try {
            if (rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            con.desconectar();
            return false;
        }
        con.desconectar();
        return true;
    }

    @Override
    public boolean update(Producto producto) throws Exception {
        String sql = "UPDATE producto " +
                "SET nombre = '" + producto.getNombre()+ "', foto = '" + producto.getFoto() + "', " +
                "valor_unitario = '" + producto.getValorUnitario() + "', descripcion = '" + producto.getDescripcion() + "' " +
                "WHERE id = " + producto.getId();
        ConexionBD con = new ConexionBD();
        con.ejecutarUpdate(sql);
        return true;
    }

    @Override
    public boolean delete(Producto producto) throws Exception {
        String sql = "DELETE from producto " +
                "WHERE id = " + producto.getId();
        ConexionBD con = new ConexionBD();
        con.ejecutarUpdate(sql);
        return true;
    }
}
