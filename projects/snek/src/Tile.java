import java.awt.*;

public class Tile {
    int tileSize, x, y;

    Tile(int x, int y, int tileSize) {
        this.tileSize = tileSize;
        this.x = x;
        this.y = y;
    }

    Tile(Tile t) {
        this.tileSize = t.tileSize;
        this.x = t.x;
        this.y = t.y;
    }

    public Tile copy(Tile t) {
        return new Tile(t);
    }

    public void draw(Graphics g) {
        g.fillRect(this.x * this.tileSize, this.y * this.tileSize, this.tileSize, this.tileSize);
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(Tile t) {
        this.x = t.x;
        this.y = t.y;
    }

    public boolean collide(Tile other) {
        return (this.x == other.x && this.y == other.y);
    }

    public void addVelocity(int velX, int velY) {
        this.x += velX;
        this.y += velY;
    }
}
