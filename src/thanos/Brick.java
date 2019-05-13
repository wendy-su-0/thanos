package thanos;

import java.awt.*;

public class Brick extends Rectangle{
	int xLoc, yLoc;
	
	public Brick(int x, int y, int width, int height, int lox, int loy) {
		setBounds(x,y,width,height);
		this.xLoc = lox;
		this.yLoc = loy;
	}
	
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}
