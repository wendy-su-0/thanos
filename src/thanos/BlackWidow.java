package thanos;

import java.awt.Graphics;

public class BlackWidow extends Avengers {

	public BlackWidow(int x, int y) {
		super(x, y, 1, 100, "blackwidow.png");
		// TODO Auto-generated constructor stub
	}

	@Override

	public void draw(Graphics g) {
		g.drawImage(img,locX, locY, 95,95, null);
	}

}
