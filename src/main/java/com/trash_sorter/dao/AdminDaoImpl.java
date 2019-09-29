package com.trash_sorter.dao;


import com.trash_sorter.model.Admin;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AdminDaoImpl implements AdminDAO {
    private SessionFactory factory;

    public AdminDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Admin getAdminByName(String adminName) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Admin admin = null;
        try {
            Query query = session.createQuery("from Admin where name=:admin");
            query.setParameter("admin",adminName);

            admin = (Admin) query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            System.out.println("Can`t get user: " + e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
        return admin;
    }
}
