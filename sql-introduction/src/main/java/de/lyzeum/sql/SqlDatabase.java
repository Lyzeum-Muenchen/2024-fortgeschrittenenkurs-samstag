package de.lyzeum.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            statement.close();
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
            statement.close();
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
                int pk = rs.getInt("pk");
                String vn = rs.getString("vorname");
                String n = rs.getString("name");
                results.add(new Person(Optional.of(pk), vn, n));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return results;
    }

    // TODO PreparedStatement
    public void updatePerson(Person p) {
        String query = "UPDATE Person SET vorname = ?, "
                + "name = ? WHERE pk = ?;";
        try (PreparedStatement statement
                     = connection.prepareStatement(query)) {
            statement.setString(1, p.vorname());
            statement.setString(2, p.name());
            statement.setInt(3, p.pk().orElseThrow());
            // gibt Integer aus Optional zurück
            // ODER wirft eine Exception
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePersonByPk(int pk) {
        String query = "DELETE FROM Person where pk = ?;";
        try (PreparedStatement statement =
                     connection.prepareStatement(query)) {
            statement.setInt(1, pk);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void printDatabaseContent() {
        List<Person> entries = fetchAllPerson();
        // System.out.println(entries); // wird leider nicht lesbar formatiert
        for (Person p: entries) {
            System.out.println(p);
        }
        System.out.println("------------------");
    }
}
