/**

  Aufgaben im Tab/Klasse Aufgabe
  LÖSUNG
**/


//Tests, NICHT VERAENDERN!!!
void setup(){
  size(200, 200);
   // aufgabe1();
   // aufgabe2();
   aufgabe3();
}

void aufgabe1(){
  Aufgabe1 aufgabe = new Aufgabe1();
   //timesTwo
   assertTest(0 , aufgabe.timesTwo(0), "timesTwo Test 1");
   assertTest(30 , aufgabe.timesTwo(15), "timesTwo Test 2");
   assertTest(-4 , aufgabe.timesTwo(-2), "timesTwo Test 3");
   assertTest(false , aufgabe.isGreaterThanFive(5), "greaterThanFive Test 1");
   assertTest(true , aufgabe.isGreaterThanFive(6), "greaterThanFive Test 2");
   assertTest(true, aufgabe.isGreaterThanFive(17), "greaterThanFive Test 3");
   assertTest(3 , aufgabe.getHighestValue(1,2,3), "getHighestValue Test 1");
   
   assertTest(45 , aufgabe.getHighestValue(45,-45,2), "getHighestValue Test 1");
   assertTest(10 , aufgabe.getHighestValue(10,10,9), "getHighestValue Test 2");
   assertTest(23 , aufgabe.getHighestValue(-1000,23,1), "getHighestValue Test 3");
   assertTest(10000 , aufgabe.getHighestValue(33,20,10000), "getHighestValue Test 4");
   
   assertTest(0 , aufgabe.getSquare(0), "getSquare Test 1");
   assertTest(1 , aufgabe.getSquare(1), "getSquare Test 2");
   assertTest(49 , aufgabe.getSquare(7), "getSquare Test 3");
   assertTest(36 , aufgabe.getSquare(-6), "getSquare Test 4");
   
   assertTest(0 , aufgabe.getAbsoluteValue(0), "getAbsoluteValue Test 1");
   assertTest(3 , aufgabe.getAbsoluteValue(-3), "getAbsoluteValue Test 2");
   assertTest(3 , aufgabe.getAbsoluteValue(3), "getAbsoluteValue Test 3");
   assertTest(10 , aufgabe.getAbsoluteValue(-10), "getAbsoluteValue Test 4");
   
   assertTest(0 , aufgabe.getLastValue(27), "getLastValue Test 1");
   assertTest(27 , aufgabe.getLastValue(42), "getLastValue Test 2");
   assertTest(42 , aufgabe.getLastValue(0), "getLastValue Test 3");
}

void aufgabe2(){
  Aufgabe2 aufgabe = new Aufgabe2();
  assertTest("5", aufgabe.getLength("Hello"), "getLength Test 1");
  assertTest("0", aufgabe.getLength(""), "getLength Test 2");
  assertTest("10", aufgabe.getLength("Lalala Lol"), "getLength Test 3");
  assertTest("yes", aufgabe.isItFun("Fun"), "isItFun Test 1");
  assertTest("no", aufgabe.isItFun("this_is_not_a_string"), "isItFun Test 2");
  assertTest("FunFunFun", aufgabe.makeItThree("Funny"), "makeItThree Test 1");
  assertTest("aBcaBcaBc", aufgabe.makeItThree("aBcDeFgHiJkLmNoPqRsTuVwXyZ"), "makeItThree Test 2");
  assertTest("FunFunFun", aufgabe.makeItThree("Funny"), "makeItThree Test 3");
  assertTest(5, aufgabe.countChar("aqwertzuiopüasdfghjklöäyxacvbnmaa", 'a'), "countChar Test 1");
  assertTest(0, aufgabe.countChar("aqwertzuiopüasdfghjklöäyxacvbnmaa", '1'), "countChar Test 2");
  assertTest(3, aufgabe.countChar("infinity", 'i'), "countChar Test 3");
  assertTest(true, aufgabe.isPalindrome("noon"), "isPalindrome Test 1");
  assertTest(true, aufgabe.isPalindrome("aha"), "isPalindrome Test 2");
  assertTest(false, aufgabe.isPalindrome("not_a_palindrome"), "isPalindrome Test 3");
    
}

void aufgabe3(){
  Aufgabe3 aufgabe = new Aufgabe3();
  int[] empty = new int[]{0};
  int[] testArray = new int[]{42, 3, 7, 13, -1, 28, 0, 25};
  
  assertTest(21, aufgabe.sumArray(new int[]{3, 3, 3, 3, 3, 3, 3}), "sum Array Test 1");
  assertTest(0, aufgabe.sumArray(empty), "sum Array Test 2");
  assertTest(3, aufgabe.sumArray(new int[]{0, 1,-2, 3, -4, 5}), "sum Array Test 3");
  
  assertTest(new int[]{42, 7, 13, 28, 25}, aufgabe.isGreaterThanX(5, testArray), "greaterThanX Test 1");
  assertTest(new int[]{}, aufgabe.isGreaterThanX(89, new int[]{-5, -3, -4, 29, 89}), "greaterThanX Test 2");
  
  assertTest(new int[]{1, 1, 1, 1, 1, 1, 1, 1 , 1 , 1}, aufgabe.countChars("Hallo: Das sind die Ziffern rueckwaerts: 9, 8, 7, 6, 5, 4, 3, 2, 1, 0!"),"countChars Test 1");
  assertTest(new int[]{1, 0 , 0, 1, 0, 0, 0, 0, 0, 0}, aufgabe.countChars("H3ll0"), "countChars Test 2");
  assertTest(new int[]{3, 5, 6, 9, 5, 6, 4, 5, 6, 9}, aufgabe.countChars("3.141592653589793238462643383279502884197169399375105820974"), "countChars Test 3");
  
  assertTest(new boolean[]{true, false, false}, aufgabe.checkCondition(new int[]{1, 2, 3}, new int[]{3, 2, 1}), "checkCondition Test 1");
  assertTest(new boolean[]{true, false, false, true, false, true, true}, aufgabe.checkCondition(new int[]{2, 6, 7, 0, 15, -26, 18}, new int[]{3, 5, 7, 11, 13, 17, 23}), "checkCondition Test 2");
  assertTest(new int[]{4, 5, 6}, aufgabe.initArray(4, 1, 3), "initArray Test 1");
  assertTest(new int[]{17, 12, 7, 2, -3, -8, -13, -18}, aufgabe.initArray(17, -5, 8), "initArray Test 2");
}


void assertTest(int expected, int observed, String test){
  System.out.println(test + ": " + ((expected == observed)? "Test passed" : ("Test failed: expected: " + expected + "; observed: " + observed)));
  
}

void assertTest(boolean expected, boolean observed, String test){
  System.out.println(test + ": " + ((expected == observed)? "Test passed" : ("Test failed: expected: " + expected + "; observed: " + observed)));
  
}

void assertTest(String expected, String observed, String test){
  System.out.println(test + ": " + ((expected.equals(observed))? "Test passed" : ("Test failed: expected: \"" + expected + "\"; observed: \"" + observed + "\"")));
}

void assertTest(int[] expected, int[] observed, String test){
  if(observed == null ||expected.length != observed.length){
    System.out.println(test + ": " + (test + ": Test size different: " + "expected.length = " + expected.length+"; observed.length = " + observed.length));
    return;  
  }
  for(int i = 0; i < expected.length; i++){
    if(expected[i] != observed[i]){
      System.out.println(test + ": " + (test + ": Test failed at Index " + i + ": expected: " + expected[i] + "; observed: " + observed[i]));
      break;
    }
  }
  System.out.println(test + ": Test passed");
}

void assertTest(boolean[] expected, boolean[] observed, String test){
  if(observed == null || expected.length != observed.length){
    System.out.println(test + ": " + (test + ": Test size different: " + "expected.length = " + expected.length+"; observed.length = " + observed.length));
    return;//beende vorzeitig Ausfuehrung
  }
  for(int i = 0; i < expected.length; i++){
    if(expected[i] != observed[i]){
      System.out.println(test + ": " + (test + ": Test failed at Index " + i + ": expected: " + expected[i] + "; observed: " + observed[i]));
      break;
    }
  }
  System.out.println(test + ": Test passed");
}
