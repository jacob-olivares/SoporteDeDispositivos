/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import soporte.DAO.DAOEquipo;
import soporte.DAO.DAOPersonal;
import soporte.DAO.DAOTipoEquipo;
import soporte.business.Equipo;
import soporte.business.Personal;
import soporte.business.TipoEquipo;

/**
 *
 * @author jhaco
 */
public class ServletIngresarEquipo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOPersonal dPer = new DAOPersonal();
        ArrayList<Personal> personal = dPer.select();
        DAOTipoEquipo dTipo = new DAOTipoEquipo();
        ArrayList<TipoEquipo> tipos = dTipo.select();
        HttpSession session = request.getSession();
        session.setAttribute("tipos", tipos);
        session.setAttribute("personal", personal);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            //INSTANCIAS REQUERIDAS
            DAOEquipo dEquipo = new DAOEquipo();
            
            // SE RECIBEN LOS PARAMETROS DESDE EL JSP
            String fecha_in = request.getParameter("fecha_ingreso");
            String fecha_out = request.getParameter("fecha_salida");
            int tipo_dispositivo = Integer.parseInt(request.getParameter("tipo"));
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String descripcion = request.getParameter("descripcion");
            int rut_encargado = Integer.parseInt(request.getParameter("rut_encargado"));
            String rut_cliente = request.getParameter("rut_cliente");
            
            //FORMATEO DE STRINGS A DATE
            Date fecha_ingreso = df.parse(fecha_in);
            Date fecha_salida = df.parse(fecha_out);
            
            //SE CREA EL EQUIPO
            Equipo e = new Equipo(rut_encargado, marca, modelo, descripcion, "EN TALLER", tipo_dispositivo, fecha_ingreso, fecha_salida, rut_cliente);
            if(dEquipo.insert(e)){
                request.getSession().setAttribute("Ingresado", "true");
                response.sendRedirect("/SoporteDeDispositivos/pages/equipos/ingresar.jsp");
            }else{
                
                request.getSession().setAttribute("Ingresado", "false");
                response.sendRedirect("/SoporteDeDispositivos/pages/equipos/ingresar.jsp");
            }
            
            
        } catch (NumberFormatException | ParseException ex) {
            Logger.getLogger(ServletIngresarEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
