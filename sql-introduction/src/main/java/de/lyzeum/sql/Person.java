package de.lyzeum.sql;

import java.util.Optional;

public record Person (
    // Optional<Integer> pk, // TODO Hausaufgabe
    String vorname,
    String name
) {

}
