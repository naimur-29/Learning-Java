import java.awt.*;
import javax.swing.*;

public class Game extends JPanel {
  int width, height, tileSize;
  Block block;
  
  Game(int width, int hegiht, int tileSize) {
    this.width = width;
    this.height = height;
    this.tileSize = tileSize;
    
    this.block = new Block(20, 0, 0, this.tileSize);
       
    this.setPreferredSize(new Dimension(width, height));
    this.setBackground(Color.black);
  }
  
  public void draw(Graphics g) {
    g.setColor(Color.green);
    this.block.draw(g);
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.draw(g);
  }
}
