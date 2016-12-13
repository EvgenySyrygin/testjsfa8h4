/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kg.testjsfa8h4.servlet.form1;

import com.kg.testjsfa8h4.beans.Form1Bean;
import com.kg.testjsfa8h4.servlet.user.*;
import com.kg.testjsfa8h4.beans.UsersBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esyrygin
 */
@WebServlet(name = "addform1save", urlPatterns = {"/addform1save"})
public class addform1save extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); 
        PrintWriter out = response.getWriter();
        try {
            Integer owntype = Integer.valueOf(request.getParameter("owntype"));
            Integer legalform = Integer.valueOf(request.getParameter("legalform"));
            String orgname = request.getParameter("orgname");
            String fiohead = request.getParameter("fiohead");
            String fax = request.getParameter("fax");
            String phone = request.getParameter("phone");
            String webpage = request.getParameter("webpage");
            String licensenumber = request.getParameter("licensenumber");
            String licensenumberdate = request.getParameter("licensenumberdate");
            String certificatenumber = request.getParameter("certificatenumber");
            String certificatenumberdate = request.getParameter("certificatenumberdate");
            String address = request.getParameter("address");
            Integer files = Integer.valueOf(request.getParameter("files"));
            Integer employees = Integer.valueOf(request.getParameter("employees"));
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date dlicensenumberdate = new Date();
            Date dcertificatenumberdate = new Date();
            try {
                dlicensenumberdate = formatter.parse(licensenumberdate);
                dcertificatenumberdate = formatter.parse(certificatenumberdate);
            } catch (ParseException ex) {
                Logger.getLogger(addform1save.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Form1Bean form1Bean = new Form1Bean();
            form1Bean.setIdOwnType(owntype);
            form1Bean.setIdLegalForm(legalform);
            form1Bean.setOrgName(orgname);
            form1Bean.setFioHead(fiohead);
            form1Bean.setFax(fax);
            form1Bean.setPhone(phone);
            form1Bean.setWebPage(webpage);
            form1Bean.setLicenseNumber(licensenumber);
            form1Bean.setLicenseDate(dlicensenumberdate);
            form1Bean.setCertificateNumber(certificatenumber);
            form1Bean.setCertificateDate(dcertificatenumberdate);
            form1Bean.setAddress(address);
            form1Bean.setIdFiles(files);
            form1Bean.setIdEmployesList(employees);
            
            form1Bean.addForm1();
            
            response.sendRedirect("form1.jsp");
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
