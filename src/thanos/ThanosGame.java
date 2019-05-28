package thanos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

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
	public Enemies e1;
	private Heart hearts;
	public int bank = 1000;
	//public Enemies e2;
	//public Enemies e3;
	
	//private int hearts = 5;
	
	public ThanosGame() {

//		im1 = new IronMan(2000,300);
//		ca1 = new CaptainAmerica(1400,400);
//		t1 = new Thor(200, 320);
//		bw1 = new BlackWidow(740,520);
//		he1 = new Hawkeye(560,500);
//		h1 = new Hulk(140,340);
//		e1 = new Thanos(30, 2);

		im1 = new IronMan(2000,300);
		ca1 = new CaptainAmerica(1400,400);
		t1 = new Thor(200, 320);
		bw1 = new BlackWidow(740,520);
		he1 = new Hawkeye(560,500);
		h1 = new Hulk(140,340);
		e1 = new Thanos(30, 2);
		hearts = new Heart();

		//e2 = new Leviathan(2,4);
		//e3 = new Kree(15,3);

		//e1 = new Enemies((int)GameLevel.junc1.getX(), (int)GameLevel.junc1.getY(), 5, 5, "thanos.jpg");

//		gos.add(im1);
//		gos.add(ca1);
//		gos.add(t1);
//		gos.add(bw1);
//		gos.add(he1);
//		gos.add(h1);
//		gos.add(e1);
//		avengers.add(im1);
//		avengers.add(ca1);
//		avengers.add(t1);
//		avengers.add(bw1);
//		avengers.add(he1);
//		avengers.add(h1);

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
		
		hearts.draw(g);
		
	}
	

	public void swap(int firstClickR, int firstClickC, int r, int c) {
		// TODO Auto-generated method stub

	}



	public void generateEnemies(int ticks) {
		if(ticks % 400 == 0) {
			enemies.add(new Kree(15,2));
			gos.add(new Kree (15,2));
			bank-= enemies.get(enemies.size()-1).cost;
		}

		if(ticks % 200 == 0) {
			enemies.add(new Leviathan(2,5));
			gos.add(new Leviathan(2,5));
			bank-= enemies.get(enemies.size()-1).cost;
		}

		if (ticks == 700){
			enemies.add(e1);
			gos.add(e1);
			bank-= enemies.get(enemies.size()-1).cost;
		}

	}
	
	public void generateEnemies() {
		enemies.add(new Leviathan(2,5));
		gos.add(new Leviathan(2,5));
		bank-= enemies.get(enemies.size()-1).cost;
		//kree speed 2
		//thanos speed 2
		//leviathan speed 5
	}




//	public void checkHearts() {
//		for(Enemies e: enemies) {
//			if(e.getX() > ThanosGameRunner.end.getX()) {
//				hearts--;
//			}
//		}
//	}
	
	public void addAvenger(Avengers a) {
		avengers.add(a);
	}

//
//	public void checkHearts() {
//		for(Enemies e: enemies) {
//			if(e.getX() > ThanosGameRunner.end.getX()) {
//				hearts--;
//			}
//		}
//	}

}
