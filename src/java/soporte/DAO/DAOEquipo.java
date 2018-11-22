/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import soporte.business.CRUD;
import soporte.business.Equipo;

/**
 *
 * @author jhaco
 */
public class DAOEquipo implements CRUD<Equipo>{
    private static Conexion objConn = Conexion.InstanciaConn();
    ResultSet rs;
    
    
    @Override
    public boolean insert(Equipo x) {
        String query = "INSERT INTO EQUIPO(marca, modelo, tipoEquipo, fecha_ingreso,"
                + "fecha_salida, descripcion, rut_encargado, estado) VALUES(?,?,?,?,?,?,?,?);";
        try{
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setString(1, x.getMarca());
            ps.setString(2, x.getModelo());
            ps.setInt(3, x.getTipoEquipo());
            ps.setDate(4, (Date)x.getFecha_ingreso());
            ps.setDate(5, (Date)x.getFecha_salida());
            ps.setString(6, x.getDescripcion());
            ps.setInt(7, x.getRut_encargado());
            ps.setString(8, x.getEstado());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Equipo x) {
        String query = "UPDATE EQUIPO SET marca=?, modelo=?, tipoEquipo=?, fecha_ingreso=?,"
                + "fecha_salida=?, descripcion=?, rut_encargado=?, estado=?;";
        try{
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setString(1, x.getMarca());
            ps.setString(2, x.getModelo());
            ps.setInt(3, x.getTipoEquipo());
            ps.setDate(4, (Date)x.getFecha_ingreso());
            ps.setDate(5, (Date)x.getFecha_salida());
            ps.setString(6, x.getDescripcion());
            ps.setInt(7, x.getRut_encargado());
            ps.setString(8, x.getEstado());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "DELETE FROM EQUIPO WHERE idEquipo = ?";
        try{
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            
            if(ps.executeUpdate()>0){
                return true;
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Equipo> select() {
        String query = "SELECT * FROM EQUIPO;";
        ArrayList<Equipo> equipos = new ArrayList<>();
        try{
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                equipos.add(new Equipo(rs.getInt("idEquipo"), rs.getInt("rut_encargado"), 
                        rs.getString("marca"), rs.getString("modelo"), rs.getString("descripcion"), 
                        rs.getString("estado"), rs.getInt("tipoEquipo"), 
                        rs.getDate("fecha_ingreso"), rs.getDate("fecha_salida")));
            }
            return equipos;
        }catch(SQLException ex){
            Logger.getLogger(DAOEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
