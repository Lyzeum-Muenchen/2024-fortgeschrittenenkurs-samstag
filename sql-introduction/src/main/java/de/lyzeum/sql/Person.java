package de.lyzeum.sql;

import java.util.Optional;

public record Person (
    Optional<Integer> pk,
    String vorname,
    String name
) {

    // Konstruktor mit weniger Parametern
    public Person(String vorname, String name) {
        this(Optional.empty(), vorname, name);
    }

}
