package thanos;

import java.awt.Graphics;

public class Thanos extends Enemies{
	
	public Thanos(int h, int s) {
		super(h, s, "thanos.png");
	}

	@Override

	public void draw(Graphics g) {
		g.drawImage(image,currentX, currentY, 100,100, null);
	}

}
