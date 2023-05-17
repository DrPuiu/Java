package org.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class ArtistRepository extends AbstractRepository<Artists, Integer> {

    public ArtistRepository() {
        super(Artists.class);
    }
    public List<Artists> findByName(String Name) {
        return super.em.createNamedQuery("Artist.findByName")
                .setParameter("name", Name)
                .getResultList();
    }
}
