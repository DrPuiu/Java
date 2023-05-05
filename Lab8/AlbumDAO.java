package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Array;

public class AlbumDAO {


    public void Create(int ReleaseYear, String Title, String Artist, String genres) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO public.\"Album\"(\"release_year\", \"title\", \"artist\", \"genres\") VALUES (?, ?, ?, ?);")) {
            pstmt.setInt(1, ReleaseYear);
            pstmt.setString(2, Title);
            pstmt.setString(3, Artist);
            String[] words = genres.split(",\\s*");

            Array genresArray = connection.createArrayOf("text", words);

            pstmt.setArray(4, genresArray);

            System.out.println(pstmt);
            pstmt.executeUpdate();
        }
    }


    public Album findByName(String title) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select \"id\", \"release_year\", \"artist\", \"genres\"  from \"Album\" where \"title\"='" + title + "'")) {
            if (rs.next()) {
                String[] words = rs.getString(4).split(",\\s*");
                List<String> arrayList = Arrays.stream(words).toList();
                Album album = new Album(rs.getInt(1), rs.getInt(2), title, rs.getString(3), arrayList);
                System.out.println(album);
            }
            return null;
        }
    }

    public Album findByID(int ID) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select \"title\", \"release_year\", \"artist\", \"genres\"  from \"Album\" where \"id\"=" + ID)) {
            if (rs.next()) {
                String[] words = rs.getString(4).split(",\\s*");
                List<String> arrayList = Arrays.stream(words).toList();
                Album album = new Album(ID, rs.getInt(2), rs.getString(1), rs.getString(3), arrayList);
                System.out.println(album);
                return album;
            }
            return null;
        }
    }
    public List<Album> findAll() throws SQLException {
        Connection connection = Database.getConnection();
        List<Album> albumList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select * from \"Album\""
             )) {
            while (resultSet.next()) {
                String[] words = resultSet.getString(4).split(",\\s*");
                List<String> arrayList = Arrays.stream(words).toList();
                Album album = new Album(resultSet.getInt(1), resultSet.getInt(2), 
                        resultSet.getString(3),resultSet.getString(4),arrayList );
                albumList.add(album);
            }
            System.out.println(albumList);
            return albumList;
        }


    }

}
