package com.kg.testjsfa8h4.dao;

import com.kg.testjsfa8h4.entity.Groups;
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
public class GroupsDao {
    public void addGroup(Groups group) {
        Transaction tx = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.save(group);
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
    public void deleteGroup(int idGroup) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Groups group = (Groups) session.load(Groups.class, new Integer(idGroup));
            session.delete(group);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    public void updateGroup (int idGroup, Groups group) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Groups oldGroup = (Groups) session.load(Groups.class, new Integer(idGroup));
            oldGroup.setDescription(group.getDescription());
            oldGroup.setPrivelege(group.getPrivelege());
            session.update(oldGroup);
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
    public Groups getGroupById (int idGroup) {
        Groups group = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Groups where id = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idGroup);
            group = (Groups) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return group;
    }
    public List<Groups> getAllGroups() {
        List<Groups> listGroups = new ArrayList<Groups>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            trns = session.beginTransaction();
            listGroups = session.createCriteria(Groups.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return listGroups;
    }
    
}
