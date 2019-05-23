package thanos;

import java.awt.Image;
import java.awt.Rectangle;

public class Projectile extends GameObject {
	
	public static final int Width = 20, Height = 20;
	int startX, startY, finishX, finishY, strength, currentX, currentY, speed;
	boolean hitEnemy = false;
	private Rectangle hitbox;
	private Image image;
	public int dX, dY;
	
	public Projectile(int x, int y, int s, Image image) {
		super(x, y, image);
		speed = s;
		startX = x;
		currentX = x;
		currentY = y;
		startY = y;
	}
	
	//move triangels hypontenuse movement x-x y-y 
	//one velocity
	
	
	public void hitsEnemy() {
		//mostly overlapping
		hitEnemy = !hitEnemy;
	}
	
	public Rectangle getHitBox() {
		return hitbox;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void move(int dX,int dY) {
		currentX += dX;
		currentY += dY;
		
	}


	public void launch() {
		// TODO Auto-generated method stub
		int totalX = this.finishX - this.startX;
		int totalY = this.finishY - this.startY;
		int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
		int time = dist/speed;
		//this should actually be dependent on ticks
		int xPerT = totalX/time;
		int yPerT = totalY/time;
		dX = xPerT;
		dY = yPerT;
		//linked to timer
		//this code shouldn't be here
		while (time > 0) {
			//move xPerT and yPerT
		}
	}
	
}
