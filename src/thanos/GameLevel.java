package thanos;

import java.awt.*	;
import java.io.File;
import java.util.ArrayList;

public class GameLevel {
	public int worldHeight = 12;
	public int worldWidth = 8;
	public int brickSize = 80;
	public File worldselector;
	Point st, junc1, junc2, junc3, end;
	
	private Brick[] brick;

	public GameLevel() {
		build();
	}

	public void build() {
		st = new Point(564,2959);
		junc1 = new Point(2336,719);
		junc2 = new Point(2149,2211);
		junc3 = new Point(737,1399);
		end = new Point(3261,1399);
		
	}
	
	public void draw(Graphics g) {
	
	}
}