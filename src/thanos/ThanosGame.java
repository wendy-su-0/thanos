package thanos;

import java.awt.Graphics;
import java.util.*;

public class ThanosGame {
	public List<GameObject> gos = new ArrayList<>();
	public List<Enemies> enemies = new ArrayList<>();
	public IronMan im1;
	public CaptainAmerica ca1;
	public ThanosGame() {

		im1 = new IronMan(500,500);
		ca1 = new CaptainAmerica(400,200);
		gos.add(im1);
		gos.add(ca1);
	}
	
	public List<Enemies> returnEnemies(){
		return enemies;
	}
	
	
	public void draw(Graphics g) {
		for(GameObject o: gos) {
			o.draw(g);
		}
	}
}
