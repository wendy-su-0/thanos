package thanos;

import java.awt.Graphics;
import java.util.*;

public class ThanosGame {
	public List<GameObject> gos;
	Avengers avenger;
	public ThanosGame() {
		 avenger = new Avengers(2,2,2,"");
		 gos.add(avenger);
	}
	
	public void draw(Graphics g) {
		for(GameObject o: gos) {
			o.draw(g);
		}
	}
}
