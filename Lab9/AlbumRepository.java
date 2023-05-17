package org.example;

import java.util.List;

public class AlbumRepository extends AbstractRepository<Album, Integer> {
    public AlbumRepository() {
        super(Album.class);
    }

    public List<Album> findByName(String name) {
        return super.em.createNamedQuery("Album.findByName").setParameter("title", name).getResultList();
    }

}
