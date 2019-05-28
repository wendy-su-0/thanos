package thanos;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Heart {
	
	private int num = 5;
	private Image image;
	
	public Heart() {
		image = getImage("heart.png");
	}
	
	private Image getImage(String str) {
		
		try {
			image = ImageIO.read(this.getClass().getResource(str));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return image; 
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < num; i++) {
			g.drawImage(image, (int)ThanosGameRunner.WIDTH-250- (50*i), (int)ThanosGameRunner.HEIGHT-75, 50, 50, null);
		}
	}
	

}
