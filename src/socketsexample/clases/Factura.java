/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsexample.clases;
import java.util.ArrayList;

/**
 *
 * @author Juan_Ardila
 */
public class Factura {
    private String supermercado;
    private ArrayList<Products> productos;
    private double subtotal;
    private double total;
    private int articulosComprados;
    private Cajeros cajeros;
    private Clientes cliente;
    private int puntos;

    public Factura(ArrayList<Products> productos,
            double subtotal, double total, int articulosComprados,
            Cajeros cajeros, Clientes cliente) {
        Supermercado s = new Supermercado();
        this.supermercado = s.getName();
        this.productos = productos;
        this.subtotal = subtotal;
        this.total = total;
        this.articulosComprados = articulosComprados;
        this.cajeros = cajeros;
        this.cliente = cliente;
        this.puntos = (int) (this.total/10000);
        this.cliente.addPuntos(this.puntos);
    }

    public String getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(String supermercado) {
        this.supermercado = supermercado;
    }

    public ArrayList<Products> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Products> productos) {
        this.productos = productos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getArticulosComprados() {
        return articulosComprados;
    }

    public void setArticulosComprados(int articulosComprados) {
        this.articulosComprados = articulosComprados;
    }

    public Cajeros getCajeros() {
        return cajeros;
    }

    public void setCajeros(Cajeros cajeros) {
        this.cajeros = cajeros;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
    
    
    
    
}
