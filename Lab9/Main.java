package org.example;

public class Main {
    public static void main(String[] args) {
        ArtistRepository artistRepository = new ArtistRepository();
        System.out.println(artistRepository.findById(1));
        System.out.println(artistRepository.findByName("Tzanca Uraganu"));
        System.out.println(artistRepository.findByName("Marko Glass"));
        GenreRepository genreRepository = new GenreRepository();
        System.out.println(genreRepository.findById(2));

        AlbumRepository albumRepository = new AlbumRepository();
        System.out.println(albumRepository.findById(1));
        System.out.println(albumRepository.findByName("Sistem turbat"));

    }
}