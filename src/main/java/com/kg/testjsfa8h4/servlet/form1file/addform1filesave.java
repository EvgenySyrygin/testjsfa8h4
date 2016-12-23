package com.kg.testjsfa8h4.servlet.form1file;

import com.kg.testjsfa8h4.beans.Form1Bean;
import com.kg.testjsfa8h4.beans.Form1FilesBean;
import com.kg.testjsfa8h4.entity.Form1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "addform1filesave", urlPatterns = {"/addform1filesave"})
public class addform1filesave extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "e:/uploads";

    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String fileCountText = request.getParameter("fileCount");
            if (fileCountText != null) {
                Integer form1 = Integer.valueOf(request.getParameter("form1"));
                Integer fileCount = Integer.valueOf(fileCountText);
                System.out.println("form1 - " + form1);
                System.out.println("fileCount - " + fileCount);

                String fileNameN;
                String fileDateN;
                String filePathN;

                for (int i = 1; i <= fileCount; i++) {
                    fileNameN = request.getParameter("fileName" + i);
                    fileDateN = request.getParameter("fileDate" + i);
                    filePathN = request.getParameter("filePath" + i);

                    System.out.println("fileName" + i + " - " + fileNameN);
                    System.out.println("fileDate" + i + " - " + fileDateN);
                    System.out.println("filePath" + i + " - " + filePathN);

                    File file = new File(filePathN);
                    byte[] bFile = new byte[(int) file.length()];

                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        //convert file into array of bytes
                        fileInputStream.read(bFile);
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Form1Bean f1Bean = new Form1Bean();

                    Form1FilesBean f1fBean = new Form1FilesBean();
                    f1fBean.setFileData(bFile);
                    f1fBean.setFileDate(fileDateN);
                    f1fBean.setFileName(fileNameN);
                    f1fBean.setForm1(f1Bean.returnForm1ById(form1));
                    
                    //update id to files and employes
                    f1Bean.setId(form1);
                    f1Bean.returnForm1ById();
                    f1Bean.setIdEmployesList(f1Bean.getId());
                    f1Bean.setIdFiles(f1Bean.getId());
                    f1Bean.updateForm1();

                    f1fBean.addForm1Files();
                }
                request.getSession().setAttribute("message", "Файлы сохранены и прикреплены к форме " + form1);
                request.getSession().setAttribute("loadedFiles", null);

            }
            response.sendRedirect("form1files.jsp");
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
