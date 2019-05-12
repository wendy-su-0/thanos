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

	public Avengers(int x, int y, int vel, int r, String str) {
		super(x, y, img);
		v = vel;
		img = this.getImage(str);
		range = new Circle();
		range.setCenterX(x);
		range.setCenterY(y);
		range.setRadius(r);
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, locX , locY, 100, 100, null);

	}
	
	//not done
	private boolean isInCirc(Enemies e) {
		//if enemy xyloc is in circle return true
		return false;
	}
	
	//not done
	private void shoot(Enemies e) {
		//return int?
		Projectile p = new Projectile(x,y,null);
	}
	
	//the process the avenger every time each time elapsed = speed;
	public void process() {
		//for each enemies in enemy list check isInCirc;
		//if (isInCirc) shoot;
		
	}


	private void setLoc(int X, int Y) {
		locX = X;
		locY = Y;
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

	public void setVelocityXY(Enemies e) {
		int xDis = e.getX()-this.locX;
		int yDis = e.getY()-this.locY;
		int dis = Math.abs(xDis*xDis + yDis*yDis);
		vX = v*xDis/dis;
		vY = v*yDis/dis;

	}

}
