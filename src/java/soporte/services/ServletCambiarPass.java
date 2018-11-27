/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte.services;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import soporte.DAO.DAOUsuario;
import soporte.business.Usuario;

/**
 *
 * @author jhaco
 */
public class ServletCambiarPass extends HttpServlet {

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
        processRequest(request, response);
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
        DAOUsuario dUser = new DAOUsuario();
        String old_pass = request.getParameter("password1");
        String new_pass = request.getParameter("password2");
        String r_pass = request.getParameter("password3");
        
        Usuario u = (Usuario) request.getSession().getAttribute("Usuario");
        
        //Si la contraseña del usuario no coincide con la que viene por parametro
        if(!u.getPassword().equals(old_pass)){
            request.getSession().setAttribute("Error", "incorrecta"); // se asigna true a una variable de ServletRequest

        }else if (!new_pass.equals(r_pass)){
            request.getSession().setAttribute("Error", "no coinciden"); // se asigna true a una variable de ServletRequest
        }else{
            request.getSession().setAttribute("Error", null); // se asigna null a una variable de ServletRequest
        }
        u.setPassword(new_pass);
        
        dUser.update(u);
        request.getSession().setAttribute("Mensaje1", "true");
        response.sendRedirect("/SoporteDeDispositivos/pages/micuenta/cambiarContrasena.jsp");
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
