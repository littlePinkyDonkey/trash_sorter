package com.trash_sorter.dao;


import com.trash_sorter.model.Tank;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TankDaoImpl implements TankDAO {
    private SessionFactory factory;
    public TankDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public boolean addNewTank(Tank tankName) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(tankName);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("Can't add " + e.getMessage());
            transaction.rollback();
        }finally {
            session.close();
        }
        return false;
    }
    @Override
    public boolean deleteTank(Tank tank) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(tank);
            transaction.commit();
        }catch (Exception e){
            System.out.println("Can't delete " + e.getMessage());
            transaction.rollback();
        }finally {
            session.close();
        }
        return true;
    }
    @Override
    public Tank getTankById(long id) {
        Session session = factory.openSession();
        Tank tank;
        try{
            tank = (Tank) session.get(Tank.class, id);
        }finally {
            session.close();
        }
        return tank;
    }
    @Override
    public List<Tank> getTanks() {
        Session session = factory.openSession();
        List<Tank> tanks;
        try {
            tanks = session.createQuery(
                    "from Tank").list();
        }finally {
            session.close();
        }
        return tanks;
    }
    @Override
    public Tank getTankByName(String name) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Tank tank = null;
        try{
//            Query query = session.createQuery("SELECT t FROM Tank t WHERE t.tankName = :name");
//            query.setParameter("name", name);
            Query query = session.createQuery(
                    "from Tank where tankName=:name");
            query.setParameter("name", name);
            tank = (Tank) query.uniqueResult();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return tank;
    }
    @Override
    public boolean addQR(String qr, long id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session.createSQLQuery(
                    "UPDATE tanks SET qr=? WHERE id=?");
            query.setParameter(0,qr);
            query.setParameter(1,id);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return false;
    }

}
