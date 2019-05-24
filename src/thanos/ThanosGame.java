package thanos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.*;

public class ThanosGame {

	//	public static Point st, junc1, junc2, junc3, end;
	//	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public List<GameObject> gos = new ArrayList<>();
	public List<Enemies> enemies = new ArrayList<>();
	public List<Avengers> avengers = new ArrayList<>();
	public IronMan im1;
	public CaptainAmerica ca1;
	public Thor t1;
	public BlackWidow bw1;
	public Hawkeye he1;
	public Hulk h1;
	//public Enemies e1;
	//public Enemies e2;
	//public Enemies e3;
	public ThanosGame() {

		im1 = new IronMan(20,100);
		ca1 = new CaptainAmerica(140,100);
		t1 = new Thor(20, 220);
		bw1 = new BlackWidow(140,220);
		he1 = new Hawkeye(560,500);
		h1 = new Hulk(140,340);
		//e1 = new Thanos(30, 2);
		//e2 = new Leviathan(2,4);
		//e3 = new Kree(15,3);

		//e1 = new Enemies((int)GameLevel.junc1.getX(), (int)GameLevel.junc1.getY(), 5, 5, "thanos.jpg");

		gos.add(im1);
		gos.add(ca1);
		gos.add(t1);
		gos.add(bw1);
		gos.add(he1);
		gos.add(h1);
		//gos.add(e1);
		avengers.add(im1);
		avengers.add(ca1);
		avengers.add(t1);
		avengers.add(bw1);
		avengers.add(he1);
		avengers.add(h1);

		//enemies.add(e1);
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

	//	public void build() {
	//		st = new Point((int) (0.16*ThanosGameRunner.WIDTH), (int)ThanosGameRunner.HEIGHT);
	//		junc1 = new Point((int) (.639*ThanosGameRunner.WIDTH), (int) (.278*ThanosGameRunner.HEIGHT));
	//		junc2 = new Point((int) (.597*ThanosGameRunner.WIDTH), (int) (.722*ThanosGameRunner.HEIGHT));
	//		junc3 = new Point((int) (.231*ThanosGameRunner.WIDTH), (int) (.472*ThanosGameRunner.HEIGHT));
	//		end = new Point((int) (.907*ThanosGameRunner.WIDTH), (int) (.472*ThanosGameRunner.HEIGHT));
	//	}

	public void draw(Graphics g) {
		for(GameObject o: avengers) {
			o.draw(g);
		}
		for(GameObject e : enemies) {
			e.draw(g);
			System.out.println("draw");
		}
	}

	public void swap(int firstClickR, int firstClickC, int r, int c) {
		// TODO Auto-generated method stub

	}



	public void generateEnemies(int ticks) {
		if(ticks % 300 == 0) {
			enemies.add(new Kree(15,3));
			gos.add(new Kree (15,3));
		}

		if(ticks == 1) {
			enemies.add(new Leviathan(2,5));
			gos.add(new Leviathan(2,5));
		}

		if (ticks == 700){
			enemies.add(new Thanos(40,2));
			gos.add(new Thanos(40,2));
		}

	}
	
	public void generateEnemies() {
		enemies.add(new Leviathan(2,4));
		gos.add(new Leviathan(2,4));
	}
}
