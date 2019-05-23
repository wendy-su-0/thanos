package thanos;

import java.awt.Graphics;

public class Thanos extends Enemies{
	
	public Thanos(int x, int y) {
		super(x, y, "thanos.jpg");
	}

	@Override

	public void draw(Graphics g) {
		g.drawImage(image,locX, locY, 50,50, null);
	}

}
