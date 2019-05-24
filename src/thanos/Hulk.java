package thanos;

import java.awt.Graphics;

public class Hulk extends Avengers {

	public Hulk(int x, int y) {
		super(x, y, 2, 100, "hulk.png");
		// TODO Auto-generated constructor stub
	}
	
	@Override

	public void draw(Graphics g) {
		g.drawImage(this.img,locX, locY, 110,110, null);
	}


}
