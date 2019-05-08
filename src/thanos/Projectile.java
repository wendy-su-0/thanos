package thanos;

import java.awt.Image;
import java.awt.Rectangle;

public class Projectile {
	public static final int Width = 20, Height = 20;
	int startX, startY, finishX, finishY, strength, currentX, currentY;
	boolean hitEnemy = false;
	private Rectangle hitbox;
	private Image image;
	

	
	public Projectile() {
			hitbox = new Rectangle(currentX, currentY, Width, Height); 	 	
	}
	
	public move(Avengers a, Enemies e) {
		a.setVars(e.r());
		//dy.dx straight
		
	}
	
	public void hit() {
		//mostly overlapping
		hitEnemy = !hitEnemy;
	}
	
	public Rectangle getHitBox() {
		return hitbox;
	}

	
}
