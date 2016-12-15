package com.kg.testjsfa8h4.dao;

import com.kg.testjsfa8h4.entity.Form1Files;
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
public class Form1FilesDao {
    public void addForm1Files(Form1Files form1Files) {
        Transaction tx = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.save(form1Files);
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
    public void deleteForm1Files(int idForm1Files) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Form1Files form1Files = (Form1Files) session.load(Form1Files.class, new Integer(idForm1Files));
            session.delete(form1Files);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    public void updateForm1Files (int idForm1Files, Form1Files form1Files) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Form1Files oldForm1Files = (Form1Files) session.load(Form1Files.class, new Integer(idForm1Files));
            oldForm1Files.setFileData(form1Files.getFileData());
            oldForm1Files.setFileDate(form1Files.getFileDate());
            oldForm1Files.setFileName(form1Files.getFileName());
            oldForm1Files.setForm1(form1Files.getForm1());
            
            session.update(oldForm1Files);
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
    public Form1Files getForm1FilesById (int idUser) {
        Form1Files f1Files = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Form1Files where id = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idUser);
            f1Files = (Form1Files) query.uniqueResult();
            Hibernate.initialize(f1Files.getForm1());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return f1Files;
    }
    
    public List<Form1Files> getAllForm1File() {
        List<Form1Files> listF1Files = new ArrayList<Form1Files>();
        List<Form1Files> listF1FilesRet = new ArrayList<Form1Files>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            
            trns = session.beginTransaction();
            listF1Files = session.createCriteria(Form1Files.class).list();
            
            Iterator u = listF1Files.iterator();
            while(u.hasNext()) {
                Form1Files t = (Form1Files) u.next();
                Hibernate.initialize(t.getForm1());
                listF1FilesRet.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return listF1FilesRet;
    }
    
}
