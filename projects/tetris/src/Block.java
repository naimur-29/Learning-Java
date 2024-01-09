import java.awt.*;

public class Block {
	Tile[] tiles;
	int size, tileSize;
	int x1, x2, y1, y2;

	Block(int size, int genX, int genY, int tileSize) {
		this.size = size;
		
		this.tiles = new Tile[size];
		int ind = 0; 
		for (int i = 0; i < size; i++) {
			this.tiles[i] = new Tile(genX + ind, genY, tileSize);
			ind += 2;
		}
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < size; i++) {
			this.tiles[i].draw(g);
		}	
	}
}
