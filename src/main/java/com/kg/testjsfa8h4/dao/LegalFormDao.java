package com.kg.testjsfa8h4.dao;

import com.kg.testjsfa8h4.entity.LegalForm;
import com.kg.testjsfa8h4.persistence.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DEX
 */
public class LegalFormDao {
    public void addLegalForm(LegalForm legalForm) {
        Transaction tx = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.save(legalForm);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }
    public void deleteLegalForm(int idLegalForm) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            LegalForm legalForm = (LegalForm) session.load(LegalForm.class, new Integer(idLegalForm));
            session.delete(legalForm);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    public void updateLegalForm (int idLegalForm, LegalForm legalForm) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            LegalForm oldLegalForm = (LegalForm) session.load(LegalForm.class, new Integer(idLegalForm));
            oldLegalForm.setLegalForm(legalForm.getLegalForm());
            session.update(oldLegalForm);
            trns.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(trns != null) {
                trns.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }
    public LegalForm getLegalFormById (int idLegalForm) {
        LegalForm legaForm = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from LegalForm where id = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idLegalForm);
            legaForm = (LegalForm) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return legaForm;
    }
    public List<LegalForm> getAllLegalForms() {
        List<LegalForm> listLegalForms = new ArrayList<LegalForm>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            trns = session.beginTransaction();
            listLegalForms = session.createCriteria(LegalForm.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return listLegalForms;
    }
    
}
