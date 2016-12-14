/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kg.testjsfa8h4.servlet.user;

import com.kg.testjsfa8h4.beans.GroupsBean;
import com.kg.testjsfa8h4.beans.UsersBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esyrygin
 */
@WebServlet(name = "addusersave", urlPatterns = {"/addusersave"})
public class addusersave extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); 
        PrintWriter out = response.getWriter();
        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String fio = request.getParameter("fio");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            Integer group = Integer.valueOf(request.getParameter("group"));
            
            GroupsBean groupsBean = new GroupsBean();
            
            UsersBean usersBean = new UsersBean();
            usersBean.setCreateDate(new Date());
            usersBean.setEmail(email);
            usersBean.setFio(fio);
            usersBean.setGroups(groupsBean.returnGroupById(group)); 
            usersBean.setLogin(login);
            usersBean.setPhoneNumber(phone);
            usersBean.setPassword(password);
            
            usersBean.addUser();
            
            response.sendRedirect("users.jsp");
        } finally {
            out.close();
        }
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
        processRequest(request, response);
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
