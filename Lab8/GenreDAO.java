package org.example;

import javax.naming.Name;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
    public void Create(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into \"genres\"  (\"name\") values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Genre findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select \"id\" from \"genres\" where \"name\"='" + name + "'")) {
            if (rs.next()) {
                Genre genre = new Genre(rs.getInt(1), name);
                System.out.println(genre);
                return genre;
            }
            return null;
        }
    }

    public Genre findByID(int ID) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select \"name\" from \"genres\" where \"id\"=" + ID)) {
            if (rs.next()) {
                Genre genre = new Genre(ID, rs.getString(1));
                System.out.println(genre);
                return genre;
            }
            return null;
        }
    }

    public List<Genre> findAll() throws SQLException {
        Connection connection = Database.getConnection();
        List<Genre> genreList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select * from \"genres\""
             )) {
            while (resultSet.next()) {
                Genre genre = new Genre(resultSet.getInt(1), resultSet.getString(2));
                genreList.add(genre);
            }
            System.out.println(genreList);
            return genreList;
        }


    }
}
