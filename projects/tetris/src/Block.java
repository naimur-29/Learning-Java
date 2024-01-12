import java.awt.*;

public class Block {
	Tile[] tiles;
	int size, tileSize, model;
	int xt, xb, yt, yb;
	int genX, genY;

	Block(int genX, int genY, int tileSize, int model) {
		this.tileSize = tileSize;
		this.model = model;
		this.genX = genX;
		this.genY = genY;
		
		if (this.model == 0) this.model0(genX, genY);
		else if (this.model == 1) this.model1(genX, genY);
		else if (this.model == 2) this.model2(genX, genY);
		else if (this.model == 3) this.model3(genX, genY);
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < this.size; i++) {
			this.tiles[i].draw(g);
		}	
	}
	
	public void update(int genX, int genY) {
		this.genX = genX;
		this.genY = genY;
		// reset the models:
		if (this.model == 0) this.model0(genX, genY);
		else if (this.model == 1) this.model1(genX, genY);
		else if (this.model == 2) this.model2(genX, genY);
		else if (this.model == 3) this.model3(genX, genY);
	}
	
	public void model0(int genX, int genY) {
		this.size = 3;
		this.xt = genX;
		this.yt = genY;
		this.xb = genX + 3;
		this.yb = genY + 1;
		this.tiles = new Tile[this.size];
		this.tiles[0] = new Tile(genX, genY, this.tileSize);
		this.tiles[1] = new Tile(genX + 1, genY, this.tileSize);
		this.tiles[2] = new Tile(genX + 2, genY, this.tileSize);	
	}
	
	public void model1(int genX, int genY) {
		this.size = 4;
		this.xt = genX;
		this.yt = genY - 1;
		this.xb = genX + 2;
		this.yb = genY + 1;
		this.tiles = new Tile[this.size];
		this.tiles[0] = new Tile(genX, genY, this.tileSize);
		this.tiles[1] = new Tile(genX + 1, genY, this.tileSize);	
		this.tiles[2] = new Tile(genX, genY - 1, this.tileSize);
		this.tiles[3] = new Tile(genX + 1, genY - 1, this.tileSize);	
	}
	
	public void model2(int genX, int genY) {
		this.size = 5;
		this.xt = genX;
		this.yt = genY - 2;
		this.xb = genX + 3;
		this.yb = genY + 1;
		this.tiles = new Tile[this.size];
		this.tiles[0] = new Tile(genX, genY, this.tileSize);
		this.tiles[1] = new Tile(genX + 1, genY, this.tileSize);	
		this.tiles[2] = new Tile(genX + 2, genY, this.tileSize);
		this.tiles[3] = new Tile(genX + 1, genY - 1, this.tileSize);	
		this.tiles[4] = new Tile(genX + 1, genY - 2, this.tileSize);	
	}
	
	public void model3(int genX, int genY) {
		this.size = 4;
		this.xt = genX;
		this.yt = genY - 2;
		this.xb = genX + 2;
		this.yb = genY + 1;
		this.tiles = new Tile[this.size];
		this.tiles[0] = new Tile(genX, genY, this.tileSize);
		this.tiles[1] = new Tile(genX + 1, genY, this.tileSize);	
		this.tiles[2] = new Tile(genX, genY - 1, this.tileSize);
		this.tiles[3] = new Tile(genX, genY - 2, this.tileSize);	
	}
}
