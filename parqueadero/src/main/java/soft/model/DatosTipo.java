package soft.model;

import java.io.Serializable;

public class DatosTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int precio;
    private int fraccion;

    public DatosTipo(){

    }
    public DatosTipo(String nombre, int precio, int fraccion) {
        this.nombre = nombre;
        this.precio = precio;
        this.fraccion = fraccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getFraccion() {
        return fraccion;
    }

    public void setFraccion(int fraccion) {
        this.fraccion = fraccion;
    }
}
