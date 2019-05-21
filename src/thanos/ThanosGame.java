package thanos;

import java.awt.Graphics;
import java.util.*;

public class ThanosGame {
	public List<GameObject> gos = new ArrayList<>();
	public List<Enemies> enemies = new ArrayList<>();
	public List<Avengers> avengers = new ArrayList<>();
	public IronMan im1;
	public CaptainAmerica ca1;
	public Thor t1;
	public BlackWidow bw1;
	public Hawkeye he1;
	public Hulk h1;
	public Enemies e1;
	public ThanosGame() {

		im1 = new IronMan(500,500);
		ca1 = new CaptainAmerica(400,200);
		t1 = new Thor(500, 400);
		bw1 = new BlackWidow(100,300);
		he1 = new Hawkeye(1000,200);
		h1 = new Hulk(300,400);
		
		e1 = new Enemies((int)GameLevel.junc1.getX(), (int)GameLevel.junc1.getY(), 5, 5, "thanos.jpg");
		
		gos.add(im1);
		gos.add(ca1);
		gos.add(t1);
		gos.add(bw1);
		gos.add(he1);
		gos.add(h1);
		gos.add(e1);
		enemies.add(e1);
	}
	
	public List<Enemies> returnEnemies(){
		return enemies;
	}
	
	private void checkDead() {
		for (int i = 0; i < enemies.size(); i++) {
			if(enemies.get(i)==null){
				enemies.remove(i);
				i--;
			}
		}
	}
	
	
	public void draw(Graphics g) {
		for(GameObject o: gos) {
			o.draw(g);
		}
	}
}
