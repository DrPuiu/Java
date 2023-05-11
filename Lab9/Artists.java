package org.example;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="Artists")
@NamedQueries({

        @NamedQuery(name = "Artist.findByName",
                query = "SELECT a FROM Artists a WHERE a.name = :name"),

        @NamedQuery(name = "Artist.findById",
                query = "SELECT a FROM Artists a WHERE a.id = :id")
})
public class Artists {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artists{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artists artists = (Artists) o;
        return id == artists.id && Objects.equals(name, artists.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
