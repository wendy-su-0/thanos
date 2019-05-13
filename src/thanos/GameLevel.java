package thanos;

import java.util.ArrayList;

public class GameLevel {
	public int worldHeight = 30;
	public int worldWidth = 30;
	public int brickSize = 64;
	
	private Brick[][] bricks;
	
	public void build() {
		bricks = new Brick [worldHeight][worldWidth];
				
		for(int r = 0; r< this.worldHeight; r++) {
			for(int c = 0; c < this.worldWidth; c++) {
				bricks[r][c] = new Brick(r*worldHeight, c * this.worldWidth, this.brickSize, this.brickSize, r, c);
			}
		}
	}
}
