package de.lyzeum.sql;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        SqlDatabase database = new SqlDatabase();
        database.addPerson(new Person("Max", "';DROP TABLE Person;--"));
        database.addPerson(new Person("Oskar", "Oskar"));
        database.printDatabaseContent();
        database.updatePerson(new Person(Optional.of(1),
                "Oskar",
                "Superoskar"));
        database.deletePersonByPk(1);
        database.printDatabaseContent();
    }
}