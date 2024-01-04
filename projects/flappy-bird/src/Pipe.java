import java.awt.*;

public class Pipe {
    public int x, width, height, gap, boardHeight;

    Pipe(int x, int width, int height, int gap, int boardHeight) {
        this.x = x;
        this.width = width;
        this.height = height;
        this.gap = gap;
        this.boardHeight = boardHeight;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        // top:
        g.fillRect(this.x - this.width, 0, this.width, this.height);
        // bottom:
        g.fillRect(this.x - this.width, this.height + this.gap, this.width, this.boardHeight);
    }

    public boolean collide(int x, int y1, int y2) {
        boolean res = false;
        if (x >= this.x - this.width && x <= this.x && (y1 <= this.height || y2 >= this.height + this.gap)) {
            res = true;
        }
        return res;
    }
}
