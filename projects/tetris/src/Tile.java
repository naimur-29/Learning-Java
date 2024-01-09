import java.awt.*;

public class Tile {
	int size, x, y;
	
	Tile(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(this.x * this.size, this.y * this.size, this.size, this.size);
	}
}
