
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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import kareltherobot.*;


public class ThanosGameRunner  implements ActionListener {
	private JPanel gamePanel, menu;
	private JFrame frame;
	private JSplitPane mainPanel;
	private ThanosGame game;
	private Timer timer;
	private int ticks;
	private int r;
	private int c;
	private Image img = getImage() ;
	private Image icon1 = getIcon1();
	private Image icon2 = getIcon2();
	private Image icon3 = getIcon3();
	private Image icon4 = getIcon4();
	private int gameLevel=1;
	private JButton BW,CA, HE, H, IM, T, START;
	private JOptionPane instructions;
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

	private Image getIcon4() {
		try {

			icon4 = ImageIO.read(this.getClass().getResource("endgame2.jpg"));
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return icon4;
	}

	private Image getIcon3() {
		try {

			icon3 = ImageIO.read(this.getClass().getResource("happytony.jpg"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return icon3;
	}

	private Image getIcon2() {
		try {

			icon2 = ImageIO.read(this.getClass().getResource("sadthor.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return icon2;
	}

	private Image getIcon1() {
		try {

			icon1 = ImageIO.read(this.getClass().getResource("thanos.jpg"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return icon1;
	}

	private Image getImage() {
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
		build();
		Font f = new Font("Helvetica Neue", Font.PLAIN, 20);
		game = new ThanosGame();
		instructions = new JOptionPane();
		instructions.setFont(f);
		ImageIcon icon = new ImageIcon(icon1);
		try{
		      AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(this.getClass().getResource("avengermusic.wav"));
		     Clip clip = AudioSystem.getClip();
		     clip.open(audioInputStream);
		     clip.start( );
		    }
		   catch(Exception ex)
		   {  }
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Veranda", Font.BOLD, 18)));   
		JOptionPane.showMessageDialog(
				null,
				"To place a tower, select the location and then select the desired tower",
				"Instructions",
				JOptionPane.INFORMATION_MESSAGE,
				icon);

		frame = new JFrame("ThanosGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainPanel = new JSplitPane();
		createButtons();

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		gamePanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, frame.getWidth(), frame.getHeight(), null);
				game.draw(g);
				drawGame(g);
			}
		};
		menu = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawRect(0, 0, screenSize.width, screenSize.height);
			}
		};
		// random color to the background

		//game.build();

		//panel.setBackground(new Color(255, 182, 193));
		gamePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				clickedAt(me);				
				frame.repaint();
			}
		});
		// so that the frame isn't minimized
		gamePanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));

		// so that the frame is placed a little way from top and left side
		frame.setLocation(WIDTH/2, HEIGHT/2);
		frame.setSize(WIDTH, HEIGHT);
		// map the keystrokes that the panel detects to the game
		mapKeyStrokesToActions(gamePanel);

		frame.getContentPane().setLayout(new GridLayout());
		frame.getContentPane().add(mainPanel);
		mainPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		mainPanel.setDividerLocation(WIDTH/5);
		mainPanel.setLeftComponent(menu);
		mainPanel.setRightComponent(gamePanel);
		menu.setLayout(new BoxLayout(menu,BoxLayout.Y_AXIS));
		//initializes buttons
		addButtons();
		//sets each button to an avenger 
		giveButtonAvenger();
		instructions.setLocation(WIDTH/2, HEIGHT/2);
		instructions.setVisible(true);
		frame.pack();
		frame.setVisible(true);

		// after setting visible to true, you can get focus.  You need focus to consume
		// the keystrokes hit by the user
		gamePanel.requestFocusInWindow();

		// this timer controls the actions in the game and then repaints after each update to data
		timer = new Timer(REFRESH_RATE, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateGame();
				gamePanel.repaint();
			}


		});
		//new TestDrag();
	}

	private void addButtons() {
		menu.add(BW); 
		menu.add(CA);
		menu.add(HE);
		menu.add(H);
		menu.add(IM);
		menu.add(T);
		menu.add(START);

	}

	private void createButtons() {
		Font f = new Font("Helvetica Nue", Font.BOLD, 16);
		BW = new JButton();
		BW.setSize(50,50);
		BW.setFont(f);
		BW.setText("Black Widow 300");
		BW.setForeground(Color.black);
		CA = new JButton();
		CA.setFont(f);;
		CA.setText("Cap America 400");
		CA.setForeground(Color.RED);
		HE = new JButton();
		HE.setText("Hawkeye 300");
		HE.setForeground(Color.blue);
		HE.setFont(f);
		H = new JButton();
		H.setText("Hulk 300");
		H.setForeground(Color.GREEN);
		H.setFont(f);
		IM = new JButton();
		IM.setText("Iron Man 500");
		IM.setForeground(Color.YELLOW);
		IM.setFont(f);
		T = new JButton();
		T.setText("Thor 400");
		T.setForeground(Color.GRAY);
		T.setFont(f);
		START = new JButton("Start");
		START.setFont(f);

	}

	

	private void giveButtonAvenger()  {
		BW.addActionListener(this);
		CA.addActionListener(this);
		HE.addActionListener(this);
		H.addActionListener(this);
		IM.addActionListener(this);
		T.addActionListener(this);
		START.addActionListener(this);
	}
public void actionPerformed(ActionEvent ae) {
    String test = ae.getActionCommand();
    if(test.equals("Start")) 
 	   timer.start();
    
    
    if(test.equals("Black Widow 300")) {
 	   int x = r;
 	   int y = c;
 	   System.out.println(x);
 	   System.out.println(y);
 	   if(game.bank - 300 >= 0) {
 	   BlackWidow s = new BlackWidow(x, y);
 	   game.addAvenger(s);
 	   game.bank -= 300;
 	   gamePanel.repaint();
 	   }
 	   else bRoke();
 	   
    }
    
    if(test.equals("Cap America 400")) {
 	   int x = r;
 	   int y = c;
 	   System.out.println(x);
 	   System.out.println(y);
 	   if(game.bank - 400 >= 0) {
 	   CaptainAmerica s = new CaptainAmerica(x, y);
 	   game.addAvenger(s);
 	   game.bank -= 400;
 	   gamePanel.repaint();
 	   }
 	   else bRoke();
    }
    
    if(test.equals("Hawkeye 300")) {
 	   int x = r;
 	   int y = c;
 	   System.out.println(x);
 	   System.out.println(y);
 	   if(game.bank - 300 >= 0) {
 	   Hawkeye s = new Hawkeye(x, y);
 	   game.addAvenger(s);
 	   game.bank -= 300;
 	   gamePanel.repaint();
 	   }
 	   else bRoke();
    }
    
    if(test.equals("Hulk 300")) {
 	   int x = r;
 	   int y = c;
 	   System.out.println(x);
 	   System.out.println(y);
 	   if(game.bank - 300 >= 0) {
 	   Hulk s = new Hulk(x, y);
 	   game.addAvenger(s);
 	   game.bank -= 300;
 	   gamePanel.repaint();
 	   }
 	   else bRoke();
    }
    
    if(test.equals("Iron Man 500")) {
 	   int x = r;
 	   int y = c;
 	   System.out.println(x);
 	   System.out.println(y);
 	   if(game.bank - 500 >= 0) {
 	   IronMan s = new IronMan(x, y);
 	   game.addAvenger(s);
 	   game.bank -= 500;
 	   gamePanel.repaint();
 	   }
 	   else bRoke();
    }
    
    if(test.equals("Thor 400")) {
 	   int x = r;
 	   int y = c;
 	   System.out.println(x);
 	   System.out.println(y);
 	   if(game.bank - 400 >= 0) {
 	   Thor s = new Thor(x, y);
 	   game.addAvenger(s);
 	   game.bank -= 400;
 	   gamePanel.repaint();
 	   }
 	   else bRoke();
    }
 }
	


	protected void clickedAt(MouseEvent me) {
		r = me.getX();
		c = me.getY();
		System.out.print(me);
		gamePanel.repaint();


	}


	// this method is called every time the timer goes off (which right now is every 10 milliseconds = 100 times per second
	public int getTicks() {
		return ticks;
	}
	private void levelUp() {
		JOptionPane levelUp = new JOptionPane();
		ImageIcon icon = new ImageIcon(icon3);
		levelUp.showMessageDialog(
				null,
				"Level Up! You are now on level " + game.gameLevel + "!",
				"Level up",
				JOptionPane.INFORMATION_MESSAGE,
				icon);
	}

	private void bRoke() {
		JOptionPane bankrupt = new JOptionPane();
		ImageIcon icon = new ImageIcon(icon2);
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Veranda", Font.BOLD, 16)));   
		bankrupt.showMessageDialog(
				null,
				"Seems like you can't buy any more towers! There's only room for one billionare genius philantropist in here!",
				"Bankrupt",
				JOptionPane.INFORMATION_MESSAGE,
				icon);
		
	
	}
	protected void updateGame() {
		ticks++;// keeps track of the number of times the timer has gone off

		int hurts = 1000/REFRESH_RATE;


		if(ticks %hurts == 0) {
			System.out.println(ticks/hurts+" seconds");
		}
		move();
		game.generateEnemies(ticks, game.gameLevel);

		if(ticks > ((game.gameLevel+1)*game.gameLevel/2)*2000 + 100) {
			game.gameLevel++;
			this.levelUp();
			timer.stop();
		}

		for(int i = 0; i < game.avengers.size(); i++) {
			for(int e = 0; e < game.enemies.size(); e++){
				if(game.avengers.get(i).isInCirc(game.enemies.get(e))) {
					game.enemies.get(e).add(game.avengers.get(i));
					game.enemies.get(e).reduceSize(game.avengers.get(i));
					if(game.enemies.get(e).getTicks() >= 500) {
						game.bank += (game.enemies.get(e).cost)/10;
						game.enemies.remove(e);
					}
					break;
				}
			}

		}



		game.checkHearts();
		if(game.checkZero()){
			endGame();
		}
	}

	private void endGame() {
		JOptionPane endGame = new JOptionPane();
		ImageIcon icon = new ImageIcon(icon4);
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
		          "Veranda", Font.BOLD, 16)));   
		endGame.showMessageDialog(
				null,
				"You are out of lives. Start over!",
				"Game Over",
				JOptionPane.INFORMATION_MESSAGE,
				icon);
	
		timer.stop();
		this.start();
	}

	private void mapKeyStrokesToActions(JPanel panel) {

	
		ActionMap map = panel.getActionMap();
		InputMap inMap = panel.getInputMap();

		
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

		gamePanel.repaint();
	}
	protected void drawGame(Graphics g) {
		game.draw(g);
	}

	public void build() {
		st = new Point((int) (0.16*ThanosGameRunner.WIDTH), (int) ThanosGameRunner.HEIGHT);
		junc1 = new Point((int) (.639*ThanosGameRunner.WIDTH), (int) (.278*ThanosGameRunner.HEIGHT));
		junc2 = new Point((int) (.597*ThanosGameRunner.WIDTH), (int) (.722*ThanosGameRunner.HEIGHT));
		junc3 = new Point((int) (.225*ThanosGameRunner.WIDTH), (int) (.450*ThanosGameRunner.HEIGHT));
		end = new Point((int) (.907*ThanosGameRunner.WIDTH), (int) (.450*ThanosGameRunner.HEIGHT));
	}

	private void move() {
		// TODO Auto-generated method stub
		for(Enemies e : game.enemies) {
			e.move(e.getMoveX(), e.getMoveY());
			//System.out.println("ee");
		}

	}



}
