package com.kg.testjsfa8h4.entity;
// Generated Dec 8, 2016 10:35:31 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Form1 generated by hbm2java
 */
public class Form1  implements java.io.Serializable {


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

    public Form1() {
    }

    public Form1(int idOwnType, int idLegalForm, String orgName, String fioHead, String fax, String phone, String webPage, String licenseNumber, Date licenseDate, String certificateNumber, Date certificateDate, String address, int idFiles, int idEmployesList) {
       this.idOwnType = idOwnType;
       this.idLegalForm = idLegalForm;
       this.orgName = orgName;
       this.fioHead = fioHead;
       this.fax = fax;
       this.phone = phone;
       this.webPage = webPage;
       this.licenseNumber = licenseNumber;
       this.licenseDate = licenseDate;
       this.certificateNumber = certificateNumber;
       this.certificateDate = certificateDate;
       this.address = address;
       this.idFiles = idFiles;
       this.idEmployesList = idEmployesList;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getIdOwnType() {
        return this.idOwnType;
    }
    
    public void setIdOwnType(int idOwnType) {
        this.idOwnType = idOwnType;
    }
    public int getIdLegalForm() {
        return this.idLegalForm;
    }
    
    public void setIdLegalForm(int idLegalForm) {
        this.idLegalForm = idLegalForm;
    }
    public String getOrgName() {
        return this.orgName;
    }
    
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public String getFioHead() {
        return this.fioHead;
    }
    
    public void setFioHead(String fioHead) {
        this.fioHead = fioHead;
    }
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getWebPage() {
        return this.webPage;
    }
    
    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }
    public String getLicenseNumber() {
        return this.licenseNumber;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    public Date getLicenseDate() {
        return this.licenseDate;
    }
    
    public void setLicenseDate(Date licenseDate) {
        this.licenseDate = licenseDate;
    }
    public String getCertificateNumber() {
        return this.certificateNumber;
    }
    
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }
    public Date getCertificateDate() {
        return this.certificateDate;
    }
    
    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public int getIdFiles() {
        return this.idFiles;
    }
    
    public void setIdFiles(int idFiles) {
        this.idFiles = idFiles;
    }
    public int getIdEmployesList() {
        return this.idEmployesList;
    }
    
    public void setIdEmployesList(int idEmployesList) {
        this.idEmployesList = idEmployesList;
    }




}

