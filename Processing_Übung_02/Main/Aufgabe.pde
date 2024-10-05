/*In diesem Aufgabenteil werden wir uns mit Funktionen beschaeftigen, die Eingabewert erhalten und daraus Ergebnisse berechnen koennen.

  Beispiel einer Methode:
  
  public int foo(int a, int b){
    return a + b;
  }

  "public" bedeutet, dass diese Methode von Aussen sichtbar ist. Damit kann unsere Main Klasse. Dies ist sinnvoll, wenn wir in der Main-Klasse auf diese Methode zugreifen wollen
  Anschliessend steht das Wort "int", an diese Stelle kommt der RUECKGABEWERT einer Methode. Ein Rueckgabewert ist sinnvoll, wenn wir in unserer Methode rechnen, sortieren, ... und am Ende das Ergebnis zur Verfuegung stellen wollen.
  "int" steht hier fuer den Datentyp Integer, einer ganzen Zahl(z.B. 0, 5, -12), wir geben hier eine Zahl zurueck.
  Den Datentyp String verwenden wir fuer Texte(z.B. "Hallo"), String koennen zusammengefuegt werden ("Stadt" + "bibliothek" wird zu "Stadtbibliothek").
  Zahlen koennen zu Strings werden, wenn man sie mit einem anderen String verbindet (5 + " Plus 7" wird zu "5 Plus 7")
  Wenn wir keinen Wert zurueckgeben wollen, dann schreiben wir an diese Stelle "void". 
  In den runden Klammern stehen unsere EINGABEPARAMETER, in unserem Beispiel erhalten wir zwei Zahlen mit dem Vaiablennamen a und b.
  Zwischen den zwei geschweiften Klammern steht unser Code. Es gibt drei Arten von Befehlen:
   1.) Zuweisungen: (Bsp: c = a + b; ) Auf die linke Seite vom IstGleich-Operator kommt eine Variable (z.B. ein Integer), auf die rechte Seite kommt unser neuer Wert hin. 
       Dieser neue Werte kann sich aus Konstanten zusammensetzen oder durch Operationen unter Werten, Konstanten, Variablen und aus Funktionsaufrufen entstehen. Am Ende kommt ein Semikolon ";" .
       a) Was ist der neue Wert bei "c = 3+7;" ?
       b) Was passiert bei "i = i + 1;"?
   2.) Befehlsaufrufe mit Typ void: (Bsp.: resetGame();)Manchmal rufen wir weitere Methoden auf, die ihre Aufgaben erledigen sollen ohne Werte zu liefern. Solche Aufrufe stehen gewoehnlich in einer Zeile.
   3.) return-Statement: (Bsp. return -1;"): Diese Zeile steht immer am Ende unserer Methode, das heisst es darf keine weitere Codezeile hinter unserem Code vorkommen. Nach dem "return" steht unser Ergebnis der Methode. 
       ACHTUNG! Bei einer void-Methode ist kein return-Statement notwendig.
       
  Aufgabe: Fuelle die Funktionen aus! Bei einer Programmausfuehrung wird die Mainklasse diese Funktionen aufrufen, die Ergebnisse in Tests vergleichen und die Resultate auf der Konsole ausgeben.
      Hinweis: return Statement enthaelt nur Platzhalter und muss definitv veraendert werden.

*/


/*
Loesungsvorschlag
*/
public class Aufgabe1{
  
  private int lastNumber; //<-wird fuer letzte Teilaufgabe benoetigt
  
  public Aufgabe1(){
    lastNumber = 0; //Startwert 0
  }
  
  //Input: Du erhaelst eine Zahl vom Typ Integer.
  //Ziel: Multipliziere die Zahl und gebe deas Ergebnis zurueck
  public int timesTwo(int input){
    //Die Zahl wird mit zwei multipliziert und anschliessend zurueckgegeben
    return 2*input;
  }
  
  
  //Input: Du erhaelst eine Zahl vom Typ Integer.
  //Ziel: schau, ob Zahl groesser als fuenf ist.
  public boolean isGreaterThanFive(int input){
    //(input > 5) ist vom Typ boolean und vergleicht, ob die Zahl input groesse als 5 ist. Wert wird zurueckgegeben
    return input > 5;
  }
  
  //Input: drei Zahlen
  //Ziel: Gebe den groessten der drei Werte zurueck.
  public int getHighestValue(int a, int b, int c){
    //Es wird angenommen a ist die groesste Zahl.
    //Danach wird diese Zahl mit b verglichen, die hoehere Zahl speichern wir ab.
    //Mit dem Wert machen wir dasselbe, zum Schluss geben wir das Ergebnis zurueck.
    int highestNumber = a;
    if(highestNumber < b){
      highestNumber = b;
    }
    if(highestNumber < c){
      highestNumber = c;
    }
    return highestNumber;
  }
  
  //Input: eine Zahl n
  //Ziel: Gebe die Quadratzahl zurueck. Bsp. getSquare(1) = 1; getSquare(5) = 25;
  public int getSquare(int n){
    //Bsp n = 2: 2 * 2 = n * n = 4 <-richtige Loesung
    return n*n;
  }
  
  //Input: eine Zahl x
  //Ziel: Gebe den positiven Wert (Betrag) der Zahl zurueck. 
  //  Bsp.: getAbsoluteValue(3) = 3
  //        getAbsoluteValue(-3) = 3
  //        getAbsoluteValue(0) = 0
  public int getAbsoluteValue(int x){
    //Falls Zahl kleiner als 0, wird die Zahl mit -1 multipliziert. Danach ist sie groesser als 0.
    //Im anderen Falls kann sie direkt zurueckgegeben werden
    if(x < 0){
      return -x;
    }else{
      return x;
    }
    
    //Alternative:
    //return (x < 0)?-x:x;
  }
  
  //Input: eine Zahl
  //Ziel: Beim ersten Aufruf der Funktion die Zahl eins zurueckgeben, Speichere nextValue. Beim erneuten Aufruf gibst du die gepsicherte Zahl zurueck und speicherst wiederum die uebergebene Zahl
  //  Bsp.: getLastValue(-6) = 0
  //        getLastValue(17) = -6
  //        getLastValue(2) = 17 //usw.
  public int getLastValue(int nextValue){
    int res = lastNumber;
    lastNumber = nextValue;
    return res;
  }
  
}