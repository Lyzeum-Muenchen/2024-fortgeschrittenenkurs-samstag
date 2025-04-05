package de.lyzeum.sql;

public class Main {
    public static void main(String[] args) {
        SqlDatabase database = new SqlDatabase();
        database.addPerson(new Person("Max", "';DROP TABLE Person;--"));
        database.addPerson(new Person("Oskar", "Oskar"));
        database.printDatabaseContent();
    }
}