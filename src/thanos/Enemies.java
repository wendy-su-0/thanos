package thanos;

import java.awt.Graphics;
import kareltherobot.*;
import java.awt.Image;
import java.awt.Rectangle;

import javafx.scene.shape.Circle;

public class Enemies extends GameObject {

	//the final int needs to be changed i'm too lazy rn to figure out the pixels of each ave and st
	static final int AVE_SQUARE_SIZE = 64, ST_SQUARE_SIZE = 64;
	private Rectangle hitbox;
	private int startX, startY, health, speed;
	private Direction direction;
	private int currentX, currentY;
	private boolean isDead = false;
	private Image image;
	Robot r;
	


	//the initial x and y are pixels. they are then converted to st/ave coordinates 
	//and passed into the robot constructor
	public Enemies(int x, int y, int h, int s, Image i) {
		//gameobject xy in pxels
		super(x, y, i);
		startX = x;
		currentX = x;
		startY = y;
		currentY = y;
		health = h;
		speed = s;
		direction = East;
		//the changed constructor passes in coordinates rather than pizels
		r = new Robot(startX/this.AVE_SQUARE_SIZE, startY/this.ST_SQUARE_SIZE, direction, 100);
	}
	//when workng with the enemey class we need to be very clear is we are
	//working with a ave/st x/y or a x/y in pixels
	
	
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
		g.drawImage(image, currentX, currentY, null);
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

	private void move() {
		r.turnLeft();
		direction = r.direction();
		if(direction != East) {
			if(r.frontIsClear()) {
				r.move();
				this.updateX();
				this.updateY();
			}
		}

	}

}
