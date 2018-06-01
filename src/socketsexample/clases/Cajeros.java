/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsexample.clases;

/**
 *
 * @author Juan_Ardila
 */
public class Cajeros {
    private String nombre;
    private String codigo;
    private double ventas;

    public Cajeros(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ventas = 0.0;
    }
    
    public void sumarVentas(double ventasExtra){
        this.ventas += ventasExtra;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getVentas() {
        return ventas;
    }
    
    
}
