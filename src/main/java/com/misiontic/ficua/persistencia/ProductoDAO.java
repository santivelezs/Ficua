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
 */
  @author Luis Cala
 
 public class ProductoDAO {
 
    public ArrayList<Productos> consultarProducto(){
        ArrayList<Productos> lista = new ArrayList<> ();
        ConexionBD con = New ConexionBD(); 
        ResultSet rs = con.ejecutarQuery("");
        try{
            while (rs.next()){
                int id = rs.getInt("IdProductos");      
                String nombre = rs.getString ("Nombre");
                int unidades = rs.getString ("Numero_de_Unidades");
                String disponiblilidad = rs.getString ("Desponibilidad");            
                String descripcion = rs.getString ("Descripción_del_Producto");
            
                Productos F = new Productos (nombre, descripcion, unidades, disponibilidad);
                lista.add (F);            
             }
          } catch(SQLException ex){ 
                return null;
          }
          return lista;  
    }
 }
