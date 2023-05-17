package org.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public abstract class AbstractRepository<T, ID> {
    protected EntityManager em = EntityManagementSingleton.getSingleInstance().em;
    private Class<T> entityClass;

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T findById(ID id) {
        return em.find(entityClass, id);
    }

    public T create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    public abstract List<T> findByName(String name);
}
