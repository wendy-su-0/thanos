package thanos;

import java.awt.Graphics;
import kareltherobot.*;
import java.awt.Image;

import javafx.scene.shape.Circle;

public class Enemies extends GameObject {
	
	private Circle hitbox;
	private int startX, startY, health, speed;
	private int x,y;
	private boolean isDead = false;
	private Image image;
	
	public Enemies(int x, int y, int h, int s, Image i) {
		super(x, y, i);
		startX = x;
		startY = y;
		health = h;
		speed = s;
		hitbox.setCenterX(startX);
		hitbox.setCenterY(startY);
	}
	
	private boolean isHit() {
		
		return false;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, startX, startY, null);
	}
	
	private void move() {
		
	}

}
