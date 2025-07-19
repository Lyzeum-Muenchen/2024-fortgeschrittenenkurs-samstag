
DisplayColor currentText = DisplayColor.BLUE;
DisplayColor currentBg = DisplayColor.BLUE;
int updateCounter = 120;
int[] playerScores = new int[2];
boolean isGameActive = false;
boolean[] isPlayerReady = new boolean[2];

void setup() {
  size(1000, 800);
  frameRate(120); 
}

void keyPressed() {
  // falls isGameActive
  // Farben für einen Spieler auswerten
  println(keyCode);
  // ansonsten Tastendruck als "Bereit" zählen
  if (isGameActive) {
    // Spieler 1
    if (isPlayer1() && matchColor()) {
      playerScores[0]++;
      isGameActive = false;
    }
    if(isPlayer1() && !matchColor()) {
      playerScores[0] -= 2;
      isGameActive = false;
    }
    // Spieler 2
     if (isPlayer2() && matchColor()) {
      playerScores[1]++;
      isGameActive = false;
    }
    if(isPlayer2() && !matchColor()) {
      playerScores[1] -= 2;
      isGameActive = false;
    }
  } else {
    // Runde ist inaktiv, Bereit setzen
    if (isPlayer1()) {
      isPlayerReady[0] = true;
    }
    if (isPlayer2()) {
      isPlayerReady[1] = true;
    }
    if (isPlayerReady[0] && isPlayerReady[1]) {
      currentText = DisplayColor.chooseRandomColor();
      currentBg = DisplayColor.chooseRandomColor();
      updateCounter = 120;
      isGameActive = true;
      isPlayerReady[0] = false;
      isPlayerReady[1] = false;
    }
  }
}

boolean matchColor() {
  return currentText == currentBg;
}

boolean isPlayer1() {
  return key == 'a' || key == 'A';
}

boolean isPlayer2() {
  return key == 'ä' || key == 'Ä';
}

void draw() {
  // Spielelogik
  if (isGameActive) {
    updateCounter--;
  }
  if (updateCounter == 0) {
    updateCounter = 120;
    currentText = DisplayColor.chooseRandomColor();
    currentBg = DisplayColor.chooseRandomColor();
  }
  background(0);
  // Obere Leiste
  fill(220);
  textSize(50);
  textAlign(LEFT, TOP);
  text(playerScores[0], 10, 10);
  textAlign(CENTER, TOP);
  text(currentText.colorName, width/2, 10);
  textAlign(RIGHT, TOP);
  text(playerScores[1], width - 10, 10);
  
  // Farbinhalt
  textAlign(CENTER, TOP);
  fill(currentBg.backgroundColor);
  rect(0, 60, width, height - 60);
  if (!isGameActive) {
    textSize(40);
    fill(currentBg.textColor);
    text("Press to continue...", width/2, 500);
    if(isPlayerReady[0]) {
      text("Player 1 is ready!", width/4, 600);
    }
    if(isPlayerReady[1]) {
      text("Player 2 is ready!",  (3 * width)/4, 600);
    }
  }
}
