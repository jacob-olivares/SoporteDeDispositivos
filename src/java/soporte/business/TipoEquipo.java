/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte.business;

/**
 *
 * @author jhaco
 */
public class TipoEquipo {
    private int idTipoEquipo;
    private String tipo_equipo;

    public TipoEquipo() {
    }

    public TipoEquipo(int idTipoEquipo, String tipo_equipo) {
        this.idTipoEquipo = idTipoEquipo;
        this.tipo_equipo = tipo_equipo;
    }

    public int getIdTipoEquipo() {
        return idTipoEquipo;
    }

    public void setIdTipoEquipo(int idTipoEquipo) {
        this.idTipoEquipo = idTipoEquipo;
    }

    public String getTipo_equipo() {
        return tipo_equipo;
    }

    public void setTipo_equipo(String tipo_equipo) {
        this.tipo_equipo = tipo_equipo;
    }
    
    
    
}
