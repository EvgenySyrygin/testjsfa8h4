package com.kg.testjsfa8h4.dao;



import com.kg.testjsfa8h4.entity.Users;
import com.kg.testjsfa8h4.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DEX
 */
public class UsersDao {
    public void addUser(Users user) {
        Transaction tx = null;
        Session session = new HibernateUtil().getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.save(user);
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
    public void deleteUser(int idUser) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Users user = (Users) session.load(Users.class, new Integer(idUser));
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    public void updateUser (int idUser, Users user) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Users oldUser = (Users) session.load(Users.class, new Integer(idUser));
            oldUser.setLogin(user.getLogin());
            oldUser.setPassword(user.getPassword());
            oldUser.setIdAccess(user.getIdAccess());
            oldUser.setFio(user.getFio());
            oldUser.setPhoneNumber(user.getPhoneNumber());
            oldUser.setEmail(user.getEmail());
            oldUser.setCreateDate(user.getCreateDate());
            oldUser.setLoginDate(user.getLoginDate());
            session.update(oldUser);
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
    public Users getUserById (int idUser) {
        Users user = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Users where id = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idUser);
            user = (Users) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }
    
}
