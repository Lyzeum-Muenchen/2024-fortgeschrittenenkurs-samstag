# Text Editor

## Empfohlene Voraussetzungen

- Java JDK 21 (z.B. Amazon corretto)
- IntelliJ

## Start der Applikation

1.) Gradle Projekt Sync durchführen
2.) Gradle Task `gradle run` durchführen

## Hinweise

- Normaler Start ohne Gradle scheint mit JavaFx mit dem Template nicht zu funktionieren.
- Macs benötigen in der Datei `build.gradle` die mindestens die JavaFx Version `21.0.2` um starten zu können
- Beim Fehler `Cause: error: invalid source release: 21` muss die Einstellung `Settings -> Build, Execution, Deployment -> Build Tools -> Gradle -> Gradle JVM` in IntelliJ auf ein Java JDK mit Version `21` umgestellt werden.