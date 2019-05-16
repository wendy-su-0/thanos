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
	private double xscale = 3600/640, yscale = 3000/480;
	private Brick[] brick;

	public GameLevel() {
		build();
	}

	public void build() {
		st = new Point((int) (2959/xscale) ,(int) (564/yscale));
		junc1 = new Point((int) (2336/xscale),(int) (719/yscale));
		junc2 = new Point((int) (2149/xscale),(int) (2211/yscale));
		junc3 = new Point((int) (737/xscale),(int) (1399/yscale));
		end = new Point((int) (3261/xscale),(int) (1399/yscale));
	}
	
	public void draw(Graphics g) {
		g.drawLine(st.x, st.y, junc1.x, junc1.y);
	}
}