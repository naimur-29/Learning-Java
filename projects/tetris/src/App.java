import javax.swing.*;
import java.awt.*;

public class App {
  public static void main(String[] args) throws Exception {
    int boardWidth = 400;
    int boardHeight = 600;
    int tileSize = 20;
    
    JFrame frame = new JFrame("Bunch Of Blocks Faling From The Sky!");
    frame.setVisible(true);
    frame.setSize(boardWidth, boardHeight);
    frame.setMinimumSize(new Dimension(boardWidth, boardHeight));
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Game game = new Game(boardWidth, boardHeight, tileSize);
    frame.add(game);
    frame.pack();
  }
}
