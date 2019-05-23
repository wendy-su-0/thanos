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
	protected Image image;
	Robot r;
	private int xCount = 0;
	private int yCount = 0;

	//the initial x and y are pixels. they are then converted to st/ave coordinates 
	//and passed into the robot constructor

	//when workng with the enemey class we need to be very clear is we are
	//working with a ave/st x/y or a x/y in pixels

	/*public Enemies(int h, int s, String str) {
		// TODO Auto-generated constructor stub
		super((int) ThanosGameRunner.st.getX(), (int) ThanosGameRunner.st.getY(), str);
		startX = (int) ThanosGameRunner.st.getX();
		startY = (int) ThanosGameRunner.st.getY();
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
		int xPerT = 0;
		int yPerT;
		if(xCount  ==0) {
			
			int totalX = (int)(ThanosGameRunner.junc1.getX() - startX);
			int totalY = (int)(ThanosGameRunner.junc1.getY() - startY);

			//int totalX = (int)(ThanosGameRunner.junc1.getX() - ThanosGameRunnerRunner.st.getX());
			//int totalY = (int)(ThanosGameRunnerRunner.junc1.getY() - ThanosGameRunnerRunner.st.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = (dist/speed);
			//this should actually be dependent on ticks
			xPerT = Math.round(totalX/time);
			currentX += xPerT;
			if(currentX > (int)(ThanosGameRunner.junc1.getX())) {
				xCount++;
			}
		}
		if(xCount == 1) {
			
			int totalX = (int)(ThanosGameRunner.junc2.getX() - ThanosGameRunner.junc1.getX() );
			int totalY = (int)(ThanosGameRunner.junc2.getY() - ThanosGameRunner.junc1.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = (dist/speed);
			//this should actually be dependent on ticks
			xPerT = Math.round(totalX/time);


			if(currentX > (int)(ThanosGameRunner.junc2.getX())) {
				xCount++;
			}

		}
		if(xCount == 2) {
			int totalX = (int)(ThanosGameRunner.junc3.getX() - ThanosGameRunner.junc2.getX());
			//start, junction 1, junction 3

			int totalY = (int)(ThanosGameRunner.junc3.getY() - ThanosGameRunner.junc2.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = (dist/speed);
			//this should actually be dependent on ticks
			xPerT = Math.round(totalX/time/1000);

			currentX += xPerT;
		}
		return xPerT;
	}

	public int moveY() {
		int xPerT;
		int yPerT = 0;
		if(yCount ==0) {
			
			int totalX = (int)(ThanosGameRunner.junc1.getX() - startX);
			int totalY = (int)(ThanosGameRunner.junc1.getY() - startY);
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			yPerT = Math.round(totalY/time);

			currentY += yPerT;
			if(currentY < (int)(ThanosGameRunner.junc1.getY())) {
				yCount++;
			}
		}
		if(yCount == 1) {

			int totalX = (int)(ThanosGameRunner.junc2.getX() - ThanosGameRunner.junc1.getX());
			int totalY = (int)(ThanosGameRunner.junc2.getY() - ThanosGameRunner.junc1.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			yPerT = Math.round(totalY/time);

			currentY += yPerT;
			if(currentY > (int)(ThanosGameRunner.junc2.getY())) {
				yCount++;
			}
		}
		if(yCount == 2) {

			int totalX = (int)(ThanosGameRunner.junc3.getX() - ThanosGameRunner.junc2.getX());
			int totalY = (int)(ThanosGameRunner.junc3.getY() - ThanosGameRunner.junc2.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			yPerT = Math.round(totalY/time);

			currentY += yPerT;
		}
		return yPerT;
	}
	/*
	public void move() {
		int count = 0;
		if(count ==0) {
			int totalX = (int)(ThanosGameRunner.junc1.getX() - ThanosGameRunner.st.getX());
			int totalY = (int)(ThanosGameRunner.junc1.getY() - ThanosGameRunner.st.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			int xPerT = totalX/time;
			int yPerT = totalY/time;

			currentX += xPerT;
			currentY += yPerT;
		}
		if(count == 1) {

			int totalX = (int)(ThanosGameRunner.junc2.getX() - ThanosGameRunner.junc1.getX());
			int totalY = (int)(ThanosGameRunner.junc2.getY() - ThanosGameRunner.junc1.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			int xPerT = totalX/time;
			int yPerT = totalY/time;

			currentX += xPerT;
			currentY += yPerT;

		}
		if(count == 2) {
			int totalX = (int)(ThanosGameRunner.junc2.getX() - ThanosGameRunner.junc1.getX());
			int totalY = (int)(ThanosGameRunner.junc2.getY() - ThanosGameRunner.junc1.getY());
			int dist = (int)Math.sqrt((totalX*totalX)+(totalY*totalY));
			int time = dist/speed;
			//this should actually be dependent on ticks
			int xPerT = totalX/time;
			int yPerT = totalY/time;

			currentX += xPerT;
			currentY += yPerT;
		}

			if(count == 3) {

			int totalX = (int)(ThanosGameRunner.junc3.getX() - ThanosGameRunner.junc2.getX());
			int totalY = (int)(ThanosGameRunner.junc3.getY() - ThanosGameRunner.junc2.getY());
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




