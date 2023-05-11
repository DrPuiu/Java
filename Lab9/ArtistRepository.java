package org.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class ArtistRepository {
    private EntityManager entityManager = EntityManagementSingleton.getSingleInstance().em;

    public ArtistRepository() {
    }

    public List<Artists> findByID(int ID) {
        return entityManager.createNamedQuery("Artist.findById")
                .setParameter("id", ID)
                .getResultList();
    }

    public List<Artists> findByName(String Name) {
        return entityManager.createNamedQuery("Artist.findByName")
                .setParameter("name", Name)
                .getResultList();
    }
    public void create (Artists artist) {
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
    }
}
