package com.daniil1380.first.dao;


import com.daniil1380.first.entity.PersonEntity;
import com.daniil1380.first.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonDao {

    public PersonEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(PersonEntity.class, id);
    }

    public void save(PersonEntity personEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(personEntity);
        tx1.commit();
        session.close();
    }

    public void update(PersonEntity personEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(personEntity);
        tx1.commit();
        session.close();
    }

    public void delete(PersonEntity personEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(personEntity);
        tx1.commit();
        session.close();
    }

}
