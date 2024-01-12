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
		g.fillRect(this.x * this.size + 2, this.y * this.size + 2, this.size - 2, this.size - 2);
	}
}
