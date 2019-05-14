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
	public SpiderMan sm1;
	public ThanosGame() {

		im1 = new IronMan(1500,500);
		ca1 = new CaptainAmerica(1400,200);
		t1 = new Thor(1500, 400);
		sm1 = new SpiderMan(100,400);
		gos.add(im1);
		gos.add(ca1);
		gos.add(t1);
		gos.add(sm1);
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
