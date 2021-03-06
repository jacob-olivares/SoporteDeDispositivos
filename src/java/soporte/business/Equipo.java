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
public class Equipo {
    private int idEquipo, rut_encargado, tipoEquipo, precio;
    private String marca, modelo, descripcion, estado, rut_cliente;
    private Date fecha_ingreso, fecha_salida;

    public Equipo() {
    }

    public Equipo(int rut_encargado, String marca, String modelo, 
            String descripcion, String estado, int tipoEquipo, Date fecha_ingreso, 
            Date fecha_salida, String rut_cliente, int precio) {
        this.rut_encargado = rut_encargado;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipoEquipo = tipoEquipo;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.rut_cliente = rut_cliente;
        this.precio = precio;
    }
    
    public Equipo(int idEquipo, int rut_encargado, String marca, String modelo, 
            String descripcion, String estado, int tipoEquipo, Date fecha_ingreso, 
            Date fecha_salida, String rut_cliente, int precio) {
        this.idEquipo = idEquipo;
        this.rut_encargado = rut_encargado;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipoEquipo = tipoEquipo;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.rut_cliente = rut_cliente;
        this.precio = precio;
    }

    public Equipo(int idEquipo, int rut_encargado, int tipoEquipo, int precio, String marca, String modelo, String descripcion, String rut_cliente, Date fecha_ingreso, Date fecha_salida) {
        this.idEquipo = idEquipo;
        this.rut_encargado = rut_encargado;
        this.tipoEquipo = tipoEquipo;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.rut_cliente = rut_cliente;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
    }
    

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }



    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getRut_encargado() {
        return rut_encargado;
    }

    public void setRut_encargado(int rut_encargado) {
        this.rut_encargado = rut_encargado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(int tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public String getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(String rut_cliente) {
        this.rut_cliente = rut_cliente;
    }
    
    
}
