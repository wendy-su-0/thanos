package thanos;
import kareltherobot.*;
import kareltherobot.Robot;

import java.awt.*;
import java.lang.*;
import thanos.GameObject;
import thanos.Projectile;
import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.scene.shape.Circle;

public class Avengers extends GameObject{
	private int x, y;
	private int v;
	private int vX, vY;
	private static Image img;
	public Projectile p;
	private Circle range;

	protected Image getImage(String imgName) {
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
	
	public Avengers(int x, int y, int vel, String str, Circle circ) {
		super(x, y, img);
		v = vel;
		img = this.getImage(str);
		range = circ;
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
	/*
	 * 
	 * this is for when we want to to show the range so this like hovers over
	public void mouseMoved(MouseEvent e){
		if(circle.contains(e.getPoint())){
			//the mouse pointer is over the circle. So set a Message or whatever you want to do
			msg = "You are over circle 1";
		}else{
			msg = "You are not over the circle";
		}
	}
	*/

	public void setVars(Robot r) {
		int xDis = this.findX(r)-this.x;
		int yDis = this.findX(r)-this.y;
		int Dis = Math.abs(xDis*xDis + yDis*yDis);
		vX = v*xDis/Dis;
		vY = v*yDis/Dis;

	}

}
