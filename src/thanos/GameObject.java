package thanos;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import kareltherobot.Directions;

public class GameObject implements Directions{
	
	private static final double HIT_THRESHOLD = .1;
	public final static String PATH_PREFIX = "res/images/";
	
	int locx, locy;
	private Image img;
	int width, height;
	private Rectangle rect;
	
	/*
	protected  Image getImage(String fn) {
		Image img = null;
		fn = PATH_PREFIX+fn;
		try {
			
			img = ImageIO.read(this.getClass().getResource(fn));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	*/
	
	public GameObject(int x, int y, Image image) {
		locx = x;
		locy = y;
		img = image;
	}
	
	
	private void draw(Graphics g) {
		
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

	public Rectangle getRect() {
		return this.rect;
	}
	
	public void move(int dx, int dy) {
		rect.translate(dx, dy);
	}
	
	public Image returnImg (Image img) {
		return img;
	}

	
}

