package de.lyzeum.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDatabase {

    private Connection connection;

    // INTEGER
    // TEXT
    // REAL: float/double
    // BLOB: Binärdaten
    // NONE: Unspezifischer Typ
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

    public void addPerson(Person person) {
        try {
            String query = "INSERT INTO Person('vorname', 'name') " +
                    "values (?, ?)";
            PreparedStatement statement =
                    connection.prepareStatement(query);
            // Zaehlung beginnt bei 1
            statement.setString(1, person.vorname());
            statement.setString(2, person.name());
            statement.setQueryTimeout(30); // in Sekunden
            statement.executeUpdate();
            // ResultSet rs =
            // TODO Result anschauen
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> fetchAllPerson() {
        List<Person> results = new ArrayList<>();
        try {
            // Baue SQL-Anfrage auf
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Person";
            ResultSet rs = statement.executeQuery(query);
            // Bearbeite Ergebnisse der Anfrage zeilenweise
            while(rs.next()) {
                String vn = rs.getString("vorname");
                String n = rs.getString("name");
                results.add(new Person(vn, n));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return results;
    }
}
