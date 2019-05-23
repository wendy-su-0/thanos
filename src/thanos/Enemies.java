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
	private int ticks;
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

	/*public Enemies(int h, int s, String str) {
		// TODO Auto-generated constructor stub
		super((int) GameLevel.st.getX(), (int) GameLevel.st.getY(), str);
		startX = (int) GameLevel.st.getX();
		startY = (int) GameLevel.st.getY();
		currentX = startX;
		currentY = startY;
		image = getImage(str);
		health = h;
		speed = s;
	}
	*/
	
	public Enemies(int h, int s, String str) {
		super(500,500, str);
		startX = 500;
		startY = 500;
		currentX = startX;
		currentY = startY;
		health = h;
		speed = s;
		image = getImage(str);
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
	//once it find that initial and finish points it doesn't need to keep on calculating x/y per t
	//it just nees to store that value and move by that
	
	public int moveX() {
		int count = 0;
		int xPerT = 0;
		int yPerT;
		if(count ==0) {
			if(currentX > (int)(ThanosGame.junc1.getX())) {
				count++;
			}
			int totalX = (int)(GameLevel.junc1.getX() - startX);
			int totalY = (int)(GameLevel.junc1.getY() - startY);
			
			//int totalX = (int)(GameLevel.junc1.getX() - GameLevel.st.getX());
			//int totalY = (int)(GameLevel.junc1.getY() - GameLevel.st.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = (dist/speed);
			//this should actually be dependent on ticks
			xPerT = totalX/time/1000;
			yPerT = totalY/time/1000;

			currentX += xPerT;
			currentY += yPerT;
		}
		if(count == 1) {

			int totalX = (int)(GameLevel.junc2.getX() - GameLevel.junc1.getX());
			int totalY = (int)(GameLevel.junc2.getY() - GameLevel.junc1.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = (dist/speed);
			//this should actually be dependent on ticks
			xPerT = totalX/time;
			yPerT = totalY/time;

			currentX += xPerT;
			currentY += yPerT;

		}
		if(count == 2) {
			int totalX = (int)(GameLevel.junc2.getX() - GameLevel.junc1.getX());
			//start, junction 1, junction 3
			
			int totalY = (int)(GameLevel.junc2.getY() - GameLevel.junc1.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = (dist/speed);
			//this should actually be dependent on ticks
			xPerT = totalX/time;
			yPerT = totalY/time;
		
			currentX += xPerT;
			currentY += yPerT;
		}

			if(count == 3) {

			int totalX = (int)(GameLevel.junc3.getX() - GameLevel.junc2.getX());
			int totalY = (int)(GameLevel.junc3.getY() - GameLevel.junc2.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			xPerT = totalX/time;
			yPerT = totalY/time;

			currentX += xPerT;
			currentY += yPerT;
		}
			return xPerT;
	}
	
	public int moveY() {
		int count = 0;
		int xPerT;
		int yPerT = 0;
		if(count ==0) {
			int totalX = (int)(GameLevel.junc1.getX() - GameLevel.st.getX());
			int totalY = (int)(GameLevel.junc1.getY() - GameLevel.st.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			xPerT = totalX/time;
			yPerT = totalY/time;

			currentX += xPerT;
			currentY += yPerT;
		}
		if(count == 1) {

			int totalX = (int)(GameLevel.junc2.getX() - GameLevel.junc1.getX());
			int totalY = (int)(GameLevel.junc2.getY() - GameLevel.junc1.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			xPerT = totalX/time;
			yPerT = totalY/time;

			currentX += xPerT;
			currentY += yPerT;

		}
		if(count == 2) {
			int totalX = (int)(GameLevel.junc2.getX() - GameLevel.junc1.getX());
			//start, junction 1, junction 3
			
			int totalY = (int)(GameLevel.junc2.getY() - GameLevel.junc1.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			xPerT = totalX/time;
			yPerT = totalY/time;
		
			currentX += xPerT;
			currentY += yPerT;
		}

			if(count == 3) {

			int totalX = (int)(GameLevel.junc3.getX() - GameLevel.junc2.getX());
			int totalY = (int)(GameLevel.junc3.getY() - GameLevel.junc2.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			xPerT = totalX/time;
			yPerT = totalY/time;

			currentX += xPerT;
			currentY += yPerT;
		}
			return yPerT;
	}
	/*
	public void move() {
		int count = 0;
		if(count ==0) {
			int totalX = (int)(GameLevel.junc1.getX() - GameLevel.st.getX());
			int totalY = (int)(GameLevel.junc1.getY() - GameLevel.st.getY());
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
	*/
	
	public void add(Avengers a) {
		ticks += a.getV();
	}
	public int getTicks() {
		return ticks;
	}
}




