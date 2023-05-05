package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class RollingStones {
    private List<Album> albumList = new ArrayList<>();

    public List<Album> getAlbumList() {
        return albumList;
    }



    public void ParseFile() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./albumlist.csv"));
        String line;
        int counter = 1;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(",\\s*");
            List<String> genres = new ArrayList<>();
            genres.add(words[4]);
            Album album = new Album(counter,Integer.valueOf(words[1]),words[2],words[3],genres);
            System.out.println(album);
            albumList.add(album);
            counter++;
        }
        reader.close();
    }


    public static void main(String args[]) {
        RollingStones rollingStones = new RollingStones();
        try {
            rollingStones.ParseFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(rollingStones.getAlbumList());
    }



}
