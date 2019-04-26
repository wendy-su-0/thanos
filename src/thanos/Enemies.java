package thanos;

import java.awt.Graphics;

public class Enemies extends GameObject {
	
	private int startX, startY, health, speed;
	private boolean isDead = false;
	
	public Enemies(int x, int y, int h, int s) {
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
