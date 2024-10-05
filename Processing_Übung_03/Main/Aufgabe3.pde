//import java.util.Arrays;

/*
Oft möchte man mehrere Werte speichern, z.B. besitzt in einem Multiplayer Spiel jeder Spieler einen eigenen Score.
Moegliche Implementierung:
  int scoreA, scoreB, scoreC;
  public void addPoint(int player, int points){
    if(player == 0){
      scoreA += points;
    }else if{
      scoreB += points;
    }else{
      scoreC += points;
    }
  }
  
Diese Methode ist jedoch ziemlich unelegant, da wir für jede moegliche Aktion eine eigene Methode schreiben muessen um einen bestimmten Score zu verwenden. 
Ausserdem muessen viele Variablen angelegt werden.
Eine bessere Loesung waere die Verwendung von Arrays:

  int NUMBER_OF_PLAYERS = 3;
  int[] scores = new int[NUMBER_OF_PLAYERS];
  
  public void addPoínt(int player, int points){
    if(player >= 0 && player < NUMBER_OF_PLAYERS){
      scores[player] += points;
    }
  }
  
Frage: Wieso gibt es If-Anweisung im unteren Code?

Arrays kann man als einen Behaelter verstehen, der einem Objekte eines vorher bestimmten Datentyps zurueckgibt.
Diese Objekte haben alle ihre eigene Nummer, d.h. man muss dem Array mitteilen, welches Nummer dieses bestimmte Objekt hat.
Konstruktor eines int-Arrays auf verschiedene Arten:
int[] arr1 = new int[5]; //Array geht von 0 bis 4 (-> also Groesse Array - 1)
int[] arr2 = new int[] {1, 2, 3, 4}; //Dieses Array bekommt sofort seine Elemente zugewiesen, sinnvoll wenn Elemente und Groesse schon vorher bekannt und kleines Array

Wir koennen auch zwei-dimensionale Arrays definieren:
int[][] arr3 = new int[10][10]; //geht von (0,0) bis (9,9) -> insgesamt 100 Elemente

Sinnvoll, wenn wir ein zweidimensionales Spielfeld (z.B. TicTacToe) erstellen wollen
Arrays haben eine Variable length (keine Methode!), die einem die Groesse des Arrays zurueckgibt.
Die Laenge braucht man oft, da die Groesse fuer Schleifendurchlaeufe bekannt sein sollte.

Um eine Konsolenausgabe zu erzeugen gibt es mehrere Wege:
1.) Methode selber schreiben
2.) Processing Methode printArray(<dein Array>) verwenden, Bsp. printArray(new float[] { 0.3f, 0.4f, 0.5f } ->println("[0] \n0.3 [1] 0.4 \n[2] 0.5");
3.) Verwendung einer Java-Bibliotheksmethode toString(), die einen String zurueckgibt.
    Beachte: Man muss dazu das Package java.util.Arrays benutzen. 
    Bsp: String toPrint = java.util.Arrays.toString(new float[] { 0.3f, 0.4f, 0.5f});
         println(toPrint); -> println("[0.3, 0.4, 0.5]");
         
    Vorteil: kompaktere Darstellung
    Nachteil: Ausgabe braucht zwei Schritte

*/
public class Aufgabe3{
  
  
  //Input: Ein Array mit Zahlen
  //Ziel: Gebe die Gesamtsumme der Elemente zurueck.
  public int sumArray(int[] array){
    return 0;
  }
  
  //Input: Ein Array mit Zahlen und eine Zahl x
  //Ziel: Gebe ein Array zurueck, dass nur Zahlen enthaelt, die groesser als x sind. Die Reihenfolge wird nicht veraendert.
  //Bsp: isGreaterThanX(2, {5, 1, 2, 4, 7}) = {5, 4, 7};
  public int[] isGreaterThanX(int x, int[] array){
    return new int[0];
  }
  
  //Input: Ein beliebiger Text
  //Ziel: Zaehle die Zahlen von 0 bis 9 im Text und gebe die Werte in einem Array zurueck.
 //       Am Index 0 steht die Anzahl der Ziffer Null, am Index 9 die Ziffer Neun.
 //Tipp: Man kann einen char als Zahl betrachten, z.B. hat der char '0' den Wert 48, '1' an 49, usw.
 //Bsp: countChars("H3ll0") = {1, 0 , 0, 1, 0, 0, 0, 0, 0, 0}
  public int[] countChars(String text){
     return new int[0];  
  }
  
  //Input: zwei gleich grosse Arrays mit Zahlen
  //Ziel: Vergleiche fuer jeden Index, ob das zweite Array die groessere Zahl enthaelt
  //Bsp: checkCondition({1, 2, 3}, {3, 2, 1}) = {true, false, false}
  public boolean[] checkCondition(int[] array, int[] array2){
    return new boolean[0];
  }
  
  //Input: einen Startwert, die Schrittweite und die Groesse des zu erzeugenden Arrays
  //Ziel: Erstelle einen Array mit Groesse size, anschliessend setze den Index 0 mit dem Startwert.
  //      Auf den naechsten Index wird step darauf addiert.
  //Bsp: initArray(5, 3, 4) = {5, 8, 11, 14}
  //Bsp: initArray(10, -1, 3) = {10, 9, 8}
  public int[] initArray(int start, int step, int size){
    return new int[0];
  }
  
 
}