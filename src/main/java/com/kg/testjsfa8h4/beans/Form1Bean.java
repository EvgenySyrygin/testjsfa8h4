package com.kg.testjsfa8h4.beans;

import com.kg.testjsfa8h4.dao.Form1Dao;
import com.kg.testjsfa8h4.entity.Form1;
import com.kg.testjsfa8h4.entity.LegalForm;
import com.kg.testjsfa8h4.entity.OwnType;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    private LegalForm legalForm;
    private OwnType ownType;
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
    private Set employesLists = new HashSet(0);
    private Set form1Fileses = new HashSet(0);

    
    public Form1Bean() {
    }
    
    public void addForm1() {
        Form1 form1 = new Form1(getLegalForm(), getOwnType(), orgName, fioHead, fax, phone, webPage, licenseNumber, licenseDate, certificateNumber, certificateDate, address, 0, 0);
        //Form1 form1 = new Form1(legalForm, ownType, orgName, fioHead, fax, phone, webPage, licenseNumber, licenseDate, certificateNumber, certificateDate, address, 0, 0, employesLists, form1Fileses);
        Form1Dao usersDao = new Form1Dao();
        usersDao.addForm1(form1);
    }
    
    public void returnForm1ById() {
        Form1Dao formDao = new Form1Dao();
        Form1 form1 = formDao.getForm1ById(getId());
        if(form1 != null) {
            setAddress(form1.getAddress());
            setCertificateDate(form1.getCertificateDate());
            setCertificateNumber(form1.getCertificateNumber());
            setFax(form1.getFax());
            setFioHead(form1.getFioHead());
            setIdEmployesList(form1.getIdEmployesList());
            setIdFiles(form1.getIdFiles());
            setLegalForm(form1.getLegalForm());
            setOwnType(form1.getOwnType());
            setLicenseDate(form1.getLicenseDate());
            setLicenseNumber(form1.getLicenseNumber());
            setOrgName(form1.getOrgName());
            setPhone(form1.getPhone());
            setWebPage(form1.getWebPage());
            setEmployesLists(form1.getEmployesLists());
            setForm1Fileses(form1.getForm1Fileses());
        } else {
        }
    }
    
    public Form1 returnForm1ById(int id) {
        Form1Dao formDao = new Form1Dao();
        Form1 form1 = formDao.getForm1ById(id);
        return form1;
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
            setLegalForm(null);
            setOwnType(null);
            setLicenseDate(null);
            setLicenseNumber("");
            setOrgName("");
            setPhone("");
            setWebPage("");
            setEmployesLists(null);
            setForm1Fileses(null);
    }
    
    public void updateForm1() {
        Form1 form1 = new Form1(getLegalForm(), getOwnType(), orgName, fioHead, fax, phone, webPage, licenseNumber, licenseDate, certificateNumber, certificateDate, address, 0, 0);
        //Form1 form1 = new Form1(legalForm, ownType, orgName, fioHead, fax, phone, webPage, licenseNumber, licenseDate, certificateNumber, certificateDate, address, 0, 0, employesLists, form1Fileses);
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
    
    public LegalForm getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(LegalForm legalForm) {
        this.legalForm = legalForm;
    }

    public OwnType getOwnType() {
        return ownType;
    }

    public void setOwnType(OwnType ownType) {
        this.ownType = ownType;
    }

    public Set getEmployesLists() {
        return employesLists;
    }

    public void setEmployesLists(Set employesLists) {
        this.employesLists = employesLists;
    }

    public Set getForm1Fileses() {
        return form1Fileses;
    }

    public void setForm1Fileses(Set form1Fileses) {
        this.form1Fileses = form1Fileses;
    }
    //</editor-fold>

    
}
