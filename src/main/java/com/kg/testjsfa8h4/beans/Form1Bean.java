package com.kg.testjsfa8h4.beans;

import com.kg.testjsfa8h4.dao.Form1Dao;
import com.kg.testjsfa8h4.entity.Form1;
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
public class Form1Bean {

     private Integer id;
     private int idOwnType;
     private int idLegalForm;
     private String orgName;
     private String fioHead;
     private String fax;
     private String phone;
     private String webPage;
     private String licenseNumber;
     private Date licenseDate;
     private String certificateNumber;
     private Date certificateDate;
     private String address;
     private int idFiles;
     private int idEmployesList;

    
    public Form1Bean() {
    }
    
    public void addForm1() {
        Form1 form1 = new Form1(idOwnType, idLegalForm, orgName, fioHead, fax, phone, webPage, licenseNumber, licenseDate, certificateNumber, certificateDate, address, idFiles, idEmployesList);
        Form1Dao usersDao = new Form1Dao();
        usersDao.addForm1(form1);
    }
    
    public void returnForm1ById() {
        Form1Dao formDao = new Form1Dao();
        Form1 user = formDao.getForm1ById(getId());
        if(user != null) {
            setAddress(user.getAddress());
            setCertificateDate(user.getCertificateDate());
            setCertificateNumber(user.getCertificateNumber());
            setFax(user.getFax());
            setFioHead(user.getFioHead());
            setIdEmployesList(user.getIdEmployesList());
            setIdFiles(user.getIdFiles());
            setIdLegalForm(user.getIdLegalForm());
            setIdOwnType(user.getIdOwnType());
            setLicenseDate(user.getLicenseDate());
            setLicenseNumber(user.getLicenseNumber());
            setOrgName(user.getOrgName());
            setPhone(user.getPhone());
            setWebPage(user.getWebPage());
        } else {
        }
    }
    
    public void deleteForm1() {
        Form1Dao form1Dao = new Form1Dao();
        form1Dao.deleteForm1(getId());
            setAddress("");
            setCertificateDate(null);
            setCertificateNumber("");
            setFax("");
            setFioHead("");
            setIdEmployesList(0);
            setIdFiles(0);
            setIdLegalForm(0);
            setIdOwnType(0);
            setLicenseDate(null);
            setLicenseNumber("");
            setOrgName("");
            setPhone("");
            setWebPage("");
    }
    
    public void updateForm1() {
        Form1 form1 = new Form1(idOwnType, idLegalForm, orgName, fioHead, fax, phone, webPage, licenseNumber, licenseDate, certificateNumber, certificateDate, address, idFiles, idEmployesList);
        Form1Dao form1Dao = new Form1Dao();
        form1Dao.updateForm1(getId(), form1);
    }
    
    public List<Form1> returnAllForm1() {
        Form1Dao formDao = new Form1Dao();
        return formDao.getAllForm1();
    }
    
    //<editor-fold defaultstate="collapsed" desc="get/set">

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdOwnType() {
        return idOwnType;
    }

    public void setIdOwnType(int idOwnType) {
        this.idOwnType = idOwnType;
    }

    public int getIdLegalForm() {
        return idLegalForm;
    }

    public void setIdLegalForm(int idLegalForm) {
        this.idLegalForm = idLegalForm;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getFioHead() {
        return fioHead;
    }

    public void setFioHead(String fioHead) {
        this.fioHead = fioHead;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(Date licenseDate) {
        this.licenseDate = licenseDate;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdFiles() {
        return idFiles;
    }

    public void setIdFiles(int idFiles) {
        this.idFiles = idFiles;
    }

    public int getIdEmployesList() {
        return idEmployesList;
    }

    public void setIdEmployesList(int idEmployesList) {
        this.idEmployesList = idEmployesList;
    }
    
    //</editor-fold>
}
