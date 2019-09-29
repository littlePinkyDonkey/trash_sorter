package com.trash_sorter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ManyToManyDaoImpl implements ManyToManyDAO {
    private SessionFactory factory;

    public ManyToManyDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void makeDependency(long tank_id, long cat_id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session.createSQLQuery(
                    "INSERT INTO tanks_and_cats (tank_id, category_id) VALUES(?,?)");
            query.setParameter(0,tank_id);
            query.setParameter(1,cat_id);
            query.executeUpdate();

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }
}
