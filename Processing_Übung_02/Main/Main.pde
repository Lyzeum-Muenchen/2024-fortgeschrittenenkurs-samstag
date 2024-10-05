/**

  Aufgaben im Tab/Klasse Aufgabe

**/


//Tests, NICHT VERAENDERN!!!
void setup(){
  size(200, 200);
   //aufgabe1();
   aufgabe2();
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


void assertTest(int expected, int observed, String test){
  System.out.println(test + ": " + ((expected == observed)? "Test passed" : ("Test failed: expected: " + expected + "; observed: " + observed)));
  
}

void assertTest(boolean expected, boolean observed, String test){
  System.out.println(test + ": " + ((expected == observed)? "Test passed" : ("Test failed: expected: " + expected + "; observed: " + observed)));
  
}

void assertTest(String expected, String observed, String test){
  System.out.println(test + ": " + ((expected.equals(observed))? "Test passed" : ("Test failed: expected: \"" + expected + "\"; observed: \"" + observed + "\"")));
}