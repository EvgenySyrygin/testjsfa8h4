/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kg.testjsfa8h4.beans;

import com.kg.testjsfa8h4.dao.UsersDao;
import com.kg.testjsfa8h4.entity.Users;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author DEX
 */
@ManagedBean
@RequestScoped
public class UsersBean {

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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the idAccess
     */
    public String getIdAccess() {
        return idAccess;
    }

    /**
     * @param idAccess the idAccess to set
     */
    public void setIdAccess(String idAccess) {
        this.idAccess = idAccess;
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
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the loginDate
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * @param loginDate the loginDate to set
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
    
    //</editor-fold>

     private Integer id;
     private String login;
     private String password;
     private String idAccess;
     private String fio;
     private String phoneNumber;
     private String email;
     private Date createDate;
     private Date loginDate;
    /**
     * Creates a new instance of UsersBean
     */
    public UsersBean() {
    }
    
    public void addUser() {
        Users user = new Users(login, password, idAccess, fio, phoneNumber, email, new Date(), null);
        UsersDao usersDao = new UsersDao();
        usersDao.addUser(user);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User added id:"+user.getId()));
    }
    
    public void returnUserById() {
        UsersDao userDao = new UsersDao();
        Users user = userDao.getUserById(getId());
        if(user != null) {
            setLogin(user.getLogin());
            setPassword(user.getPassword());
            setIdAccess(user.getIdAccess());
            setFio(user.getFio());
            setPhoneNumber(user.getPhoneNumber());
            setEmail(user.getEmail());
            setCreateDate(user.getCreateDate());
            setLoginDate(user.getLoginDate());
        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User not exists"));
        }
    }
    
    public void deleteUser() {
        UsersDao userDao = new UsersDao();
        userDao.deleteUser(getId());
        setLogin("");
        setPassword("");
        setIdAccess("");
        setFio("");
        setPhoneNumber("");
        setEmail("");
        setCreateDate(null);
        setLoginDate(null);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User "+ getId() +" deleted"));
    }
    
    public void updateUser() {
        Users user = new Users(getLogin(), getPassword(), getIdAccess(), getFio(), getPhoneNumber(), getEmail(), getCreateDate(), getLoginDate());
        UsersDao userDao = new UsersDao();
        userDao.updateUser(getId(), user);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User updated"));
    }
    
}
