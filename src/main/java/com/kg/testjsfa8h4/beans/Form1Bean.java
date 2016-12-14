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
        Form1Dao usersDao = new Form1Dao();
        return usersDao.getAllForm1();
    }
    
    //<editor-fold defaultstate="collapsed" desc="get/set">

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the idOwnType
     */
    public int getIdOwnType() {
        return idOwnType;
    }

    /**
     * @param idOwnType the idOwnType to set
     */
    public void setIdOwnType(int idOwnType) {
        this.idOwnType = idOwnType;
    }

    /**
     * @return the idLegalForm
     */
    public int getIdLegalForm() {
        return idLegalForm;
    }

    /**
     * @param idLegalForm the idLegalForm to set
     */
    public void setIdLegalForm(int idLegalForm) {
        this.idLegalForm = idLegalForm;
    }

    /**
     * @return the orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName the orgName to set
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return the fioHead
     */
    public String getFioHead() {
        return fioHead;
    }

    /**
     * @param fioHead the fioHead to set
     */
    public void setFioHead(String fioHead) {
        this.fioHead = fioHead;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the webPage
     */
    public String getWebPage() {
        return webPage;
    }

    /**
     * @param webPage the webPage to set
     */
    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    /**
     * @return the licenseNumber
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * @param licenseNumber the licenseNumber to set
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * @return the licenseDate
     */
    public Date getLicenseDate() {
        return licenseDate;
    }

    /**
     * @param licenseDate the licenseDate to set
     */
    public void setLicenseDate(Date licenseDate) {
        this.licenseDate = licenseDate;
    }

    /**
     * @return the certificateNumber
     */
    public String getCertificateNumber() {
        return certificateNumber;
    }

    /**
     * @param certificateNumber the certificateNumber to set
     */
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    /**
     * @return the certificateDate
     */
    public Date getCertificateDate() {
        return certificateDate;
    }

    /**
     * @param certificateDate the certificateDate to set
     */
    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the idFiles
     */
    public int getIdFiles() {
        return idFiles;
    }

    /**
     * @param idFiles the idFiles to set
     */
    public void setIdFiles(int idFiles) {
        this.idFiles = idFiles;
    }

    /**
     * @return the idEmployesList
     */
    public int getIdEmployesList() {
        return idEmployesList;
    }

    /**
     * @param idEmployesList the idEmployesList to set
     */
    public void setIdEmployesList(int idEmployesList) {
        this.idEmployesList = idEmployesList;
    }
    
    //</editor-fold>
}
