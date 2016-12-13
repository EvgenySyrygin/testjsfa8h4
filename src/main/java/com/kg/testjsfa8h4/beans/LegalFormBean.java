package com.kg.testjsfa8h4.beans;

import com.kg.testjsfa8h4.dao.LegalFormDao;
import com.kg.testjsfa8h4.entity.LegalForm;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author DEX
 */
@ManagedBean
@RequestScoped
public class LegalFormBean {

    private Integer id;
    private String legalForm;
     
    public LegalFormBean() {
    }
    
    public void addLegalForm() {
        LegalForm legalFrom = new LegalForm(getLegalForm());
        LegalFormDao legalFormDao = new LegalFormDao();
        legalFormDao.addLegalForm(legalFrom);
    }
    
    public void returnLegalFormById() {
        LegalFormDao legalFormDao = new LegalFormDao();
        LegalForm legalFrom = legalFormDao.getLegalFormById(getId());
        if(legalFrom != null) {
            setLegalForm(legalFrom.getLegalForm());
        } else {
        }
    }
    
    public void deleteLegalForm() {
        LegalFormDao legalFormDao = new LegalFormDao();
        legalFormDao.deleteLegalForm(getId());
        setLegalForm("");
    }
    
    public void updateLegalForm() {
        LegalForm legalFrom = new LegalForm(getLegalForm());
        LegalFormDao legalFormDao = new LegalFormDao();
        legalFormDao.updateLegalForm(getId(), legalFrom);
    }


    public List<LegalForm> returnLegalForm() {
        LegalFormDao legalFormDao = new LegalFormDao();
        return legalFormDao.getAllLegalForms();
    }
    
    //<editor-fold defaultstate="collapsed" desc="get/set">
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }
    //</editor-fold>

    
}
