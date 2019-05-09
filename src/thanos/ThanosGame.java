package thanos;

import java.awt.Graphics;
import java.util.*;

public class ThanosGame {
	public List<GameObject> gos;
	Avengers avenger;
	Avengers avenger2;
	public ThanosGame() {
		 avenger = new Avengers(2,2,2,"");
		 avenger2 = new Avengers(2,2,2,"");
		 gos.add(avenger);
	}
	
	public void draw(Graphics g) {
		for(GameObject o: gos) {
			o.draw(g);
		}
	}
}
