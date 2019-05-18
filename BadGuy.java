import java.awt.Color;
import java.awt.Graphics;

public class BadGuy {
	
	private double x;
	private double y;
	private int width;
	private int height;
	private Color color;
	private int radius;
	private int diameter;
	private int xSpeed;
	private double ySpeed;		//y-speed = change in y-position

	/**
	 * Creates a cloud centered at (x, y) with the given width and height 
	 * with the given color
	 * @param x the x-coordinate of the center of the cloud
	 * @param y the y-coordinate of the center of the cloud
	 * @param width the width of the cloud
	 * @param height the height of the cloud
	 * @param color the color of the cloud
	 */
	public BadGuy(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		diameter = height/2;
		this.xSpeed = 0;
		
	}
	
	public void setDiameter(double diameter) {
		this.diameter = width;
		this.radius = (int)diameter/2;
	}
	
	/**
	 * Returns the x-coordinate of the cloud
	 * @return the x-coordinate of the cloud
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Returns the y-coordinate of the cloud
	 * @return the y-coordinate of the cloud
	 */
	public double getY() {
		return y;
	}
	

	
	/**
	 * Returns the horizontal speed (change in pixels)
	 * @return the horizontal speed (change in pixels)
	 */
	public int getXSpeed() {
		return xSpeed;
	}

	
	
	/**
	 * Sets the x-coordinate of the cloud
	 * @param x the x-coordinate of the cloud
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Sets the x-coordinate of the cloud
	 * @param x the x-coordinate of the cloud
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	
	
	/**
	 * Sets the horizontal speed (change in pixels)
	 * @param xSpeed the horizontal speed (change in pixels)
	 */
	public void setXSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public void setRadius(int radius) {
		this.radius = radius;
		this.radius = diameter/2;
	}
	
	public int getRadius() {
		return radius;
	}
	
	/**
	 * The cloud will move horizontally across the sky from left to right and
	 * move back to the left side when the cloud goes off the right side of the screen.
	 */
	public void move(int rightEdge) {
		setX(getX() + getXSpeed());
		
		if (getX() - width/2 > rightEdge) {
			setX(0 - width/2);
		}
		
	}
	
	
	
	/**
	 * Draws the cloud
	 * @param g the Graphics object
	 */
	public void draw(Graphics g) {
		g.setColor(color);
		// middle row
		g.fillOval((int)x-(diameter+diameter/2)+1,(int) y-diameter/2, diameter, diameter);
		
		
	}
	/**
	 * Moves to a random location within the boundaries of the rightEdge
	 * and bottomEdge
	 * @param rightEdge the ridgtEdge of the movement area
	 * @param bottomEdge the bottomEdge of the movement area
	 */
	public void setRandomLoction(int rightEdge, int bottomEdge) {
		setX(Math.random() * (rightEdge - this.getRadius() * 2) + this.getRadius());
		setY(Math.random() * (bottomEdge - this.getRadius() * 2) + this.getRadius());
		
	}

	/**
	 * Determines if the JumpingBall intersects, or collides with, another Ball object
	 * @param otherBall a Ball object
	 * @return true if JumpingBall intersects with the Ball, false otherwise
	 */
	public boolean intersectsWith(Player otherPlayer) {
		if((this.getRadius() + otherPlayer.getRadius()) >= findDistanceFrom(otherPlayer.getX(), otherPlayer.getY())) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Calculates and returns the distance between the center of the JumpingBall and 
	 * a specific (x, y) location.
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 * @return the distance between the center of the JumpingBall and (x, y) coordinate
	 */
	public double findDistanceFrom(double x, double y) {
		return (Math.sqrt((Math.pow(x - getX(), 2) + Math.pow(y - getY(), 2))));
		
	}

}

