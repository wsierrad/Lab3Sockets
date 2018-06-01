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
            Cajeros cajeros, Clientes cliente, int puntos) {
        Supermercado s = new Supermercado();
        this.supermercado = s.getName();
        this.productos = productos;
        this.subtotal = subtotal;
        this.total = total;
        this.articulosComprados = articulosComprados;
        this.cajeros = cajeros;
        this.cliente = cliente;
        this.puntos = puntos;
        cliente.addPuntos(puntos);
    }
    
    
    
    
    
}
