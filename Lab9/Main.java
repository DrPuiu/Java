package org.example;

public class Main {
    public static void main(String[] args) {
        ArtistRepository artistRepository = new ArtistRepository();
        System.out.println(artistRepository.findByID(1));
        System.out.println(artistRepository.findByName("Tzanca Uraganu"));
        Artists artists = new Artists();
        artists.setName("Marko Glass");
        //artistRepository.create(artists);
        System.out.println(artistRepository.findByName("Marko Glass"));
    }
}