package com.misiontic.ficua.persistencia;

import com.misiontic.ficua.logica.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class ProductoDAO implements Dao<Producto>
{
    private ConexionBD connection;   
    
    public ProductoDAO()
    {
        this.connection = new ConexionBD();
    }
    
    @Override
    public List<Producto> getAll() throws Exception 
    {
        List<Producto> lista = new ArrayList<>();             
        ResultSet rs = connection.ejecutarQuery("SELECT * FROM productos");    
        while (rs.next()) 
        {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");                
            Producto p = new Producto(id, nombre);
            lista.add(p);
        }      
        
        return lista;
    }

    @Override
    public Producto getBy(int id) throws Exception 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(Producto t) throws Exception 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Producto t) throws Exception 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Producto t) throws Exception 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
