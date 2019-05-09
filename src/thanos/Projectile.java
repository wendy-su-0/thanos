package thanos;

import java.awt.Image;
import java.awt.Rectangle;

public class Projectile extends GameObject {
	
	public static final int Width = 20, Height = 20;
	int startX, startY, finishX, finishY, strength, currentX, currentY;
	boolean hitEnemy = false;
	private Rectangle hitbox;
	private Image image;
	
	public Projectile(int x, int y, Image image) {
		super(x, y, image);
		startX = x;
		startY = y;
	}
	
	
	public void hit() {
		//mostly overlapping
		hitEnemy = !hitEnemy;
	}
	
	public Rectangle getHitBox() {
		return hitbox;
	}
	
	public int getStrengt() {
		return strength;
	}
	
}
