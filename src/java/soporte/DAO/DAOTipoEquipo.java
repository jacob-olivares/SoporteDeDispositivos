/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import soporte.business.CRUD;
import soporte.business.TipoEquipo;

/**
 *
 * @author jhaco
 */
public class DAOTipoEquipo implements CRUD<TipoEquipo>{
    private static Conexion objConn = Conexion.InstanciaConn();
    ResultSet rs;

    @Override
    public boolean insert(TipoEquipo x) {
        String query = "INSERT INTO TIPOEQUIPO(TIPO_EQUIPO) VALUES (?);";
        try {
            //SE EJECUTA UNA QUERY A TRAVES DE UN PREPAREDSTATEMENT
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            //SE SETEAN LOS ATRIBUTOS QUE SE OCUPAN EN LA QUERY
            ps.setString(1, x.getTipo_equipo());
            
            //EL METODO EXECUTEUPDATE DEVUELVE EL NUMERO DE FILAS QUE RESULTARON AFECTADAS
            //POR UN INSERT, UPDATE O DELETE, EN ESTE CASO AFECTO UNA FILA POR 
            //ENDE RETORNA TRUE
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTipoEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        //EN CASO DE QUE LA QUERY NO SE EJECUTO RETORNA UN FALSE.
        return false;
    }

    @Override
    public boolean update(TipoEquipo x) {
        String query = "UPDATE FROM TIPOEQUIPO SET TIPO_EQUIPO = ? WHERE IDTIPOEQUIPO = ?;";
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x.getIdTipoEquipo());
            ps.setString(2, x.getTipo_equipo());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTipoEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "DELETE FROM TIPOEQUIPO WHERE IDTIPOEQUIPO = ?;";
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTipoEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<TipoEquipo> select() {
        String query = "SELECT * FROM TIPOEQUIPO;";
        ArrayList<TipoEquipo> tipoEquipos = new ArrayList<>();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tipoEquipos.add(new TipoEquipo(rs.getInt("idTipoEquipo"), rs.getString("tipo_equipo")));
            }
            return tipoEquipos;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTipoEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
