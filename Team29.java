import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Team29 extends JPanel {

	private static final int WIDTH = 850;
	private static final int HEIGHT = 1100;
	private static final int playerSpeed = 50;
	private static final int bumperSpeed = 25;
	private static final Color LIGHT_BLUE = new Color(108, 210, 247);
	private static final int deltaTime = 7;

	private BufferedImage image;
	private Graphics g;
	private Timer timer;
	private int ticks;
	private double score;
	private double bestY = 600;

	private Player player;
	private List<DoodleBumper> DoodleBumpers;

	private boolean left, right;

	public Team29() {
		DoodleBumpers = new ArrayList<DoodleBumper>();
		for(int i = 0; i < 5; i++) {
			DoodleBumpers.add(new DoodleBumper((int)(Math.random()*800+100), (int)(Math.random()*400+250)));
			
		}

		System.out.println(DoodleBumpers.get(0).getX());
		player = new Player(WIDTH/2,HEIGHT-250,50,Color.green.darker());
		player.setInitialVelocity(bumperSpeed,90);
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();

		player.draw(g);

		timer = new Timer(deltaTime, new TimerListener());
		timer.start();
		addKeyListener(new Keyboard());
		setFocusable(true);
	}

	public void updateMovement() {
		if (left) {
			player.setX(player.getX()-20);
		}
		if (right) {
			player.setX(player.getX()+20);
		}
		if (!left&&!right) {
			player.setXSpeed(0);
		}
	}
	
	public Boolean checkDie() {
		if(player.getY()>HEIGHT) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void end() {
		if(checkDie()) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Tahoma", Font.BOLD, 40));
			g.drawString("Game Over", WIDTH/2, HEIGHT/2-HEIGHT/3);
			timer.stop();
		}
	}
	
public void printInfo() {
		
		
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 250, 100);
		g.setColor(Color.BLACK);
		g.fillRect(1350, 0, 500, 100);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Tahoma", Font.BOLD, 30));
		score = (ticks/10 );
		
		String pattern = "#.##";
		DecimalFormat numberFormat = new DecimalFormat (pattern);
		g.drawString("Score: " + numberFormat.format(score) + " " , 10, 40);
		
		
	}


	private class Keyboard implements KeyListener {
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				left = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				right = true;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				left=false;
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				right=false;
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

	private class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// draw background / clear screen
			GraphicsUtilities.drawBackground(g, LIGHT_BLUE, WIDTH, HEIGHT);
			
			if(ticks%15 == 0) {
				DoodleBumpers.add(new DoodleBumper((int)(Math.random()*800+100), -200));
			}
			end();
			
			if(player.getY() < bestY) {
				for(int i = 0; i < DoodleBumpers.size(); i++) {
					DoodleBumpers.get(i).move(HEIGHT, WIDTH, (int)((bestY - player.getY())/50));
				}
			}
			
			for(int i = 0; i < DoodleBumpers.size(); i++) {
//				DoodleBumpers.get(i).move(HEIGHT, WIDTH);
//				if(DoodleBumpers.get(i).getY()>HEIGHT) {
//					DoodleBumpers.remove(i);
//				}
				player.Launch(WIDTH, HEIGHT, deltaTime, DoodleBumpers.get(i),bumperSpeed,90);
			}

			player.draw(g);
			for(int i = 0; i < DoodleBumpers.size(); i++) {
				DoodleBumpers.get(i).draw(g);
			}
			
			updateMovement();
			printInfo();
			System.out.println(player.getYSpeed());
			ticks++;
			repaint();
		}

	}

	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Team 29");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(540, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Team29());
		frame.setVisible(true);
	}

}
