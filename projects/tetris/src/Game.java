import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Game extends JPanel implements ActionListener, KeyListener {
  int width, height, tileSize;
  int frameCount = 0, totalStackedBlocks = 0;
  Block block;
  Block[] stackedBlocks;
  Random rand;
  Timer gameLoop;
  
  Game(int width, int height, int tileSize) {
    this.width = width;
    this.height = height;
    this.tileSize = tileSize;
    
    this.rand = new Random();
    this.generateBlock();
    this.stackedBlocks = new Block[100];
       
    this.setPreferredSize(new Dimension(width, height));
    this.setBackground(Color.black);
    this.setFocusable(true);
    this.addKeyListener(this);
    
    gameLoop = new Timer(10, this);
    gameLoop.start();
  }
  
  public void draw(Graphics g) {
    g.setColor(Color.green);
    this.block.draw(g);
    for (int i = 0; i < this.totalStackedBlocks; i++) {
      this.stackedBlocks[i].draw(g);
    }
  }
  
  public void updateDefault() {
    this.frameCount++;
    int yMax = this.height/this.tileSize;
    if (this.frameCount % 60 == 0) {
      System.out.println("updating...");
      System.out.println(this.block.yb);
      
      if (this.block.yb < yMax) {
        this.block.update(this.block.genX, this.block.genY + 1);
      } else {
        this.stackedBlocks[this.totalStackedBlocks++] = this.block;
        this.generateBlock();
      }
    }
  }
  
  public void update(int x, int y) {
    this.block.update(this.block.genX + x, this.block.genY + y);
  }
        
  public void generateBlock() {
    int genX = this.width/this.tileSize/2 - 1;
    int model = this.rand.nextInt(4);
    this.block = new Block(genX, 0, this.tileSize, model);
  }
   
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.draw(g);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    this.updateDefault();
    repaint();
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == 37) {
      // move left by 1:
      this.update(-1, 0);
    } else if (key == 39) {
      // move right by 1: 
      this.update(1, 0);
    } else if (key == 40) {
      // drop down at once:
      this.update(0, 5);
    }
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
  }
  
  @Override
  public void keyTyped(KeyEvent e) {
  }  
}
