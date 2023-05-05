package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {


        Database database = Database.getInstance();
        var ArtistDAO = new ArtistDAO();
        //Obiectele au fost deja create, am pus name-ul unique
        /*ArtistDAO.Create("RAVA");
        ArtistDAO.Create("Tzanca Uraganu");
        ArtistDAO.Create("Adi Minune");
        ArtistDAO.Create("Nicolae Guta");*/
        ArtistDAO.findAll();
        ArtistDAO.findByName("Adi Minune");
        ArtistDAO.findByID(1);

        var GenreDAO = new GenreDAO();
/*        GenreDAO.Create("Rap");
        GenreDAO.Create("Trap");
        GenreDAO.Create("Manele");*/
        GenreDAO.findByID(1);
        GenreDAO.findByName("Manele");
        GenreDAO.findAll();


       var AlbumDAO = new AlbumDAO();

/*        AlbumDAO.Create(2019,"Sistem turbat","Tzanca Uraganu","Manele");
        AlbumDAO.Create(2022,"ASA SUNT ZILELE MELE","Adi Minune","Manele");
        AlbumDAO.Create(2022,"BULIBA$HA","RAVA","Trap,Rap");*/
        AlbumDAO.findByName("Sistem turbat");
        AlbumDAO.findByID(2);


    }
}