package thanos;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.scene.shape.Circle;
import kareltherobot.Directions;

public class GameObject implements Directions{
	
	private static final double HIT_THRESHOLD = .1;
	public final static String PATH_PREFIX = "res/images/";
	
	int locX, locY;
	private Image img;
	int width, height;
	private Rectangle rect;
	
	public GameObject(int x, int y, Image image) {
		locX = x;
		locY = y;
		img = image;
	}
	
	public GameObject(int x, int y, String str) {
		locX = x;
		locY= y;
		img = getImage(str);
	}
	
	protected Image getImage(String imgName) {
		try {
			img = ImageIO.read(this.getClass().getResource(imgName));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	
	public static double area(Rectangle rect) {
		return rect.width*rect.height;
	}

	public void draw(Graphics g) {
		g.drawImage(img,locX, locY, 100,100, null);
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
	
	public Image returnImg (Image im) {
		return im;
	}

	
}

