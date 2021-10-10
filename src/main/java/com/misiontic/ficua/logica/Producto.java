package com.misiontic.ficua.logica;

/**
 *
 * @author santi
 */
public class Producto
{
    private int id;
    
    private String nombre;

    private String foto;

    private float valorUnitario;



    private String descripcion;

    public Producto(int id, String nombre, String foto, float valorUnitario, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.valorUnitario = valorUnitario;
        this.descripcion = descripcion;
    }

    public Producto(String nombre, String foto, float valorUnitario, String descripcion) {
        this.nombre = nombre;
        this.foto = foto;
        this.valorUnitario = valorUnitario;
        this.descripcion = descripcion;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
