package thanos;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Brick extends Rectangle{
	int xLoc, yLoc;
	Image image;
	
	
	
	public Brick(int x, int y, int width, int height) {
		setBounds(x,y,width,height);
		image = new ImageIcon("res/images/yellowbrick.jpg").getImage();
	}
	
	

	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}
