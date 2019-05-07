package thanos;

public class Projectile {
	
	int startX, startY, finishX, finishY, strength;
	boolean hitEnemy = false;
	private Rectangle hitbox;
	private Image image;
	
	public Projectile() {
			
	}
	
	public move(Avengers a, Enemies e) {
		a.setVars(e.r());
		//dy.dx straight
		
	}
	
	public void hit() {
		//mostly overlapping
		hitEnemy = !hitEnemy;
	}
	

	
}
