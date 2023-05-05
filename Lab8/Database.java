package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/BazaDeDate1";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ninjutapalermo";
    private static Database single_instance = null;

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    private Database() {
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }


    public static Database getInstance() {
        if (single_instance == null) {
            single_instance = new Database();
        }
        return single_instance;
    }


    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
