package thanos;

import java.awt.*	;
import java.util.ArrayList;

public class GameLevel {
	public int worldHeight = 12;
	public int worldWidth = 8;
	public int brickSize = 80;
	
	private Brick[][] bricks;
	
	public GameLevel() {
		build();
	}
	
	public void build() {
		bricks = new Brick [worldHeight][worldWidth];
				
		for(int r = 0; r< bricks.length; r++) {
			for(int c = 0; c < bricks[0].length; c++) {
				bricks[r][c] = new Brick(r*brickSize, c * brickSize, this.brickSize, this.brickSize);
			}
		}
	}
	
	public void draw(Graphics g) {
		for(int r = 0; r< bricks.length; r++) {
			for(int c = 0; c < bricks[0].length; c++) {
				bricks[r][c].draw(g);
			}
		}
	}
}
