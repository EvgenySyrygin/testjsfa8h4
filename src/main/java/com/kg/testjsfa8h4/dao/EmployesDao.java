package com.kg.testjsfa8h4.dao;

import com.kg.testjsfa8h4.entity.EmployesList;
import com.kg.testjsfa8h4.entity.Users;
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
public class EmployesDao {
    public void addEmployes(EmployesList empl) {
        Transaction tx = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.save(empl);
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
    public void deleteEmployes(int idEmployes) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            EmployesList empl = (EmployesList) session.load(EmployesList.class, new Integer(idEmployes));
            session.delete(empl);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    public void updateEmployes (int idEmploye, EmployesList empl) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            EmployesList oldEmpl = (EmployesList) session.load(EmployesList.class, new Integer(idEmploye));
            oldEmpl.setBankDetails(empl.getBankDetails());
            oldEmpl.setFio(empl.getFio());
            oldEmpl.setHomeAddress(empl.getHomeAddress());
            oldEmpl.setIdForm1(empl.getIdForm1());
            oldEmpl.setMail(empl.getMail());
            oldEmpl.setPhoneHome(empl.getPhoneHome());
            oldEmpl.setPhoneMobile(empl.getPhoneMobile());
            oldEmpl.setPhoneWork(empl.getPhoneWork());
            oldEmpl.setPosition(empl.getPosition());
            session.update(oldEmpl);
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
    public EmployesList getEmployesById (int idEmpl) {
        EmployesList empl = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from EmployesList where id = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idEmpl);
            empl = (EmployesList) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return empl;
    }
    
    public List<EmployesList> getAllEmployes() {
        List<EmployesList> listEmployesList = new ArrayList<EmployesList>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            trns = session.beginTransaction();
            listEmployesList = session.createCriteria(EmployesList.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return listEmployesList;
    }
    
}
