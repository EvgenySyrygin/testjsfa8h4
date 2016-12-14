package com.kg.testjsfa8h4.data;

import com.kg.testjsfa8h4.entity.Groups;
import com.kg.testjsfa8h4.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author esyrygin
 */
public class GroupsDBTest {
    
    public GroupsDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void writeDeleteDataGroup() {
        Groups group = new Groups("priv", "descr");
                
        //write
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
        
        //delete
        session = new HibernateUtil().getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            Groups groupDelete = (Groups) session.load(Groups.class, new Integer(group.getIdAccess()));
            session.delete(groupDelete);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    
}
