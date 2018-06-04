/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsexample.clases;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author Juan_Ardila
 */
public class Products {
    private String nombre;
    private int codigo;
    private int cantidad;
    private ArrayList<Meta> meta;
    private double precio;
    private Cajeros cajero;
    private GregorianCalendar fecha;

    public Products(String nombre, int codigo, int cantidad, double precio,
            Cajeros cajero, Meta meta) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.cajero = cajero;
        this.fecha = new GregorianCalendar();
        this.meta = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Cajeros getCajero() {
        return cajero;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public ArrayList getMeta() {
        return meta;
    }

    public void agregarMeta(Meta meta){
        this.meta.add(meta);
    }
      
}
