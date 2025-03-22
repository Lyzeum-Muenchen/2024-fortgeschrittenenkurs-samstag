package de.lyzeum.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDatabase {

    private Connection connection;

    public SqlDatabase() {
        try {
            this.connection = DriverManager
                    .getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS Person");
            String queryCreateTable = "CREATE TABLE Person (" +
                    "pk integer PRIMARY KEY autoINCREMENT, " +
                    "vorname string," +
                    "name string)";
            statement.executeUpdate(queryCreateTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
