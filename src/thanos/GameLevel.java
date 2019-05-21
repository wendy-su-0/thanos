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
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	private Brick[] brick;

	public GameLevel() {
		build();
	}

	public void build() {
		st = new Point((int) (0.16*ThanosGameRunner.WIDTH), ThanosGameRunner.HEIGHT);
		junc1 = new Point((int) (.639*ThanosGameRunner.WIDTH), (int) (.278*ThanosGameRunner.HEIGHT));
		junc2 = new Point((int) (.597*ThanosGameRunner.WIDTH), (int) (.722*ThanosGameRunner.HEIGHT));
		junc3 = new Point((int) (.231*ThanosGameRunner.WIDTH), (int) (.472*ThanosGameRunner.HEIGHT));
		end = new Point((int) (.907*ThanosGameRunner.WIDTH), (int) (.472*ThanosGameRunner.HEIGHT));
	}
	
	public void draw(Graphics g) {
		g.drawLine((int)(st.getX()),(int) (st.getY()), (int) (junc1.getX()),(int) (junc1.getY()));
	}
}