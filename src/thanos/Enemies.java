package thanos;

import java.awt.Graphics;
import java.awt.Image;

public class Enemies extends GameObject {
	
	private int startX, startY, health, speed;
	private boolean isDead = false;
	private Image image;
	
	public Enemies(int x, int y, int h, int s, Image i) {
		super(x, y, i);
		startX = x;
		startY = y;
		health = h;
		speed = s;
	}
	
	private boolean isHit() {
		
		return false;
	}
	
	public void draw(Graphics g) {
		
	}
	
	private void move() {
		
	}

}
