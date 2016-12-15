package com.kg.testjsfa8h4.servlet.form1file;

import com.kg.testjsfa8h4.beans.TempForm1FilesBean;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author esyrygin
 */
@WebServlet(name = "addform1file", urlPatterns = {"/addform1file"})
public class addform1file extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "e:/uploads";
    
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); 
        PrintWriter out = response.getWriter();
        try {
            String nameFile = "";
            TempForm1FilesBean tempForm1FilesBean = new TempForm1FilesBean();
            if(ServletFileUpload.isMultipartContent(request)){
                try {
                    List<FileItem> multiparts = new ServletFileUpload(
                                             new DiskFileItemFactory()).parseRequest(request);
                    
                    for(FileItem item : multiparts){
                        if(!item.isFormField()){
                            String name = new File(item.getName()).getName();
                            
                            File tempFile = new File(UPLOAD_DIRECTORY + File.separator + name);
                            item.write( tempFile );
                            
                            System.out.println("contenType - " + item.getContentType());
                            System.out.println("name - " + item.getName());
                            System.out.println("fieldName - " + item.getFieldName());
                            System.out.println("size - " + item.getSize());
                            System.out.println("formField - " + item.isFormField());
                            System.out.println("inMemory - " + item.isInMemory());
                            
                            nameFile = item.getName();
                            
                            Date fd = new Date();
                            tempForm1FilesBean.setFileName(name);
                            tempForm1FilesBean.setFileDate(fd.toString());
                            tempForm1FilesBean.setFilePath(tempFile.getAbsolutePath());
                        } else {
                        }
                    }

                    System.out.println("File uploaded successfully - " + nameFile);
                   request.getSession().setAttribute("message", "Загружен файл " + nameFile);
                } catch (Exception ex) {
                   request.getSession().setAttribute("message", "Ошибка загрузки файла " + nameFile + " | " + ex);
                }          

            }else{
                request.getSession().setAttribute("message",
                                     "Sorry this Servlet only handles file upload request");
            }
            
            List<TempForm1FilesBean> tf1fBean = (List<TempForm1FilesBean>) request.getSession().getAttribute("loadedFiles");
            if (tf1fBean != null) {
                tf1fBean.add(tempForm1FilesBean);
                request.getSession().setAttribute("loadedFiles", tf1fBean);
            } else {
                List<TempForm1FilesBean> tf1fBeanNew = new ArrayList<TempForm1FilesBean>();
                tf1fBeanNew.add(tempForm1FilesBean);
                request.getSession().setAttribute("loadedFiles", tf1fBeanNew);
            }
            
            response.sendRedirect("addform1files.jsp");
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
