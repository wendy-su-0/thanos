package thanos;

import java.awt.Graphics;

public class Thor extends Avengers {

	public Thor(int x, int y) {
		super(x, y, 3, 200, "thor.png");
		// TODO Auto-generated constructor stub
	}
@Override

public void draw(Graphics g) {
	g.drawImage(img,locX, locY, 104,104, null);
}
	

}
