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
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import soporte.DAO.DAOEquipo;
import soporte.business.Equipo;

/**
 *
 * @author jhaco
 */
public class ServletModificarEquipo extends HttpServlet {

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
        int id_equipo = Integer.parseInt(request.getParameter("idEquipo"));
        
        DAOEquipo dEquipo = new DAOEquipo();
        ArrayList<Equipo> equipos = dEquipo.select();
        Equipo eq = null;
        for(Equipo e : equipos){
           if(e.getIdEquipo() == id_equipo){
               eq = e;
           }
        }
        
        request.getSession().setAttribute("eq", eq);
        response.sendRedirect("/SoporteDeDispositivos/pages/equipos/modificar.jsp");
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
            DAOEquipo dEquipo = new DAOEquipo();
            
            String fecha_in = request.getParameter("fecha_ingreso");
            String fecha_out = request.getParameter("fecha_salida");
            int id_equipo = Integer.parseInt(request.getParameter("idEquipo"));
            int tipo_equipo = Integer.parseInt(request.getParameter("tipo"));
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String descripcion = request.getParameter("descripcion");
            int rut_encargado = Integer.parseInt(request.getParameter("rut_encargado"));
            String rut_cliente = request.getParameter("rut_cliente");
            int precio = Integer.parseInt(request.getParameter("precio"));
            
            //formateos de fecha
            Date fecha_ingreso = df.parse(fecha_in);
            Date fecha_salida = df.parse(fecha_out);
            
            Equipo e = new Equipo(id_equipo, rut_encargado, tipo_equipo, precio, marca, modelo, descripcion, rut_cliente, fecha_ingreso, fecha_salida);
            dEquipo.update(e);
            request.getSession().setAttribute("Modify", "yes");
            
            response.sendRedirect("/SoporteDeDispositivos/pages/equipos/lista.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(ServletModificarEquipo.class.getName()).log(Level.SEVERE, null, ex);
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
