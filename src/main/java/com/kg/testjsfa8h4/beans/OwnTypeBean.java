package com.kg.testjsfa8h4.beans;

import com.kg.testjsfa8h4.dao.GroupsDao;
import com.kg.testjsfa8h4.dao.OwnTypeDao;
import com.kg.testjsfa8h4.entity.Groups;
import com.kg.testjsfa8h4.entity.OwnType;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author DEX
 */
@ManagedBean
@RequestScoped
public class OwnTypeBean {

     private Integer id;
     private String ownType;
     
    public OwnTypeBean() {
    }
    
    public void addOwnType() {
        OwnType owType = new OwnType(ownType);
        OwnTypeDao ownTypeDao = new OwnTypeDao();
        ownTypeDao.addOwnType(owType);
    }
    
    public void returnOwnTypeById() {
        OwnTypeDao ownTypeDao = new OwnTypeDao();
        OwnType owType = ownTypeDao.getOwnTypeById(getId());
        System.out.println("ready");
        if(owType != null) {
            setOwnType(owType.getOwnType());
            System.out.println("ok");
        } else {
        }
    }
    
    public void deleteOwnType() {
        OwnTypeDao ownTypeDao = new OwnTypeDao();
        ownTypeDao.deleteOwnType(getId());
        setOwnType("");
    }
    
    public void updateOwnType() {
        OwnType owType = new OwnType(getOwnType());
        OwnTypeDao ownTypeDao = new OwnTypeDao();
        ownTypeDao.updateOwnType(getId(), owType);
    }


    public List<OwnType> returnAllOwnType() {
        OwnTypeDao ownTypeDao = new OwnTypeDao();
        return ownTypeDao.getAllOwnType();
    }
    
    //<editor-fold defaultstate="collapsed" desc="get/set">
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnType() {
        return ownType;
    }

    public void setOwnType(String ownType) {
        this.ownType = ownType;
    }
    //</editor-fold>

    
}
