package com.kg.testjsfa8h4.beans;

import com.kg.testjsfa8h4.dao.Form1FilesDao;
import com.kg.testjsfa8h4.entity.Form1;
import com.kg.testjsfa8h4.entity.Form1Files;
import com.kg.testjsfa8h4.entity.Groups;
import com.kg.testjsfa8h4.entity.Users;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author DEX
 */
@ManagedBean
@RequestScoped
public class Form1FilesBean {

     private Integer id;
     private Form1 form1;
     private String fileName;
     private String fileDate;
     private byte[] fileData;
    
    public Form1FilesBean() {
    }
    
    public void addForm1Files() {
        Form1Files f1Files = new Form1Files(form1, fileName, fileDate, fileData);
        Form1FilesDao f1FilesDao = new Form1FilesDao();
        f1FilesDao.addForm1Files(f1Files);
    }
    
    public void returnForm1FilesById() {
        Form1FilesDao f1FilesDao = new Form1FilesDao();
        Form1Files f1Files = f1FilesDao.getForm1FilesById(getId());
        if(f1Files != null) {
            setFileData(f1Files.getFileData());
            setFileDate(f1Files.getFileDate());
            setFileName(f1Files.getFileName());
            setForm1(f1Files.getForm1());
        } else {
        }
    }
    
    public void deleteForm1Files() {
        Form1FilesDao f1FilesDao = new Form1FilesDao();
        f1FilesDao.deleteForm1Files(getId());
        setFileData(null);
        setFileDate("");
        setFileName("");
        setForm1(null);
    }
    
    public void updateForm1Files() {
        Form1Files f1Files = new Form1Files(form1, fileName, fileDate, fileData);
        Form1FilesDao f1FilesDao = new Form1FilesDao();
        f1FilesDao.addForm1Files(f1Files);
    }
    
    public List<Form1Files> returnAllForm1Files() {
        Form1FilesDao f1FilesDao = new Form1FilesDao();
        return f1FilesDao.getAllForm1File();
    }
    
    //<editor-fold defaultstate="collapsed" desc="get/set">

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Form1 getForm1() {
        return form1;
    }

    public void setForm1(Form1 form1) {
        this.form1 = form1;
    }

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

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
    
    //</editor-fold>
}
