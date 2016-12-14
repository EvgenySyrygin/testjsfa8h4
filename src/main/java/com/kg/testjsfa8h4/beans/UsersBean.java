package com.kg.testjsfa8h4.beans;

import com.kg.testjsfa8h4.dao.UsersDao;
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
public class UsersBean {

     private Integer id;
     private Groups groups;
     private String login;
     private String password;
     private String fio;
     private String phoneNumber;
     private String email;
     private Date createDate;
     private Date loginDate;
    
    public UsersBean() {
    }
    
    public void addUser() {
        Users user = new Users(groups, login, password, fio, phoneNumber, email, createDate, loginDate);
        UsersDao usersDao = new UsersDao();
        usersDao.addUser(user);
    }
    
    public void returnUserById() {
        UsersDao userDao = new UsersDao();
        Users user = userDao.getUserById(getId());
        if(user != null) {
            setLogin(user.getLogin());
            setPassword(user.getPassword());
            setGroups(user.getGroups());
            setFio(user.getFio());
            setPhoneNumber(user.getPhoneNumber());
            setEmail(user.getEmail());
            setCreateDate(user.getCreateDate());
            setLoginDate(user.getLoginDate());
        } else {
        }
    }
    
    public void deleteUser() {
        UsersDao userDao = new UsersDao();
        userDao.deleteUser(getId());
        setLogin("");
        setPassword("");
        setGroups(null);
        setFio("");
        setPhoneNumber("");
        setEmail("");
        setCreateDate(null);
        setLoginDate(null);
    }
    
    public void updateUser() {
        Users user = new Users(groups, login, password, fio, phoneNumber, email, createDate, loginDate);
        UsersDao userDao = new UsersDao();
        userDao.updateUser(getId(), user);
    }
    
    public List<Users> returnAllUsers() {
        UsersDao usersDao = new UsersDao();
        return usersDao.getAllUsers();
    }
    
    //<editor-fold defaultstate="collapsed" desc="get/set">
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
    
    //</editor-fold>
}
