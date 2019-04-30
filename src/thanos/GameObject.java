package thanos;

import java.awt.Graphics;
import java.awt.Image;

public class GameObject {
	int locx, locy;
	Image image;
	int width, height;
	
	
	public GameObject(int x, int y, Image i) {
		locx = x;
		locy = y;
		image = i;
	}
	
	
	public void draw(Graphics g) {
		
	}
}
