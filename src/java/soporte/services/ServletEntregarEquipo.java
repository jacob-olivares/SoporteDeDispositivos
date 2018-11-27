/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
public class ServletEntregarEquipo extends HttpServlet {

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
        String rut = request.getParameter("rut_cliente");
        DAOEquipo dEquipo = new DAOEquipo();
        ArrayList<Equipo> equipos = dEquipo.selectXRut(rut);
        request.getSession().setAttribute("equiposXRut", equipos);
        
        response.sendRedirect("/SoporteDeDispositivos/pages/equipos/entregar.jsp");
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
        String[] ids = request.getParameterValues("idEquipo");
        DAOEquipo dEquipo = new DAOEquipo();
        Date fecha = new Date();
        int[] ids_int = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            ids_int[i] = Integer.parseInt(ids[i]);
        }
        dEquipo.entregarEquipo(ids_int, fecha);
        request.getSession().setAttribute("Entregado", "true");
        response.sendRedirect("/SoporteDeDispositivos/pages/equipos/entregar.jsp");

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
