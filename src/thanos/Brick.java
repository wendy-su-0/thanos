package thanos;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Brick extends Rectangle{
	int xLoc, yLoc;
	private static Image image;
	public final static String PATH_PREFIX = "res/images/";
	
	protected Image getImage(String imgName) {
		try {
			image = ImageIO.read(this.getClass().getResource(imgName));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public Brick(int x, int y, int width, int height, String str) {
		setBounds(x,y,width,height);
		image = this.getImage(str);
	}
	
	

	public void draw(Graphics g) {
		g.drawImage(image, x, y, width, height, null);
	}
}
