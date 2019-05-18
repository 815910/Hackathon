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
	private static final int playerSpeed = 20;
	private static final int bumperSpeed = 10;
	private static final Color LIGHT_BLUE = new Color(108, 210, 247);
	private static final int deltaTime = 10;
	
	private BufferedImage image;
//  private ImageIcon image1 = new ImageIcon(".jpg");
	private Graphics g;
	private Timer timer;

	private Player player;
	private List<DoodleBumper> DoodleBumpers;

	private boolean left, right;

	public Team29() {
		DoodleBumpers = new ArrayList<DoodleBumper>();
		DoodleBumpers.add(new DoodleBumper(WIDTH/2, HEIGHT-200));
		DoodleBumpers.get(0).setSpeed(bumperSpeed);
		player = new Player(WIDTH/2,HEIGHT-250,50,Color.green.darker());
		player.setAcceleration(playerSpeed);
		player.setInitialVelocity(500,90);
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
			player.Launch(WIDTH, HEIGHT, deltaTime, DoodleBumpers.get(0));
			DoodleBumpers.get(0).move(HEIGHT, WIDTH);
			player.draw(g);
			DoodleBumpers.get(0).draw(g);
			updateMovement();
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
