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
	
	enum Dir {
		North, East, West, South;
	}
	
	public Enemies(int x, int y, int h, int s, Image i, Direction d) {
		super(x, y, i);
		startX = x;
		startY = y;
		health = h;
		speed = s;
		direction = d;
		r = new Robot(startX, startY, d, 100);
	}
	
	private boolean isHit() {
		
		return false;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, startX, startY, null);
	}
	
	private void move() {
		if(r.frontIsClear()) {
			r.move();
		}
		switch(direction) {
		
		
		}
	}

}
