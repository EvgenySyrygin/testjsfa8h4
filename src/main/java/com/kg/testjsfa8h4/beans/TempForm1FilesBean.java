/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kg.testjsfa8h4.beans;

import com.kg.testjsfa8h4.entity.Form1;
import javax.ejb.Stateless;

/**
 *
 * @author esyrygin
 */
@Stateless
public class TempForm1FilesBean {

    private String fileName;
    private String fileDate;
    private String filePath;
    private boolean deleted;
     
    //<editor-fold defaultstate="collapsed" desc="get/set">

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    //</editor-fold>

}
