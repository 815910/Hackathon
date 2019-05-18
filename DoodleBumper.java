import java.awt.Color;
import java.awt.Graphics;

public class DoodleBumper {
	private double x;
	private double y;
	private double width=100;
	private double height=20;
	private Color color;
	private double speed;
	private double gravity=10;
	
	public DoodleBumper() {
		this.x=0.0;
		this.y=0.0;
		this.color=(Color.green);
		this.speed=0;
	}
	public DoodleBumper(double x, double y) {
		this.x=x;
		this.y=y;
		this.color=(Color.green);
		this.speed=0;
	}
	public DoodleBumper(double x, double y, double speed) {
		this.x=x;
		this.y=y;
		this.color=(Color.blue.brighter());
		this.speed=speed;
	}
	public void setX(double x) {
		this.x=x;
	}
	/**
	 * returns the x
	 * @return x the x-coordinate middle of the ball
	 */
	public double getX() {
		return x;
	}
	/**
	 * sets the y-coordinate of the middle of the ball
	 * @param y the y-coordinate of the middle of the ball
	 */
	public void setY(double y) {
		this.y=y;
	}
	/**
	 * returns the y coordinate of the middle of the ball
	 * @return y the y coordinate of the middle of the ball
	 */
	public double getY() {
		return y;
	}
	public void setSpeed(double speed) {
		this.speed=speed;
	}
	public double getSpeed() {
		return speed;
	}
	public void setGravity(double gravity) {
		this.gravity=gravity;
	}
	public double getGravity() {
		return gravity;
	}
	public void setHeight(double height) {
		this.height=height;
	}
	public double getHeight() {
		return height;
	}
	public void setWidth(double width) {
		this.width=width;
	}
	public double getWidth() {
		return width;
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}
	public void move(int leftEdge, int rightEdge) {
		setX(getX()+getSpeed());
		setY(getY()+getGravity());
		if(getX()<=leftEdge||getX()+getWidth()>=rightEdge) {
			setSpeed(getSpeed()*-1);
		}
	}
}