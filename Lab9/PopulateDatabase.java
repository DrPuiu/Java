package org.example;

import com.github.javafaker.Faker;

public class PopulateDatabase {
    private static final String[] Genres = {"Trap", "Rap", "Clasic", "Opera",
            "Electronic", "Dubstep", "Manele", "Trapanele", "Lautareasca", "Trap Alternativ",
            "Trap Modern", "Jazz", "Punk", "Bizantin", "Coral", "Rava", "Trap industrial"};

    public static long FIll(int numberOfEntries) {
        long startTime = System.currentTimeMillis();
        Faker faker = new Faker();
        AlbumRepository albumRepository = new AlbumRepository();
        ArtistRepository artistRepository = new ArtistRepository();
        for (int i = 0; i < numberOfEntries; i++) {
            int ReleaseYear = (int) (Math.random() * 100 + 1800);
            int genre = (int) (Math.random() * 17);

            Album album = new Album();
            album.setArtist(faker.name().nameWithMiddle());
            album.setGenres(Genres[genre]);
            album.setReleaseYear(ReleaseYear);
            album.setTitle(faker.name().title());
            albumRepository.create(album);

            Artists artists = new Artists();
            artists.setName(faker.name().nameWithMiddle());
            artistRepository.create(artists);

        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static void main(String[] args) {
        System.out.println(PopulateDatabase.FIll(500));
    }
}

