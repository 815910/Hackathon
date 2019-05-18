import java.awt.Color;
import java.awt.Graphics;

public class DoodleBumper extends Bumper{
	private int x;
	private int y;
	private int width=100;
	private int height=20;
	private Color color;
	private int speed;
	private int gravity=10;
	
	public DoodleBumper() {
		this.x=0;
		this.y=0;
		this.color=(Color.green);
		this.speed=0;
	}
	public DoodleBumper(int x, int y) {
		this.x=x;
		this.y=y;
		this.color=(Color.green.darker());
		this.speed=0;
	}
	public DoodleBumper(int x, int y, int speed) {
		this.x=x;
		this.y=y;
		this.color=(Color.blue.brighter());
		this.speed=speed;
	}
	public void setX(int x) {
		this.x=x;
	}
	/**
	 * returns the x
	 * @return x the x-coordinate middle of the ball
	 */
	public int getX() {
		return x;
	}
	/**
	 * sets the y-coordinate of the middle of the ball
	 * @param y the y-coordinate of the middle of the ball
	 */
	public void setY(int y) {
		this.y=y;
	}
	/**
	 * returns the y coordinate of the middle of the ball
	 * @return y the y coordinate of the middle of the ball
	 */
	public int getY() {
		return y;
	}
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	public int getSpeed() {
		return speed;
	}

	public void setHeight(int height) {
		this.height=height;
	}
	public int getHeight() {
		return height;
	}
	public void setWidth(int width) {
		this.width=width;
	}
	public int getWidth() {
		return width;
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}
	public void move(int bottomEdge, int width, int distance) {
		
		setY(getY()+distance);
		
	}
}
