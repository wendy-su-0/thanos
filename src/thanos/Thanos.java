package thanos;

import java.awt.Graphics;

public class Thanos extends Enemies{
	
	public Thanos(int h, int s) {
		super(h, s, "thanos.jpg");
	}

	@Override

	public void draw(Graphics g) {
		g.drawImage(image,currentX, currentY, 50,50, null);
	}

}
