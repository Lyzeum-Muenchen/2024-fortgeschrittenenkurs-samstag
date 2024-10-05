/*
  Diesmal wollen wir uns mit Strings beschaeftigen. 
  int, boolean, float, byte, short, long und char sind sogenannte primitive Datentypen, d.h. sie nehmen eine feste Groesse im Speicher ein und beschreiben eine Menge an Werten.
  Beispiel:
  int kann ganze Zahlen von -(2^31) bis (2^31-1) (ca. 2 Milliarden) darstellen, boolean hat nur die Werte true und false.
  
  Im Gegensatz dazu sind String ein Referenzdatentyp, d.h. er wurde unter anderem aus primitiven Datentypen zusammengebaut. 
  Man kann Objekte vom Typ String auf zwei Arten erzeugen:
  String abc = "abc";
  abc = new String("abc");   //macht dasselbe wie die Zeile darueber
  
  Wir koennen neue Strings erstellen, indem wir mehrere Strings mit einem "+" verketten.
  Bsp:
  String combined = "this is part one, " + "here is part two.";
  
  Man kann auch einen Integer direkt in einen String umwandeln, wenn ein String dabei ist
  Bsp.:
  int x = 3;
  String s1 = x; //<-funktioniert nicht, Fehler wird geworfen
  String s2 = x + ""; //funktioniert
  
  Strings haben wie unsere Klassen auch Methoden, die man aufrufen kann.
  
  Beispiele:
  
  int length(); //Achtung Klammer!!! gibt die Anzahl der Zeichen zurueck
  char charAt(int i); //i ist hier ein Integer, hier wird ein Zeichen zurueckgegeben am Index i.
  String replace(String replaceWhat, String replaceWith); //Wir koennen nach einem Stringausschnitt suchen und diesen durch einen anderen ersetzen
  String[] split(String splitter);   //Wir teilen unseren String in kleine Teile, naemlich an den Stellen wo unser splitter vorkommt
  boolean equals(String compare);   //Achtung! Bei Referenzdatentypen funktioniert "==" nicht, d.h. Vergleiche bei Strings funktionieren anders.
                                    //equals nimmt einen String entgegen und prueft, ob die Zeichen alle uerbereinstimmen.
  String substring(int startIndex); //Der neue String beginnt erst ab der der Stelle startIndex
  String substring(int startIndex, int endIndex);//wie oben, nur der neue String geht bis zur Stelle vor endIndex
  
  Beispiele fuer die Verwendung:
  String s = "Ferien sind toll!";
  s.length();                 //Rueckgabe: 17
  s.charAt(2);                 //Rueckgabe: 'r' //Apostroph wird bei char (einem Zeichen) verwendet
  s.replace("Ferien", "Lernen");//Rueckgabe: "Lernen ist toll!"
  s.split(" ");               //Rueckgabe: {"Ferien", "sind", "toll!"}
  s.equals("error");          //Rueckgabe: false
  s.substring(12);            //Rueckgabe: "toll!"
  s.substring(0, 6);          //Rueckgabe: "Ferien"

  Dokumentation mit weiteren Methoden:
  https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
*/
public class Aufgabe2{
  
  public Aufgabe2(){
    
  }
  
  //Input: ein String
  //Ziel: Laenge des Strings als String zurueckgeben
  //Bsp.: getLength("abc") = "3";
  public String getLength(String s){
    return s.length() + "";
  }
  
  //Input: ein String
  //Ziel: ueberpruefe, ob der String gleich "Fun" ist. Falls ja, dann gib "yes" zurueck, andernfalls "no"
  public String isItFun(String s){
    // <bedingung> ? <wert_bedingung_erfüllt> : <wert_bedingung_nicht_erfüllt>
    return (s.equals("Fun")) ? "yes" : "no";
  }
  
  //Input: ein String mit mind. Laenge 3
  //Ziel: Waehle die ersten drei Zeichen aus, verdreifache diese Zeichenkette und gib diese zurueck.
  //Bsp.:
  //makeItThree("Funny") = "FunFunFun";//"Funny" wird zu "Fun", dann haengen wir es zweimal noch an.
  
  public String makeItThree(String s){
    String substr = s.substring(0, 3); // ersten drei Zeichen
    return substr + substr + substr;
  }
  
  //Input: ein String, ein Zeichen
  //Ziel: Zaehle, wie oft das Zeichen c im String vorkommt
  public int countChar(String s, char c){
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        result++;
      }
    }
    return result;
  }
  //Input: Ein String
  //Ziel: Palindrome kann man vor- und rueckwaerts gleich lesen, z.B. Otto, Uhu
  //      Pruefe, ob die Eingabe ein Palindrom ist
  public boolean isPalindrome(String s){
    String ersteHaelfte = s.substring(0, s.length() / 2);
    String ersteHaelfteGespiegelt = new StringBuilder(ersteHaelfte)
                                      .reverse()
                                      .toString();
    return s.endsWith(ersteHaelfteGespiegelt);
  }
  
}
