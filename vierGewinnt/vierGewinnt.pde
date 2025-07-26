import java.util.*;


CellState[][] game = new CellState[7][6]; // [x][y]

boolean redsTurn = true;

void setup() {
  size(700, 600);
  ellipseMode(CORNER);
  for (CellState[] column : game) {
    for (int i = 0; i < column.length; i++) {
      column[i] = CellState.EMPTY;
    }
  }
}

void draw() {
  background(255);
  drawGame();
}


void drawGame() {
  for (int x = 0; x < game.length; x++) {
    float xCoord = width / game.length * x;
    for (int y = 0; y < game[0].length; y++) {
      float yCoord = height / game[0].length * (game[0].length - y - 1);

      if (game[x][y] == CellState.YELLOW) {
        fill(255, 255, 0);
      } else if (game[x][y] == CellState.RED) {
        fill(255, 0, 0);
      } else {
        noFill();
      }
      ellipse(xCoord, yCoord, width / game.length * 0.8, height / game[0].length * 0.8);
    }
  }
}


CellState checkWinner() {
  // check columns
  for (var column : game) {
    var winner = checkList(Arrays.asList(column));
    if (winner != CellState.EMPTY) {
      return winner;
    }
  }

  // check rows
  for (int y = 0; y < game[0].length; y++) {
    List<CellState> cells = new ArrayList<>();
    for (int x = 0; x < game.length; x++) {
      cells.add(game[x][y]);
    }
    var winner = checkList(cells);
    if (winner != CellState.EMPTY) {
      return winner;
    }
  }

  // check diagonals - from the top down
  for (int startX = 0; startX < game.length; startX++) {
    List<CellState> cells = new ArrayList<>();
    int x = startX;
    int y = 0;
    while (x < game.length && y < game[0].length) {
      cells.add(game[x][y]);
      x++;
      y++;
    }
    var winner = checkList(cells);
    if (winner != CellState.EMPTY) {
      return winner;
    }
    
    cells.clear();
    x = startX;
    y = 0;
    while (x > 0 && y < game[0].length) {
      cells.add(game[x][y]);
      x--;
      y++;
    }
    winner = checkList(cells);
    if (checkList(cells) != CellState.EMPTY) {
      return winner;
    }
  }
  
  // check diagonals - from the bottom up
  for (int startX = 0; startX < game.length; startX++) {
    List<CellState> cells = new ArrayList<>();
    int x = 0;
    int y = 0;
    while (x < game.length && y >= 0) {
      cells.add(game[x][y]);
      x++;
      y--;
    }
    var winner = checkList(cells);
    if (winner != CellState.EMPTY) {
      return winner;
    }
    
    cells.clear();
    x = startX;
    y = 0;
    while (x > 0 && y >= 0) {
      cells.add(game[x][y]);
      x--;
      y--;
    }
    winner = checkList(cells);
    if (checkList(cells) != CellState.EMPTY) {
      return winner;
    }
  }

  return CellState.EMPTY;
}

CellState checkList(List<CellState> cells) {
  CellState personCounting = CellState.EMPTY;
  int counter = 0;

  for (int i = 0; i < cells.size(); i++) {
    CellState c = cells.get(i);
    if (c == CellState.RED) {
      if (personCounting != CellState.RED) {
        counter = 0; // reset the counter
      }
      personCounting = CellState.RED;
      counter++;
    } else if (c == CellState.YELLOW) {
      if (personCounting != CellState.YELLOW) {
        counter = 0; // reset the counter
      }
      personCounting = CellState.YELLOW;
      counter++;
    }

    if (counter == 4) {
      return personCounting;
    }
  }

  return CellState.EMPTY;
}


void mousePressed() {
  int columnIdxClicked = (int)(mouseX / (float) width * game.length);
  var column = game[columnIdxClicked];

  for (int i = 0; i < column.length; i++) {
    if (column[i] == CellState.EMPTY) {
      column[i] = redsTurn? CellState.RED: CellState.YELLOW;
      redsTurn = !redsTurn;
      println(checkWinner());
      return;
    }
  }
}
