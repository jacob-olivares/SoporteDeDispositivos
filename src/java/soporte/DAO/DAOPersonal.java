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
import soporte.business.Personal;

/**
 *
 * @author Informatica
 */
public class DAOPersonal implements CRUD<Personal> {
    private static Conexion objConn = Conexion.InstanciaConn();
    ResultSet rs;
    
    @Override
    public boolean insert(Personal x) {
        String query = "INSERT INTO PERSONAL(rut_personal, nombre, ap_pat, ap_mat, telefono, fecha_contrato "
                + "VALUES(?,?,?,?,?,?);";
        try{
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x.getRut_personal());
            ps.setString(2, x.getNombre());
            ps.setString(3, x.getAp_pat());
            ps.setString(4, x.getAp_mat());
            ps.setInt(5, x.getTelefono());
            ps.setDate(7, (Date) x.getFecha_contrato());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Personal x) {
        String query = "UPDATE FROM PERSONAL SET nombre = ?, ap_pat = ?, ap_mat = ?, "
                + "telefono = ?, fecha_contrato = ? WHERE rut_personal = ?;";
        try{
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setString(1, x.getNombre());
            ps.setString(2, x.getAp_pat());
            ps.setString(3, x.getAp_mat());
            ps.setInt(4, x.getTelefono());
            ps.setDate(6, (Date) x.getFecha_contrato());
            
            if(ps.executeUpdate()> 0){
                return true;
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "DELETE FROM PERSONAL WHERE RUT_PERSONAL = ?;";
        try{
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Personal> select() {
        String query = "SELECT * FROM PERSONAL";
        ArrayList<Personal> personal = new ArrayList<>();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                personal.add(new Personal(rs.getInt("rut_personal"), rs.getInt("telefono"),
                        rs.getString("nombre"), rs.getString("ap_pat"), rs.getString("ap_mat"),
                        rs.getDate("fecha_contrato")));
            }
            return personal;
        } catch (SQLException ex) {
            Logger.getLogger(DAOPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
}
