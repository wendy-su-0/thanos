package thanos;
import kareltherobot.*;
import java.awt.*;
import java.lang.*;
import thanos.GameObject;
import thanos.Projectile;
import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Avengers extends GameObject{
	private int x, y;
	private int v;
	private int vX, vY;
	private Image img;
	public Projectile p;
	
	private Image getImage(String imgName) {
		try {
			img = ImageIO.read(this.getClass().getResource(imgName));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	public Avengers(int x, int y, int vel, String str) {
		super(x, y, img);
		v = vel;
		img = this.getImage(str);
		
	}
	public void draw(Graphics g) {
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
	public void setVars(Robot r) {
		int xDis = this.findX(r)-this.x;
		int yDis = this.findX(r)-this.y;
		int Dis = Math.abs(xDis*xDis + yDis*yDis);
		vX = v*xDis/Dis;
		vY = v*yDis/Dis;
		
	}

}
