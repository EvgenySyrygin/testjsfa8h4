package com.kg.testjsfa8h4.entity;
// Generated Dec 14, 2016 1:26:34 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Form1 generated by hbm2java
 */
@Entity
@Table(name="form1"
    ,catalog="testjsfa8h4"
)
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
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="ID_OWN_TYPE", nullable=false)
    public int getIdOwnType() {
        return this.idOwnType;
    }
    
    public void setIdOwnType(int idOwnType) {
        this.idOwnType = idOwnType;
    }

    
    @Column(name="ID_LEGAL_FORM", nullable=false)
    public int getIdLegalForm() {
        return this.idLegalForm;
    }
    
    public void setIdLegalForm(int idLegalForm) {
        this.idLegalForm = idLegalForm;
    }

    
    @Column(name="ORG_NAME", nullable=false, length=100)
    public String getOrgName() {
        return this.orgName;
    }
    
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    
    @Column(name="FIO_HEAD", nullable=false, length=100)
    public String getFioHead() {
        return this.fioHead;
    }
    
    public void setFioHead(String fioHead) {
        this.fioHead = fioHead;
    }

    
    @Column(name="FAX", nullable=false, length=25)
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }

    
    @Column(name="PHONE", nullable=false, length=25)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="WEB_PAGE", nullable=false, length=100)
    public String getWebPage() {
        return this.webPage;
    }
    
    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    
    @Column(name="LICENSE_NUMBER", nullable=false, length=20)
    public String getLicenseNumber() {
        return this.licenseNumber;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LICENSE_DATE", nullable=false, length=10)
    public Date getLicenseDate() {
        return this.licenseDate;
    }
    
    public void setLicenseDate(Date licenseDate) {
        this.licenseDate = licenseDate;
    }

    
    @Column(name="CERTIFICATE_NUMBER", nullable=false, length=20)
    public String getCertificateNumber() {
        return this.certificateNumber;
    }
    
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CERTIFICATE_DATE", nullable=false, length=10)
    public Date getCertificateDate() {
        return this.certificateDate;
    }
    
    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    
    @Column(name="ADDRESS", nullable=false, length=250)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="ID_FILES", nullable=false)
    public int getIdFiles() {
        return this.idFiles;
    }
    
    public void setIdFiles(int idFiles) {
        this.idFiles = idFiles;
    }

    
    @Column(name="ID_EMPLOYES_LIST", nullable=false)
    public int getIdEmployesList() {
        return this.idEmployesList;
    }
    
    public void setIdEmployesList(int idEmployesList) {
        this.idEmployesList = idEmployesList;
    }




}


