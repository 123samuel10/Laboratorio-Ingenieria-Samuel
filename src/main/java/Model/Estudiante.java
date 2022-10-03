package Model;

import javafx.beans.property.SimpleStringProperty;

public class Estudiante {

    private String nombre;
    private String  codigo;
    private String carrera;
    private int cantidad;
    private int precio;

    public Estudiante(String nombre, String codigo, String carrera, int cantidad, int precio) {
        this.nombre=nombre;
        this.codigo=codigo;
        this.carrera=carrera;
        this.cantidad=cantidad;
        this.precio=precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
