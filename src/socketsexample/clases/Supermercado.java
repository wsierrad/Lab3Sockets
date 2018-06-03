/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsexample.clases;
import java.util.ArrayList;
import java.util.Date;
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
    
    public void porcentajeVentasProductos(){
        double total = 0.0;
        for (Products producto : productos) {
            total += producto.getPrecio();
        }
        ArrayList pro = new ArrayList();
        
        
        for (Products producto : productos) {
            int contador = 0;
            double subtotal = 0;
            Products produ = null;
            if(!pro.contains(producto.getCodigo())){
                pro.add(producto.getCodigo());
                produ = producto;
                for (Products prod : productos) {
                    if(pro.contains(prod.getCodigo())){
                        contador ++;
                    }
                }
                subtotal = produ.getPrecio()*contador;
                System.out.println(produ.getCodigo() + " " + 
                        "Precio Unitario: " + produ.getPrecio() + 
                        " Total: " + subtotal + " Porcentaje: "
                                + (subtotal/total));
            }
        }
    }
    
    public void porcentajeVentasCajeros(){
        double total = 0.0;
        for (Products producto : productos) {
            total += producto.getPrecio();
        }
        ArrayList<String> pro = new ArrayList();
        
        
        for (Products producto : productos) {
            int contador = 0;
            double subtotal = 0;
            Products produ = null;
            if(!pro.contains(producto.getCajero().getCodigo())){
                pro.add(producto.getCajero().getCodigo());
                produ = producto;
                for (Products prod : productos) {
                    if(pro.contains(prod.getCajero().getCodigo())){
                        subtotal += prod.getPrecio();
                    }
                }
                System.out.println("Codigo: " + pro.get(contador) + 
                        "vendido: " + subtotal + " porcentaje: " +
                        (subtotal/total));
                contador ++;
            }
        }
    }
    
    public void ventasPorMes(){
        double total = 0.0;
        
        for (Products producto : productos) {
            producto.getFecha();
        }
    }
    
    
}
