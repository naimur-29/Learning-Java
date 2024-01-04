import java.awt.*;

public class Bird {
    int x, y, width, height;

    Bird(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
}
