import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game extends JPanel implements ActionListener, KeyListener {
    int boardHeight, boardWidth;
    int pipeHorizontalGap = 300, pipeVerticalGap = 200;
    Timer gameLoop;
    int frameCount = 0;
    Pipe[] pipes;
    Bird bird;
    int pipeVel = 3;
    int birdVel = 0;
    int tapVel = 15;
    int initBirdGravity = 3, birdGravity = 3;

    Game(int width, int height) {
        this.boardWidth = width;
        this.boardHeight = height;
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(this);

        this.spawnPipes();
        this.spawnBird();

        gameLoop = new Timer(10, this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.drawGame(g);
    }

    public void drawGame(Graphics g) {
        // draw the bird:
        this.bird.draw(g);

        // draw the pipes:
        for (int i = 0; i < this.pipes.length; i++) {
            this.pipes[i].draw(g);
        }
    }

    public void updateGame() {
        this.frameCount++;
        for (int i = 0; i < this.pipes.length; i++) {
            if (this.pipes[i].collide(this.bird.x + this.bird.width, this.bird.y, this.bird.y + this.bird.height)) {
                this.reset();
                gameLoop.stop();
            }

            if (this.pipes[i].x <= 0) {
                this.spawnPipes(i);
            }
            this.pipes[i].x -= this.pipeVel;
        }

        if (this.bird.y + this.bird.height >= this.boardHeight || this.bird.y <= 0) {
            this.reset();
            gameLoop.stop();
        }

        if (this.frameCount % 30 == 0) {
            this.birdGravity++;
        }

        if (this.birdVel > 0) {
            this.bird.y -= this.birdVel;
            this.birdVel--;
        }
        this.bird.y += this.birdGravity;
    }

    public void spawnPipes() {
        Random rand = new Random();
        int totalPipes = (this.boardWidth / this.pipeHorizontalGap) + 1;
        this.pipes = new Pipe[totalPipes];

        for (int i = 0; i < this.pipes.length; i++) {
            int pipeHeight = rand.nextInt(this.boardHeight - this.pipeVerticalGap);
            this.pipes[i] = new Pipe(this.boardWidth + (this.pipeHorizontalGap * i), 100, pipeHeight,
                    this.pipeVerticalGap,
                    this.boardHeight);
        }
    }

    public void spawnPipes(int index) {
        Random rand = new Random();
        int pipeHeight = rand.nextInt(this.boardHeight - this.pipeVerticalGap);
        this.pipes[index] = new Pipe(this.boardWidth + this.pipeHorizontalGap, 100, pipeHeight, this.pipeVerticalGap,
                this.boardHeight);
    }

    public void spawnBird() {
        bird = new Bird(150, this.boardHeight / 2, 30, 30);
    }

    public void reset() {
        this.spawnPipes();
        this.spawnBird();
        this.frameCount = 0;
        this.birdVel = 0;
        this.birdGravity = this.initBirdGravity;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.updateGame();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gameLoop.start();

        int key = e.getKeyCode();
        if (key == 32) {
            this.birdVel = this.tapVel;
            this.birdGravity = this.initBirdGravity;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
