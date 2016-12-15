package com.kg.testjsfa8h4.servlet.form1file;

import com.kg.testjsfa8h4.beans.TempForm1FilesBean;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * delete file servlet do action from db and redirect to main user page
 * @author esyrygin
 */
@WebServlet(name = "deleteform1tempfile", urlPatterns = {"/deleteform1tempfile"})
public class deleteform1tempfile extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        try {
            String file = request.getParameter("file");
            
            TempForm1FilesBean temp = null;
            
            List<TempForm1FilesBean> tf1fBean = (List<TempForm1FilesBean>) request.getSession().getAttribute("loadedFiles");
            if (tf1fBean != null) {
                for(TempForm1FilesBean t : tf1fBean) {
                    if(t.getFileName().equals(file)) {
                        temp = t;
                        break;
                    }
                }
                if(temp != null){
                    File tempFile = new File(temp.getFilePath());
                    
                    if(tempFile.delete()){
                            System.out.println(tempFile.getName() + " is deleted!");
                    }else{
                            System.out.println("Delete operation is failed.");
                    }
                }
                response.sendRedirect("addform1files.jsp");
            } else {
            
                response.sendRedirect("addform1files.jsp");
            
            }
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
