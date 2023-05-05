package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {

    public void Create(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into \"artists\"  (\"name\") values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Artist findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select \"id\" from \"artists\" where \"name\"='" + name + "'")) {
            if (rs.next()) {
                Artist artist = new Artist(name, rs.getInt(1));
                System.out.println(artist);
                return artist;
            }
            return null;
        }
    }

    public Artist findByID(int ID) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select \"name\" from \"artists\" where \"id\"=" + ID)) {
            if (rs.next()) {
                Artist artist = new Artist(rs.getString(1), ID);
                System.out.println(artist);
                return artist;
            }
            return null;
        }
    }

    public List<Artist> findAll() throws SQLException {
        Connection connection = Database.getConnection();
        List<Artist> artistList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select * from \"artists\""
             )) {
            while (resultSet.next()) {
                Artist artist = new Artist(resultSet.getString(2), resultSet.getInt(1));
                artistList.add(artist);
            }
            System.out.println(artistList);
            return artistList;
        }


    }
}
