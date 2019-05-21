package thanos;

import java.awt.Graphics;
import kareltherobot.*;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.scene.shape.Circle;

public class Enemies extends GameObject {


	//the final int needs to be changed i'm too lazy rn to figure out the pixels of each ave and st
	static final int AVE_SQUARE_SIZE = 64, ST_SQUARE_SIZE = 64;
	private Rectangle hitbox;
	private int startX, startY, health, speed;
	private Direction direction;
	private int currentX;
	private int currentY;
	private boolean isDead = false;
	private Image image;
	Robot r;

	//the initial x and y are pixels. they are then converted to st/ave coordinates 
	//and passed into the robot constructor

	//when workng with the enemey class we need to be very clear is we are
	//working with a ave/st x/y or a x/y in pixels

	public Enemies(int x, int y, int h, int s, String str) {
		// TODO Auto-generated constructor stub
		super(x,y, str);
		startX = (int) GameLevel.st.getX();
		startY = (int) GameLevel.st.getY();
		currentX = startX;
		currentY = startY;
		image = getImage(str);
		health = h;
		speed = s;
	}

	protected Image getImage(String imgName) {
		Image img = null;
		try {
			img = ImageIO.read(this.getClass().getResource(imgName));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	private void isHit(Projectile p) {
		if(p.getHitBox().contains(hitbox)) {
			health -= p.getStrength();
		}
		if(health<=0) {
			destroy();
		}
	}

	private void destroy() {
		image = null;
	}

	public void draw(Graphics g) {
		g.drawImage(image, currentX,  currentY, null);

	}

	private void updateX() {
		//updates the xLoc in pixels based off of the changed avenue
		currentX = r.avenue()*this.AVE_SQUARE_SIZE;
	}

	private void updateY() {
		//updates the yLoc in pixels based off the changed street
		currentY = r.street()*this.ST_SQUARE_SIZE;
	}

	public int getX() {
		return currentX;
	}

	public int getY() {
		return currentY;
	}

	public void move() {
		int count = 0;
		if(count ==0) {
			int totalX = (int)(GameLevel.junc1.getX() - this.startX);
			int totalY = (int)(GameLevel.junc1.getY() - this.startY);
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			int xPerT = totalX/time;
			int yPerT = totalY/time;

			currentX += xPerT;
			currentY += yPerT;
		}
		if(count == 1) {

			int totalX = (int)(GameLevel.junc2.getX() - GameLevel.junc1.getX());
			int totalY = (int)(GameLevel.junc2.getY() - GameLevel.junc1.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			int xPerT = totalX/time;
			int yPerT = totalY/time;

			currentX += xPerT;
			currentY += yPerT;

		}
		if(count == 2) {
			int totalX = (int)(GameLevel.junc2.getX() - GameLevel.junc1.getX());
			int totalY = (int)(GameLevel.junc2.getY() - GameLevel.junc1.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			int xPerT = totalX/time;
			int yPerT = totalY/time;
			
			currentX += xPerT;
			currentY += yPerT;
		}

			if(count == 3) {

			int totalX = (int)(GameLevel.junc3.getX() - GameLevel.junc2.getX());
			int totalY = (int)(GameLevel.junc3.getY() - GameLevel.junc2.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			int xPerT = totalX/time;
			int yPerT = totalY/time;

			currentX += xPerT;
			currentY += yPerT;
		}
	}
}




