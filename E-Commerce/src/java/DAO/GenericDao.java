/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author KevinLeeMiguel
 * @param <X>
 */
public class GenericDao<X> {
    
    public FacesMessage create(X x) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(x);
            s.getTransaction().commit();
            s.close();
            return new FacesMessage(FacesMessage.SEVERITY_INFO, "", "");
        } catch (HibernateException ex) {
            return new FacesMessage(FacesMessage.SEVERITY_ERROR, " " + ex.getLocalizedMessage(), "");
        }
    }
    
    public String update(X x) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.update(x);
            s.getTransaction().commit();
            s.close();
            return "Done Successfully";
        } catch (Exception ex) {
            return "not Updated" + ex.getMessage();
        }
    }
    
    public String delete(X x) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.delete(x);
            s.getTransaction().commit();
            s.close();
            return "Saved";
        } catch (Exception ex) {
            return "not Saved" + ex.getMessage();
        }
    }
    
    public X findOne(Class x, Serializable id) {
        
        Session s = HibernateUtil.getSessionFactory().openSession();
        X o = (X) s.get(x.getName(), id);
        s.close();
        return o;
        
    }
    
    public List<X> findAll(Class c) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("from " + c.getName() + " s");
        List<X> l = q.list();
        s.close();
        return l;
    }
}
