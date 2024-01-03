import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello sneks!");
        int boardWidth = 600;
        int boardHeight = 600;
        int tileSize = 20;

        JFrame frame = new JFrame("Snek Aren't Edible!");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnekGame snekGame = new SnekGame(boardWidth, boardHeight, tileSize);
        frame.add(snekGame);
        frame.pack(); // to fix the problem that title bar takes the actual height!
        snekGame.requestFocus();
    }
}