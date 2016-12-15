package com.kg.testjsfa8h4.dao;

import com.kg.testjsfa8h4.entity.Form1;
import com.kg.testjsfa8h4.entity.Users;
import com.kg.testjsfa8h4.persistence.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DEX
 */
public class Form1Dao {
    public void addForm1(Form1 form1) {
        Transaction tx = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.save(form1);
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
    public void deleteForm1(int idForm1) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Form1 form1 = (Form1) session.load(Form1.class, new Integer(idForm1));
            session.delete(form1);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    public void updateForm1 (int idForm1, Form1 form1) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Form1 oldForm1 = (Form1) session.load(Form1.class, new Integer(idForm1));
            oldForm1.setAddress(form1.getAddress());
            oldForm1.setCertificateDate(form1.getCertificateDate());
            oldForm1.setCertificateNumber(form1.getCertificateNumber());
            oldForm1.setFax(form1.getFax());
            oldForm1.setFioHead(form1.getFioHead());
            oldForm1.setIdEmployesList(form1.getIdEmployesList());
            oldForm1.setIdFiles(form1.getIdFiles());
            oldForm1.setLegalForm(form1.getLegalForm());
            oldForm1.setOwnType(form1.getOwnType());
            oldForm1.setLicenseDate(form1.getLicenseDate());
            oldForm1.setLicenseNumber(form1.getLicenseNumber());
            oldForm1.setOrgName(form1.getOrgName());
            oldForm1.setPhone(form1.getPhone());
            oldForm1.setWebPage(form1.getWebPage());
            session.update(oldForm1);
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
    public Form1 getForm1ById (int idForm1) {
        Form1 form1 = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Form1 where id = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idForm1);
            form1 = (Form1) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return form1;
    }
    
    public List<Form1> getAllForm1() {
        List<Form1> listForm1 = new ArrayList<Form1>();
        List<Form1> listForm1Ret = new ArrayList<Form1>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            trns = session.beginTransaction();
            listForm1 = session.createCriteria(Form1.class).list();
            
            Iterator u = listForm1.iterator();
            while(u.hasNext()) {
                Form1 t = (Form1) u.next();
                Hibernate.initialize(t.getLegalForm());
                Hibernate.initialize(t.getOwnType());
                listForm1Ret.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return listForm1;
    }
    
}
