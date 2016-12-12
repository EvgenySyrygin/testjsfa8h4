/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kg.testjsfa8h4.beans;

import com.kg.testjsfa8h4.dao.GroupsDao;
import com.kg.testjsfa8h4.dao.UsersDao;
import com.kg.testjsfa8h4.entity.Groups;
import com.kg.testjsfa8h4.entity.Users;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class GroupsBean {

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
     * @return the privelege
     */
    public String getPrivelege() {
        return privelege;
    }

    /**
     * @param privelege the privelege to set
     */
    public void setPrivelege(String privelege) {
        this.privelege = privelege;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    //</editor-fold>

     private Integer id;
     private String privelege;
     private String description;
     
    /**
     * Creates a new instance of UsersBean
     */
    public GroupsBean() {
    }
    
    public void addGroup() {
        Groups group = new Groups(privelege, description);
        GroupsDao groupsDao = new GroupsDao();
        groupsDao.addGroup(group);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User added id:"+user.getId()));
    }
    
    public void returnGroupById() {
        GroupsDao grupsDao = new GroupsDao();
        Groups group = grupsDao.getGroupById(getId());
        if(group != null) {
            setDescription(group.getDescription());
            setPrivelege(group.getPrivelege());
        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User not exists"));
        }
    }
    
    public void deleteGroup() {
        GroupsDao groupsDao = new GroupsDao();
        groupsDao.deleteGroup(getId());
        setDescription("");
        setPrivelege("");
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User "+ getId() +" deleted"));
    }
    
    public void updateGroup() {
        Groups group = new Groups(getPrivelege(), getDescription());
        GroupsDao groupsDao = new GroupsDao();
        groupsDao.updateGroup(getId(), group);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User updated"));
    }


    public List<Groups> returnAllGroups() {
        GroupsDao groupsDao = new GroupsDao();
        System.out.println("!!!!!!!!!!!!!!!!!!!!");
        return groupsDao.getAllGroups();
        
    }
    
    
}
