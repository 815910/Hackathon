import java.awt.Color;
import java.awt.Graphics;

public class PowerUp {

	private double x;			//x-coordinate of the center of the ball
	private double y;			//y-coordinate of the center of the ball
	private Color color;		//color of the ball
	private double width;
	private double height;
	private double radius;
	private double diameter;	//diameter of the ball
	
	public PowerUp() {
		this.x = 0.0;
		this.y = 0.0;
		this.color = Color.BLUE;
		this.width = 0.0;
		this.height = 0.0;
		this.radius = diameter/2;
		this.diameter = 0;
		
	}
	
	public PowerUp(double x, double y, double diameter, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.width = 0.0;
		this.radius = diameter/2;
		this.diameter = diameter;
	}
	
	/**
	 * sets the x value of the ball
	 * @param x 
	 */
	public void setX(double x) {
		this.x = x;
    }
	
	/**
	 * returns the x value of the ball		
	 * @return
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * sets the y value of the ball
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * returns the y value of the ball
	 * @return
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * sets the color of the ball
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * returns the color of the ball
	 * @return
	 */
	public Color getColor() {
		return color;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	/**
	 * sets the diameter of the of the ball
	 * says the radius is equal to half of the diameter
	 * @param diameter
	 */
	public void setDiameter(double diameter) {
		this.diameter = diameter;
		this.radius = diameter/2;
	}
	
	/**
	 * returns the diameter of the ball
	 * @return
	 */
	public double getDiameter() {
		return diameter;
	}
		
	/**
	 * sets the radius of the ball
	 * states the diameter is equal to two times the radius
	 * @param radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
		this.diameter = radius*2;
	}
	
	/**
	 * returns the radius of the ball
	 * @return
	 */
	public double getRadius() {
		return radius;
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillOval((int)(getX()-getRadius()), (int)(getY()-getRadius()), (int)(getDiameter()), (int)(getDiameter()));
	}
	
	public void setRandomLocation(double x, double y) {
		setX((int)(Math.random()*x+getDiameter()));
		setY((int)(Math.random()*y+getDiameter()));
	}
	
	public void setLocation() {
		setX(getX());
		setY(getY());
		
	}
	
	public boolean intersectsWith(Player otherPlayer) {
		if (this.getRadius() + otherPlayer.getRadius() >= distanceFrom(otherPlayer.getX(), otherPlayer.getY())) {
			return true;
		} else {
			return false;
		}		
	}	
	
	public double distanceFrom(double x, double y) {
		return(Math.pow(Math.pow((getX() - x), 2) + Math.pow((getY() - y), 2), 0.5));
	}
	
	public boolean shield(BadGuy otherBadGuy) {
		if (this.getRadius() + otherBadGuy.getRadius() >= distanceFrom(otherBadGuy.getX(), otherBadGuy.getY())) {
			return true;
		} else {
			return false;
		}
	}
}
