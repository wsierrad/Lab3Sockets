/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsexample.clases;

import java.util.GregorianCalendar;

/**
 *
 * @author Juan_Ardila
 */
public class Meta {
    private int meta;
    private GregorianCalendar fecha;

    public Meta(int meta, GregorianCalendar fecha) {
        this.meta = meta;
        this.fecha = fecha;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
    
    
}
