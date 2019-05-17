package thanos;

import java.awt.*	;
import java.io.File;
import java.util.ArrayList;

public class GameLevel {
	public int worldHeight = 12;
	public int worldWidth = 8;
	public int brickSize = 80;
	public File worldselector;
	public static Point st, junc1, junc2, junc3, end;
	
	private Brick[] brick;

	public GameLevel() {
		build();
	}

	public void build() {
		st = new Point(298,1080);
		junc1 = new Point(1250,255);
		junc2 = new Point(1150,780);
		junc3 = new Point(400,490);
		end = new Point(1745,490);
	}
	
	public void draw(Graphics g) {
		g.drawLine(298, 1080, 1250,255 );
		g.drawLine(1250, 255, 1150, 780);
		g.drawLine(1150, 780, 400, 490);
		g.drawLine(400, 490, 1745, 490);
	}
}