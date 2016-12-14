package com.kg.testjsfa8h4.beans;

import com.kg.testjsfa8h4.dao.GroupsDao;
import com.kg.testjsfa8h4.entity.Groups;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author DEX
 */
@ManagedBean
@RequestScoped
public class GroupsBean {

    private Integer id;
    private String privelege;
    private String description;
     
    public GroupsBean() {
    }
    
    public void addGroup() {
        Groups group = new Groups(privelege, description);
        GroupsDao groupsDao = new GroupsDao();
        groupsDao.addGroup(group);
    }
    
    public void returnGroupById() {
        GroupsDao grupsDao = new GroupsDao();
        Groups group = grupsDao.getGroupById(getId());
        if(group != null) {
            setDescription(group.getDescription());
            setPrivelege(group.getPrivelege());
        } else {
        }
    }
    
    public Groups returnGroupById(int id) {
        GroupsDao grupsDao = new GroupsDao();
        Groups group = grupsDao.getGroupById(id);
        if(group != null) {
            setDescription(group.getDescription());
            setPrivelege(group.getPrivelege());
        } else {
        }
        return group;
    }
    
    public void deleteGroup() {
        GroupsDao groupsDao = new GroupsDao();
        groupsDao.deleteGroup(getId());
        setDescription("");
        setPrivelege("");
    }
    
    public void updateGroup() {
        Groups group = new Groups(getPrivelege(), getDescription());
        GroupsDao groupsDao = new GroupsDao();
        groupsDao.updateGroup(getId(), group);
    }


    public List<Groups> returnAllGroups() {
        GroupsDao groupsDao = new GroupsDao();
        return groupsDao.getAllGroups();
    }
    
    //<editor-fold defaultstate="collapsed" desc="get/set">
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrivelege() {
        return privelege;
    }

    public void setPrivelege(String privelege) {
        this.privelege = privelege;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //</editor-fold>
}
