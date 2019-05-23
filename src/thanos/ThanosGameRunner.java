
package thanos;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import kareltherobot.*;


public class ThanosGameRunner {
	private JPanel panel;
	private ThanosGame game;
	private Timer timer;
	private int ticks;
	private int r;
	private int c;
	private Image img = getImage();
	GameLevel l = new GameLevel();
	//Enemies s = new Enemies((int) (GameLevel.st.getX()),(int) (GameLevel.st.getY()), 10, 10, "thanos.jpg");


	private int c;
	private Image img = getImage();
	//public GameLevel l = new GameLevel();
	//Enemies s = new Enemies(10, 10, "thanos.jpg");

	public static Point st, junc1, junc2, junc3, end;
	//public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	// Notice this intuitive method for finding the screen size 
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) (screenSize.getWidth()), HEIGHT=(int) (screenSize.getHeight());
	private static final int REFRESH_RATE = 10; 

	public ThanosGameRunner() {
			EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					start();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				}
			}
		});
	}

	private Image getImage(
			) {
		try {
			
			img = ImageIO.read(this.getClass().getResource("avenger.jpg"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
		
	}

	public static void main(String[] args) {
		ThanosGameRunner s = new ThanosGameRunner();
	}

	private void start() {
		JFrame frame = new JFrame("ThanosGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, frame.getWidth(), frame.getHeight(), null);
			
				drawGame(g);
			}
		};
		// random color to the background
		
		//game.build();
		
		//panel.setBackground(new Color(255, 182, 193));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				clickedAt(me);				
				frame.repaint();
			}
		});
		// so that the frame isn't minimized
		panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		// so that the frame is placed a little way from top and left side
		frame.setLocation(WIDTH/10, HEIGHT/10);

		// map the keystrokes that the panel detects to the game
		mapKeyStrokesToActions(panel);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		// after setting visible to true, you can get focus.  You need focus to consume
		// the keystrokes hit by the user
		panel.requestFocusInWindow();
		
		// this timer controls the actions in the game and then repaints after each update to data
		timer = new Timer(REFRESH_RATE, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateGame();
<<<<<<< HEAD
				s.move();
=======
>>>>>>> branch 'master' of https://github.com/wsu315/thanos
				panel.repaint();
			}

			
		});
		new TestDrag();
		timer.start();
	}
	
	protected void clickedAt(MouseEvent me) {
		r = me.getX();
		c = me.getY();
		System.out.print(me);
		panel.repaint();
		//int r = (me.getX()-50)/ZHUel.SQUARE_SIZE;
		//int c = (me.getY()-50)/ZHUel.SQUARE_SIZE;

		System.out.println("You just clicked "+me);	
		if (firstClick) {
			firstClickR = r;
			firstClickC = c;
			firstClick = false;
		}
		else {
			game.swap(firstClickR, firstClickC, r, c);
			firstClick = true;
		}
		
	}
	
	public void swap(int firstR, int firstC, int r, int c) {
		
	}
	
	
	// this method is called every time the timer goes off (which right now is every 10 milliseconds = 100 times per second
	public int getTricks() {
		return ticks;
	}
	protected void updateGame() {
		ticks++;// keeps track of the number of times the timer has gone off
		
<<<<<<< HEAD
		int hurts = 1000/REFRESH_RATE;
		
		s.move();
=======
		int hurts = 1000/REFRESH_RATE;
		
>>>>>>> branch 'master' of https://github.com/wsu315/thanos
		if(ticks %hurts == 0) {
			System.out.println(ticks/hurts+" seconds");
		}
		move();
		//generateEnemies();
		for(int i = 0; i < game.avengers.size(); i++) {
				for(int e = 0; e < game.enemies.size(); e++){
					if(game.avengers.get(i).isInCirc(game.enemies.get(e))) {
						game.enemies.get(e).add(game.avengers.get(i));
						if(game.enemies.get(e).getTicks() >= 1000)
							game.enemies.remove(e);
					}
			}
		
		}
	}

	private void generateEnemies() {
		// TODO Auto-generated method stub
//		if (ticks > 100){
//			game.enemies.add(new Enemies(5,2,"thanos.jpg"));
//			game.returnEnemies();
//		}
	}

	private void mapKeyStrokesToActions(JPanel panel) {

		// A map is an Data storage interface which defines
		// an association of a key with a value
		// to "add" to a map you use the "put" method
		// to "get" from a map you use "get(key)" and the 
		// value associated with the key is returned (or null)
		ActionMap map = panel.getActionMap();
		InputMap inMap = panel.getInputMap();

		// code below associates pressing the up arrow with the command "up"
		// essentially creating the command "up" being broadcast any time the 
		// up key is hit
		inMap.put(KeyStroke.getKeyStroke("pressed UP"), "up");
		inMap.put(KeyStroke.getKeyStroke("pressed W"), "up");
		// code below associates the "up" action with anything in the 
		// actionPerformed method.  Right now, it just prints something
		map.put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hit("up");
			}

			
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
		panel.getActionMap().put("left",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("left");
			}
		});

	}
	public  void hit(String s) {
	//	game.keyHit(s);
		
		panel.repaint();
	}
	protected void drawGame(Graphics g) {
		//g.drawLine(130, 500, r, c);
		game.draw(g);
		g.drawLine((int)(st.getX()),(int) (st.getY()), (int) (junc1.getX()),(int) (junc1.getY()));
		g.drawLine((int)(junc2.getX()),(int) (junc2.getY()), (int) (junc1.getX()),(int) (junc1.getY()));
		g.drawLine((int)(junc2.getX()),(int) (junc2.getY()), (int) (junc3.getX()),(int) (junc3.getY()));
		//l.draw(g);
		//s.draw(g);
		//game.draw(g);
	}
	
	public void build() {
		st = new Point((int) (0.16*ThanosGameRunner.WIDTH), (int) ThanosGameRunner.HEIGHT);
		junc1 = new Point((int) (.639*ThanosGameRunner.WIDTH), (int) (.278*ThanosGameRunner.HEIGHT));
		junc2 = new Point((int) (.597*ThanosGameRunner.WIDTH), (int) (.722*ThanosGameRunner.HEIGHT));
		junc3 = new Point((int) (.231*ThanosGameRunner.WIDTH), (int) (.472*ThanosGameRunner.HEIGHT));
		end = new Point((int) (.907*ThanosGameRunner.WIDTH), (int) (.472*ThanosGameRunner.HEIGHT));
	}

	private void move() {
		// TODO Auto-generated method stub
		for(Enemies e : game.enemies) {
			e.move(e.getMoveX(), e.getMoveY());
			//System.out.println("ee");
		}
		//move goes in the go class
//		for(Avengers a : game.avengers) {
//			//l.firedProjectiles;
//			for(Projectile p : a.getFired()) {
//				(p).move(0, 0) ;

		}
	
	
	

}
