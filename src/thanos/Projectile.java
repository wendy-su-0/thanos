package thanos;

public class Projectile {
	
	int startX, startY, finishX, finishY, strength;
	boolean hitEnemy = false;
	private Circle hitbox;
	private Image image;
	
	public Projectile() {
			
	}
	
	public void hit() {
		hitEnemy = !hitEnemy;
	}
	
	public static double area(Rectangle rect) {
		return rect.width*rect.height;
	}
	
	public boolean hit(GameObject go) {
		Rectangle over = collisionRect(go);
		if(over.isEmpty())
			return false;
		double thisArea = area(rect), 
				goArea = area(go.getRect()),
				overArea = area(over);
		return overArea > Math.min(thisArea, goArea)*HIT_THRESHOLD;
	}
	
	public Rectangle collisionRect(GameObject go) {
		return this.rect.intersection(go.getRect());
	}

	public boolean mostlyOverlapping(GameObject go) {
		Rectangle over = collisionRect(go);
		if(over.isEmpty()) {
			return false;
		}
		double thisArea = area(this.rect), 
				goArea = area(go.rect),
				overArea = area(over);
		return overArea > Math.min(thisArea, goArea)*OVERLAP_THRESHOLD;
	}
	
	public Rectangle getRect() {
		return this.rect;
	}
	
}
