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
public class Clientes {
    private int puntos;
    private int cedula;
    private String nombre;
    private String apellido;

    public Clientes(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntos = 0;
    }
    
    public void addPuntos(int puntos){
        this.puntos += puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    
}
