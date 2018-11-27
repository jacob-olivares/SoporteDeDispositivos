/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte.business;

import java.util.Date;

/**
 *
 * @author jhaco
 */
public class Personal {
    private int rut_personal, telefono;
    private String nombre, ap_pat, ap_mat;
    private Date fecha_contrato;

    public Personal() {
    }

    public Personal(int rut_personal, int telefono, String nombre, String ap_pat, String ap_mat, Date fecha_contrato) {
        this.rut_personal = rut_personal;
        this.telefono = telefono;
        this.nombre = nombre;
        this.ap_pat = ap_pat;
        this.ap_mat = ap_mat;
        this.fecha_contrato = fecha_contrato;
    }

    public Personal(int telefono, String nombre, String ap_pat, String ap_mat, int rut_personal) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.ap_pat = ap_pat;
        this.ap_mat = ap_mat;
        this.rut_personal = rut_personal;
    }
    

    public int getRut_personal() {
        return rut_personal;
    }

    public void setRut_personal(int rut_personal) {
        this.rut_personal = rut_personal;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_pat() {
        return ap_pat;
    }

    public void setAp_pat(String ap_pat) {
        this.ap_pat = ap_pat;
    }

    public String getAp_mat() {
        return ap_mat;
    }

    public void setAp_mat(String ap_mat) {
        this.ap_mat = ap_mat;
    }

    public Date getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(Date fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }
    
    
}
