
public enum DisplayColor {
  ORANGE("Orange", #F79900, #FFFFFF), 
  GREEN("Grün", #00FF00, #FFFFFF),
  BLUE("Blau", #0000FF, #FFFFFF);
  String colorName;
  color backgroundColor;
  color textColor;
  
  private DisplayColor(String name, color bg, color tc) {
    colorName = name;
    backgroundColor = bg;
    textColor = tc;
  }
  
  public static DisplayColor chooseRandomColor() {
    int randomColorIndex = (int)(Math.random() * DisplayColor.values().length);
    return DisplayColor.values()[randomColorIndex];
  }
}
