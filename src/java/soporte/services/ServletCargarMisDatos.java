/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import soporte.DAO.DAOPersonal;
import soporte.DAO.DAOUsuario;
import soporte.business.Personal;
import soporte.business.Usuario;

/**
 *
 * @author jhaco
 */
public class ServletCargarMisDatos extends HttpServlet {

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
        DAOPersonal dPersonal = new DAOPersonal();
        Usuario u = (Usuario) request.getSession().getAttribute("Usuario");
        ArrayList<Personal> personal = dPersonal.select();
        
        for (int i = 0; i < personal.size(); i++) {
            if(personal.get(i).getRut_personal() == Integer.parseInt(u.getUsername())){
                Personal p = new Personal(personal.get(i).getRut_personal(), personal.get(i).getTelefono(), 
                        personal.get(i).getNombre(), personal.get(i).getAp_pat(), 
                        personal.get(i).getAp_mat(), personal.get(i).getFecha_contrato());
                request.getSession().setAttribute("Personal", p);
            }
        }
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
        Usuario u = (Usuario) request.getSession().getAttribute("Usuario");
        String nombre = request.getParameter("nombre");
        String ap_pat = request.getParameter("ap_pat");
        String ap_mat = request.getParameter("ap_mat");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        
        Personal p = new Personal(telefono, nombre, ap_pat, ap_mat, Integer.parseInt(u.getUsername()));
        DAOPersonal dPersonal = new DAOPersonal();
        dPersonal.update(p);
        request.getSession().setAttribute("Modificar", "true");
        response.sendRedirect("/SoporteDeDispositivos/pages/micuenta/misdatos.jsp");
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
