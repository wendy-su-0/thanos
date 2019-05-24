package thanos;

import java.awt.Graphics;

public class Leviathan extends Enemies{

	public Leviathan(int h, int s) {
		super(h, s, "leviathan.jpg");
	}

	@Override

	public void draw(Graphics g) {
		//g.drawImage(image,currentX, currentY, size,size, null);
		g.drawImage(image, currentX, currentY, size,size,null);
	}

	
	
}
