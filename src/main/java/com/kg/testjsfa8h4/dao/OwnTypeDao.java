package com.kg.testjsfa8h4.dao;

import com.kg.testjsfa8h4.entity.OwnType;
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
public class OwnTypeDao {
    public void addOwnType(OwnType ownType) {
        Transaction tx = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.save(ownType);
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
    public void deleteOwnType(int idOwnType) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            OwnType ownType = (OwnType) session.load(OwnType.class, new Integer(idOwnType));
            session.delete(ownType);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    public void updateOwnType (int idOwnType, OwnType ownType) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            OwnType oldOwnType = (OwnType) session.load(OwnType.class, new Integer(idOwnType));
            oldOwnType.setOwnType(ownType.getOwnType());
            session.update(oldOwnType);
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
    public OwnType getOwnTypeById (int idOwnType) {
        OwnType ownType = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from OwnType where id = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idOwnType);
            ownType = (OwnType) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return ownType;
    }
    public List<OwnType> getAllOwnType() {
        List<OwnType> listOwnType = new ArrayList<OwnType>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            trns = session.beginTransaction();
            listOwnType = session.createCriteria(OwnType.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return listOwnType;
    }
    
}
