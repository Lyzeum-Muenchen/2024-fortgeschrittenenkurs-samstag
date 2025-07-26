final int PLAYER_1 = 1;
final int PLAYER_2 = 2;
final int GAME_WIDTH = 7;
final int GAME_HEIGHT = 6;
final int TILE_LENGTH = 100;

int[][] tiles;
int currentPlayer = PLAYER_1;


void setup() {
  size(701, 601); // Spielgroesse
  
  tiles = new int[GAME_WIDTH][GAME_HEIGHT]; // Breite, Hoehe
  tiles[6][5] = 2;
}

// Finde fuer eine Spalte das naechste freie Kaestchen mit dem groessten Zeilenindex
// Fehler -1: Kein Chip kann eingeworfen werden
int getFreeTile(int column) {
  if (column >= GAME_WIDTH) {
    return -1;
  }
  int result = -1;
  for (int j = 0; j < GAME_HEIGHT; j++){
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

void mousePressed() {
  int columnPreview = pixelToTileIndex(mouseX);
  int rowPreview = getFreeTile(columnPreview);
  if (rowPreview != -1) {
    tiles[columnPreview][rowPreview] = currentPlayer;
    currentPlayer = 3 - currentPlayer; // Wechsel von Spieler 1 -> 2 oder 2 -> 1
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
  if (rowPreview != -1) {
    // Zeichnen, falls ein gueltiger Index ermittelt wurde
    if (currentPlayer == PLAYER_1) {
      fill(255, 0, 0, 127);
    } else {
      fill(255, 255, 0, 127);
    }
    rect(columnPreview * TILE_LENGTH, rowPreview * TILE_LENGTH, TILE_LENGTH, TILE_LENGTH);
  }
}
