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
public class Supermercado {
    private ArrayList<Products> productos;
    private ArrayList<Clientes> clientes;
    private ArrayList<Cajeros> cajeros;
    private String name;

    public Supermercado() {
        productos = new ArrayList();
        clientes = new ArrayList();
        cajeros = new ArrayList();
        name = "SuperMercados POO";
    }
    
    public void agregarCliente(Clientes c){
        clientes.add(c);
    }
    
    public void agregarCajeros(Cajeros c){
        cajeros.add(c);
    }
    
    public void agregarProductos(Products p){
        productos.add(p);
    }

    public ArrayList<Products> getProductos() {
        return productos;
    }

    public ArrayList<Clientes> getClientes() {
        return clientes;
    }

    public ArrayList<Cajeros> getCajeros() {
        return cajeros;
    }

    public String getName() {
        return name;
    }
    
    
    
    
}
