package thanos;

public class Projectile {
	
	int startX, startY, finishX, finishY, strength;
	boolean hitEnemy = false;
	
	public Projectile() {
			
	}
	
	public void hit() {
		hitEnemy = true;
	}
	
}
