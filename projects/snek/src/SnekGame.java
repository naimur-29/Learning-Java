import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnekGame extends JPanel implements ActionListener, KeyListener {
    // variables:
    int boardWidth, boardHeight;
    int tileSize, cols, rows;
    Tile snekHead, apple;
    Timer gameLoop;
    int velX = 1, velY = 0;
    ArrayList<Tile> snekTail;
    int index = 0;
    int maxSpeed = 170;
    int snekSpeed = 100;

    SnekGame(int boardWidth, int boardHeight, int tileSize) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.tileSize = tileSize;
        this.cols = boardWidth / tileSize;
        this.rows = boardHeight / tileSize;
        this.snekTail = new ArrayList<Tile>();

        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.getHSBColor(0, 100, 0));
        setFocusable(true);
        addKeyListener(this);

        snekHead = new Tile(5, 5, tileSize);
        this.snekTail.add(index++, new Tile(3, 5, tileSize));
        this.snekTail.add(index++, new Tile(4, 5, tileSize));
        apple = new Tile(0, 0, tileSize);
        this.spawnApple();

        gameLoop = new Timer(200 - this.snekSpeed, this);
        gameLoop.start();
    }

    // update game:
    public void updateGame() {
        // update tail locations:
        for (int i = 0; i < index - 1; i++) {
            Tile currentTail = this.snekTail.get(i);
            Tile nextTail = this.snekTail.get(i + 1);

            currentTail.setLocation(nextTail);

            // check tail collisions:
            if (index > 2 && currentTail.collide(snekHead)) {
                Tile prevPrevTail = this.snekTail.get(index - 2);
                Tile prevTail = this.snekTail.get(index - 1);
                index = 0;

                this.snekTail = new ArrayList<Tile>();
                this.snekTail.add(index++, prevPrevTail);
                this.snekTail.add(index++, prevTail);
                this.snekSpeed = 100;
            }
        }
        this.snekTail.get(index - 1).setLocation(snekHead);

        // update snekHead locations:
        snekHead.addVelocity(velX, velY);

        // spawn new apple if snek ate the apple:
        if (snekHead.collide(apple)) {
            if (this.snekSpeed < this.maxSpeed)
                this.snekSpeed += 1;
            this.spawnApple();
            this.snekTail.add(index++, snekHead.copy(snekHead));
            snekHead.addVelocity(velX, velY);
        }

        // wrap borders:
        if (snekHead.x > this.cols - 1) {
            snekHead.x = 0;
        } else if (snekHead.x < 0) {
            snekHead.x = this.cols;
        } else if (snekHead.y > this.rows - 1) {
            snekHead.y = 0;
        } else if (snekHead.y < 0) {
            snekHead.y = this.rows;
        }
    }

    // draw game:
    public void drawGame(Graphics g) {
        g.setColor(Color.red);
        apple.draw(g);

        for (int i = 0; i < index; i++) {
            g.setColor(Color.green);
            this.snekTail.get(i).draw(g);
        }
        snekHead.draw(g);
    }

    public void spawnApple() {
        Random rand = new Random();
        int x, y;
        Tile nextApple;

        do {
            x = rand.nextInt(this.cols);
            y = rand.nextInt(this.rows);
            nextApple = new Tile(x, y, this.tileSize);
        } while (apple.collide(nextApple));

        apple.setLocation(rand.nextInt(this.cols), rand.nextInt(this.rows));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.drawGame(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameLoop.setDelay(200 - this.snekSpeed);
        this.updateGame();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == 37 && this.velX != 1) {
            this.velX = -1;
            this.velY = 0;
        } else if (keyCode == 38 && this.velY != 1) {
            this.velX = 0;
            this.velY = -1;
        } else if (keyCode == 39 && this.velX != -1) {
            this.velX = 1;
            this.velY = 0;
        } else if (keyCode == 40 && this.velY != -1) {
            this.velX = 0;
            this.velY = 1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
