/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import org.hibernate.Session;

/**
 *
 * @author student
 */
public class test {
    Session session=HibernateUtil.getSessionFactory().openSession();
}
