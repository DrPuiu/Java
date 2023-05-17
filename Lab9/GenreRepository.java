package org.example;


import java.util.List;

public class GenreRepository extends AbstractRepository<Genres,Integer> {

    public GenreRepository() {
        super(Genres.class);
    }

    public List<Genres> findByName(String Name) {
        return super.em.createNamedQuery("Genres.findByName")
                .setParameter("name", Name)
                .getResultList();
    }
}

