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
	private double currentY;
	private boolean isDead = false;
	private Image image;
	Robot r;

	//the initial x and y are pixels. they are then converted to st/ave coordinates 
	//and passed into the robot constructor
	public Enemies(int x, int y, String str) {
		super(x, y, str);
		startX = (int) GameLevel.st.getX();
		startY = (int) GameLevel.st.getY();
		health = x;
		speed = y;
		image = getImage(str);
	}
	//when workng with the enemey class we need to be very clear is we are
	//working with a ave/st x/y or a x/y in pixels

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
			health -= p.getStrengt();
		}
		if(health<=0) {
			destroy();
		}
	}

	private void destroy() {
		image = null;
	}

	public void draw(Graphics g) {
		//g.drawImage(image, currentX, (int) currentY, null);
		g.drawLine(564, 2959, 2336, 719);
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

	public double getY() {
		return currentY;
	}

	public void move() {
		int count = 0;
		if(count ==0) {
			double slope = -((GameLevel.junc1.getY()-GameLevel.st.getY())/(GameLevel.junc1.getX()-GameLevel.st.getX()));
			
			currentX = startX;
			currentY = slope*currentX;
			currentX++;
			if(currentY == GameLevel.junc1.getY() && currentX == GameLevel.junc1.getX()) {
				count++;
			}
		}
		if(count == 1) {
			double slope = -((GameLevel.junc2.getY()-GameLevel.junc1.getY())/(GameLevel.junc2.getX()-GameLevel.junc1.getX()));
			
			currentY = slope*currentX;
			currentX--;
			if(currentY == GameLevel.junc2.getY() && currentX == GameLevel.junc2.getX()) {
				count++;
			}
		}
		if(count == 2) {
			double slope = -((GameLevel.junc3.getY()-GameLevel.junc2.getY())/(GameLevel.junc3.getX()-GameLevel.junc2.getX()));
			
			currentY = slope*currentX;
			currentX--;
			if(currentY == GameLevel.junc3.getY() && currentX == GameLevel.junc3.getX()) {
				count++;
			}
		}
		if(count == 3) {
			currentX++;
			if(currentX == GameLevel.end.getX()) {
				count++;
			}
		}
	}

}


