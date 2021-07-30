package com.temzu.preparation.lesson_5.repositories;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractRepository<T> implements IRepository<T> {
    private EntityManagerFactory factory;
    private EntityManager em;
    private Class<T> typeClass;

    public AbstractRepository() {
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
        em = factory.createEntityManager();
        ParameterizedType t = (ParameterizedType) this.getClass().getGenericSuperclass();
        typeClass = (Class<T>) t.getActualTypeArguments()[0];
    }

    @Override
    public void save(T e) {
        em.getTransaction().begin();
        if (e != null)
            em.persist(e);
        em.getTransaction().commit();
    }

    @Override
    public void delete(T e) {
        em.getTransaction().begin();
        if (e != null)
            em.remove(e);
        em.getTransaction().commit();
    }

    @Override
    public T findById(long id) {
        T el;
        em.getTransaction().begin();
        el = em.find(typeClass, id);
        em.getTransaction().commit();
        return el;
    }
}
