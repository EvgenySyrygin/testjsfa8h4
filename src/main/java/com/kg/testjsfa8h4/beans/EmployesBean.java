package com.kg.testjsfa8h4.beans;

import com.kg.testjsfa8h4.dao.EmployesDao;
import com.kg.testjsfa8h4.entity.EmployesList;
import com.kg.testjsfa8h4.entity.Form1;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author DEX
 */
@ManagedBean
@RequestScoped
public class EmployesBean {

     private Integer id;
     private Form1 form1;
     private String fio;
     private String phoneHome;
     private String phoneMobile;
     private String phoneWork;
     private String homeAddress;
     private String mail;
     private String bankDetails;
     private String position;
    
    public EmployesBean() {
    }
    
    public void addEmploye() {
        EmployesList empl = new EmployesList(form1, fio, phoneHome, phoneMobile, phoneWork, homeAddress, mail, bankDetails, position);
        EmployesDao emplDao = new EmployesDao();
        emplDao.addEmployes(empl);
    }
    
    public void returnEmployeById() {
        EmployesDao emplDao = new EmployesDao();
        EmployesList empl = emplDao.getEmployesById(getId());
        if(empl != null) {
            setBankDetails(empl.getBankDetails());
            setFio(empl.getFio());
            setHomeAddress(empl.getHomeAddress());
            setForm1(empl.getForm1());
            setMail(empl.getMail());
            setPhoneHome(empl.getPhoneHome());
            setPhoneMobile(empl.getPhoneMobile());
            setPhoneWork(empl.getPhoneWork());
            setPosition(empl.getPosition());
        } else {
        }
    }
    
    public EmployesList returnEmployeById(int id) {
        EmployesDao emplDao = new EmployesDao();
        EmployesList empl = emplDao.getEmployesById(id);
        return empl;
    }
    
    public void deleteEmploye() {
        EmployesDao emplDao = new EmployesDao();
        emplDao.deleteEmployes(getId());
        setBankDetails("");
        setFio("");
        setHomeAddress("");
        setForm1(null);
        setMail("");
        setPhoneHome("");
        setPhoneMobile("");
        setPhoneWork("");
        setPosition("");
    }
    
    public void updateEmploye() {
        EmployesList empl = new EmployesList(form1, fio, phoneHome, phoneMobile, phoneWork, homeAddress, mail, bankDetails, position);
        EmployesDao emplDao = new EmployesDao();
        emplDao.updateEmployes(getId(), empl);
    }
    
    public List<EmployesList> returnAllEmployesList() {
        EmployesDao usersDao = new EmployesDao();
        return usersDao.getAllEmployes();
    }
    
    //<editor-fold defaultstate="collapsed" desc="get/set">
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public void setPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
        
    public Form1 getForm1() {
        return form1;
    }

    public void setForm1(Form1 form1) {
        this.form1 = form1;
    }
    //</editor-fold>

    
}
