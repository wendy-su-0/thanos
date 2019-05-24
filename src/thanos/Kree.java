package thanos;

import java.awt.Graphics;

public class Kree extends Enemies{
	public Kree(int h, int s) {
		super(h, s, "kree.jpg");
	}

	@Override

	public void draw(Graphics g) {
		//g.drawImage(image,currentX, currentY, size,size, null);
		g.drawImage(image, currentX, currentY, size,size,null);
	}

}
