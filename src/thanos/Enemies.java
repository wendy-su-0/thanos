package thanos;

import java.awt.Graphics;
import kareltherobot.*;
import java.awt.Image;
import java.awt.Rectangle;

import javafx.scene.shape.Circle;

public class Enemies extends GameObject {

	private Rectangle hitbox;
	private int startX, startY, health, speed;
	private Direction direction;
	private int x,y;
	private boolean isDead = false;
	private Image image;
	Robot r;
	



	public Enemies(int x, int y, int h, int s, Image i) {
		super(x, y, i);
		startX = x;
		startY = y;
		health = h;
		speed = s;
		direction = East;
		r = new Robot(startX, startY, direction, 100);
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
		g.drawImage(image, startX, startY, null);
	}

	private void move() {
		r.turnLeft();
		direction = r.direction();
		if(direction != East) {
			if(r.frontIsClear()) {
				r.move();
			}
		}

	}

}
