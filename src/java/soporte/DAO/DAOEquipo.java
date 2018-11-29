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
                + "fecha_salida, descripcion, rut_encargado, estado, rut_cliente, precio) VALUES(?,?,?,?,?,?,?,?,?,?);";
        try{
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setString(1, x.getMarca());
            ps.setString(2, x.getModelo());
            ps.setInt(3, x.getTipoEquipo());
            ps.setDate(4, new Date(x.getFecha_ingreso().getTime()));
            ps.setDate(5, new Date(x.getFecha_salida().getTime()));
            ps.setString(6, x.getDescripcion());
            ps.setInt(7, x.getRut_encargado());
            ps.setString(8, x.getEstado());
            ps.setString(9, x.getRut_cliente());
            ps.setInt(10, x.getPrecio());
            
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
                + "fecha_salida=?, descripcion=?, rut_encargado=?, rut_cliente = ?, precio = ? WHERE idEquipo = ?;";
        try{
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setString(1, x.getMarca());
            ps.setString(2, x.getModelo());
            ps.setInt(3, x.getTipoEquipo());
            ps.setDate(4, new Date(x.getFecha_ingreso().getTime()));
            ps.setDate(5, new Date(x.getFecha_salida().getTime()));
            ps.setString(6, x.getDescripcion());
            ps.setInt(7, x.getRut_encargado());
            ps.setString(8, x.getRut_cliente());
            ps.setInt(9, x.getPrecio());
            ps.setInt(10, x.getIdEquipo());
            
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
                        rs.getDate("fecha_ingreso"), rs.getDate("fecha_salida"), rs.getString("rut_cliente"), rs.getInt("precio")));
            }
            return equipos;
        }catch(SQLException ex){
            Logger.getLogger(DAOEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public ArrayList<Equipo> selectXRut(String rut_cliente){
        String query = "SELECT * FROM EQUIPO WHERE RUT_CLIENTE = ? AND ESTADO LIKE 'EN TALLER';";
        ArrayList<Equipo> equipos = new ArrayList<>();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setString(1, rut_cliente);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                equipos.add(new Equipo(rs.getInt("idEquipo"), rs.getInt("rut_encargado"),
                        rs.getString("marca"), rs.getString("modelo"), rs.getString("descripcion"),
                        rs.getString("estado"), rs.getInt("tipoEquipo"),
                        rs.getDate("fecha_ingreso"), rs.getDate("fecha_salida"), rs.getString("rut_cliente"), rs.getInt("precio")));
            }
            return equipos;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void entregarEquipo(int equipos[], java.util.Date fecha) {
        for (int i = 0; i < equipos.length; i++) {
            String query = "UPDATE EQUIPO SET ESTADO = ?, FECHA_SALIDA = ? WHERE IDEQUIPO = ?;";
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);

            ps.setString(1, "ENTREGADO");
            ps.setDate(2, new Date(fecha.getTime()));
            ps.setInt(3, equipos[i]);
            ps.addBatch(); //Añade una sentencia a la lista de sentencias por lotes.
            ps.executeBatch(); //Ejecuta la sentencia por lotes.
                
        } catch (SQLException ex) {
            Logger.getLogger(DAOEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
}
