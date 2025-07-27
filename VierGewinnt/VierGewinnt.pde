final int PLAYER_1 = 1;
final int PLAYER_2 = 2;
final int GAME_WIDTH = 7;
final int GAME_HEIGHT = 6;
final int TILE_LENGTH = 100;

int[][] tiles;
int currentPlayer = PLAYER_1;
boolean isGameActive = true;

void setup() {
  size(701, 601); // Spielgroesse

  tiles = new int[GAME_WIDTH][GAME_HEIGHT]; // Breite, Hoehe
}

// Finde fuer eine Spalte das naechste freie Kaestchen mit dem groessten Zeilenindex
// Fehler -1: Kein Chip kann eingeworfen werden
int getFreeTile(int column) {
  if (column >= GAME_WIDTH) {
    return -1;
  }
  int result = -1;
  for (int j = 0; j < GAME_HEIGHT; j++) {
    if (tiles[column][j] == 0) {
      result++;
    } else {
      return result;
    }
  }
  return result;
}

int pixelToTileIndex(int pixel) {
  return pixel / TILE_LENGTH;
}

void keyPressed() {
  if (!isGameActive) {
    isGameActive = true;
    tiles = new int[GAME_WIDTH][GAME_HEIGHT];
  }
}

void mousePressed() {
  int columnPreview = pixelToTileIndex(mouseX);
  int rowPreview = getFreeTile(columnPreview);
  if (rowPreview != -1 && isGameActive) {
    tiles[columnPreview][rowPreview] = currentPlayer;
    currentPlayer = 3 - currentPlayer; // Wechsel von Spieler 1 -> 2 oder 2 -> 1
    int winner = checkWinner();
    if (winner != 0) {
      if (winner == 1) {
        println("Player 1 (RED) has won!");
      } else if (winner == 2) {
        println("Player 1 (YELLOW) has won!");
      }
      println("Press any key to Restart...");
      isGameActive = false;
    } else if (!isTilePlacable()) {
      isGameActive = false;
      println("Game ended with a draw!");
      println("Press any key to Restart...");
    }
  }
}

void draw() {
  background(230); // Weiss
  for (int i = 0; i < GAME_WIDTH; i++) {
    for (int j = 0; j < GAME_HEIGHT; j++) {
      stroke(0);
      noFill();
      rect(i * TILE_LENGTH, j * TILE_LENGTH, TILE_LENGTH, TILE_LENGTH);
      // Chips zeichnen
      if (tiles[i][j] == PLAYER_1) {
        fill(255, 0, 0); // roter Chip
        noStroke();
        // Mittelpunkt vom Kaestchen, Durchmesser entspricht 80% der Kaestchenlaenge
        circle((i + 0.5) * TILE_LENGTH, (j + 0.5) * TILE_LENGTH, TILE_LENGTH * 0.8);
      }
      if (tiles[i][j] == PLAYER_2) {
        fill(255, 255, 0); // gelber Chip
        noStroke();
        circle((i + 0.5) * TILE_LENGTH, (j + 0.5) * TILE_LENGTH, TILE_LENGTH * 0.8);
      }
    }
  }
  // Vorschau Chip Platzierung
  int columnPreview = pixelToTileIndex(mouseX);
  int rowPreview = getFreeTile(columnPreview);
  if (rowPreview != -1 && isGameActive) {
    // Zeichnen, falls ein gueltiger Index ermittelt wurde
    if (currentPlayer == PLAYER_1) {
      fill(255, 0, 0, 127);
    } else {
      fill(255, 255, 0, 127);
    }
    rect(columnPreview * TILE_LENGTH, rowPreview * TILE_LENGTH, TILE_LENGTH, TILE_LENGTH);
  }
}

int checkWinner() {
  // vertical
  for (int i = 0; i < GAME_WIDTH; i++) {
    for (int j = 0; j < GAME_HEIGHT - 3; j++) {
      int winnerVertical = checkFourTilesWinner(i, j, 0, 1);
      if (winnerVertical != 0) {
        return winnerVertical;
      }
    }
  }
  // horizontal
  for (int i = 0; i < GAME_WIDTH - 3; i++) {
    for (int j = 0; j < GAME_HEIGHT; j++) {
      int winnerHorizontal = checkFourTilesWinner(i, j, 1, 0);
      if (winnerHorizontal != 0) {
        return winnerHorizontal;
      }
    }
  }
  // diagonal
  for (int i = 0; i < GAME_WIDTH; i++) {
    for (int j = 0; j < GAME_HEIGHT; j++) {
      int winnerDiagonale1 = checkFourTilesWinner(i, j, 1, 1);
      if (winnerDiagonale1 != 0) {
        return winnerDiagonale1;
      }
      int winnerDiagonale2 = checkFourTilesWinner(i, j, 1, -1);
      if (winnerDiagonale2 != 0) {
        return winnerDiagonale2;
      }
    }
  }
  return 0;
}

boolean isTilePlacable() {
  for (int i = 0; i < GAME_WIDTH; i++) {
    if (tiles[i][0] == 0) {
      return true;
    }
  }
  return false;
}

boolean isInBounds(int x, int y) {
  return x >= 0 && x < GAME_WIDTH && y >= 0 && y < GAME_HEIGHT;
}


int checkFourTilesWinner(int x, int y, int diffX, int diffY) {
  int firstTile = tiles[x][y];
  for (int i = 1; i <= 3; i++) {
    int indexX = x + i * diffX;
    int indexY = y + i * diffY;
    if (isInBounds(indexX, indexY)) {
      if (tiles[indexX][indexY] != firstTile) {
        return 0;
      }
    } else {
      return 0;
    }
  }
  return firstTile;
}
