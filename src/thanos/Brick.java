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
		try {
			image = ImageIO.read(this.getClass().getResource("yellowbrick.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void draw(Graphics g) {
		g.drawImage(image, x, y, width, height, null);
	}
}
