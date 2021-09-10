package com.misiontic.ficua.logica;

import com.misiontic.ficua.persistencia.ProductoDAO;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class Producto
{
    private int id;
    
    private String nombre;

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
