package thanos;

import java.awt.*;

public class Avengers extends GameObject{
	private int x, y;
	private int v;
	private Image img;

	public Avengers(int x, int y, int vel, Image i) {
		super(x, y, i);
		v = vel;
	}
	private void draw(Graphics g) {
		g.drawImage(img, x , y, 50, 50, null);
	}
	private int findX() {
		return 
		
	}

}
