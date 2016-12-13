package com.kg.testjsfa8h4.beans;

import com.kg.testjsfa8h4.dao.EmployesDao;
import com.kg.testjsfa8h4.entity.EmployesList;
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
public class EmployesBean {

     private Integer id;
     private String idForm1;
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
        EmployesList empl = new EmployesList(idForm1, fio, phoneHome, phoneMobile, phoneWork, homeAddress, mail, bankDetails, position);
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
            setIdForm1(empl.getIdForm1());
            setMail(empl.getMail());
            setPhoneHome(empl.getPhoneHome());
            setPhoneMobile(empl.getPhoneMobile());
            setPhoneWork(empl.getPhoneWork());
            setPosition(empl.getPosition());
        } else {
        }
    }
    
    public void deleteEmploye() {
        EmployesDao emplDao = new EmployesDao();
        emplDao.deleteEmployes(getId());
        setBankDetails("");
        setFio("");
        setHomeAddress("");
        setIdForm1("");
        setMail("");
        setPhoneHome("");
        setPhoneMobile("");
        setPhoneWork("");
        setPosition("");
    }
    
    public void updateEmploye() {
        EmployesList empl = new EmployesList(idForm1, fio, phoneHome, phoneMobile, phoneWork, homeAddress, mail, bankDetails, position);
        EmployesDao emplDao = new EmployesDao();
        emplDao.updateEmployes(getId(), empl);
    }
    
    public List<EmployesList> returnAllEmployesList() {
        EmployesDao usersDao = new EmployesDao();
        return usersDao.getAllEmployes();
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
     * @return the idForm1
     */
    public String getIdForm1() {
        return idForm1;
    }

    /**
     * @param idForm1 the idForm1 to set
     */
    public void setIdForm1(String idForm1) {
        this.idForm1 = idForm1;
    }

    /**
     * @return the fio
     */
    public String getFio() {
        return fio;
    }

    /**
     * @param fio the fio to set
     */
    public void setFio(String fio) {
        this.fio = fio;
    }

    /**
     * @return the phoneHome
     */
    public String getPhoneHome() {
        return phoneHome;
    }

    /**
     * @param phoneHome the phoneHome to set
     */
    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    /**
     * @return the phoneMobile
     */
    public String getPhoneMobile() {
        return phoneMobile;
    }

    /**
     * @param phoneMobile the phoneMobile to set
     */
    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    /**
     * @return the phoneWork
     */
    public String getPhoneWork() {
        return phoneWork;
    }

    /**
     * @param phoneWork the phoneWork to set
     */
    public void setPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }

    /**
     * @return the homeAddress
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * @param homeAddress the homeAddress to set
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the bankDetails
     */
    public String getBankDetails() {
        return bankDetails;
    }

    /**
     * @param bankDetails the bankDetails to set
     */
    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }
        
    //</editor-fold>
}
