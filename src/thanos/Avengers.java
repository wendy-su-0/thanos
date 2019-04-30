
import kareltherobot.*;
import kareltherobot.Robot;
import thanos.GameObject;

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
	private int findX(Robot r) {
		return r.avenue();
	}
	private int findY(Robot r) {
		return r.street();
	}
	private void setLoc(int X, int Y) {
		x = X;
		y = Y;
	}

}
