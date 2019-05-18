import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends GravityBall{
	private double acceleration;
	private double diameter;
	private double radius;
	private ImageIcon Doodle = new ImageIcon("DoodleJump.png");
	/**
	 * Creates a GravityBall with center at x,y with a diameter and color
	 * that the user inputs
	 * @param x where the middle of the GravityBall is in the horizontal position
	 * @param y where the middle of the GravityBall is in the vertical position
	 * @param diameter the diameter of the ball
	 * @param color the color of the ball
	 */
	public Player(double x, double y, double diameter, Color color) {
		super(x,y,diameter,color);
		this.diameter=diameter;
		this.radius=diameter/2;
	}
	/**
	 * Sets the acceleration at what the user inputs
	 * @param acceleration the acceleration of the ball
	 */
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	/**
	 * returns the acceleration
	 */
	public double getAcceleration() {
		return acceleration;
	}
	/**
	 * sets the initial velocity of the GravityBall
	 * @param speed the speed that the GravityBall is launched at
	 * @param angle the angle that the GravityBall is launched at
	 */
	public void setInitialVelocity(int speed, int angle) {
		setXSpeed(speed*Math.cos(Math.toRadians(angle)));
		setYSpeed(speed*(-1)*Math.sin(Math.toRadians(angle)));
	}
	/**
	 * Launches GravityBall, bounces off the sides of the screen
	 * @param rightEdge the right edge of the window
	 * @param bottomEdge the bottom edge of the window
	 * @param deltaTime the change in time
	 */
	public void Launch(int rightEdge, int bottomEdge, double deltaTime, DoodleBumper bumper, int speed, int angle) {
		setXSpeed(getXSpeed());
		setYSpeed(getYSpeed());
		
		setX(getX()+getXSpeed()*deltaTime/1000);
		setY(getY()+getYSpeed()*deltaTime/1000);
		
		//RightEdge
		if(getX()+radius>=rightEdge) {
			setXSpeed(getXSpeed()*(-1));
			setX(0+(2*getRadius()));
			System.out.println(getX());
			//setRandomColor();
		}
		//Left Edge
		if(getX()-radius<=0) {
			setXSpeed(getXSpeed()*(-1));
			setX(rightEdge-(2*getRadius()));
			System.out.println(getX());
			//setRandomColor();
		}
		//Bottom Edge
//		if(getY()+radius>=bottomEdge) {
//			setYSpeed(getYSpeed()*(-1));
//			setY(bottomEdge-radius);
//			//setRandomColor();
//		}
		//Bumper
		if(getY()-radius>=bumper.getY()-25&&getY()-radius<=bumper.getY()&&getX()+radius>=bumper.getX()&&getX()-radius<=bumper.getX()+bumper.getWidth()) {
			setInitialVelocity(speed*2/4, angle);
			setY(bumper.getY()-radius);
		}

		//Top
		if(getY()-radius<=0) {
			setYSpeed(getYSpeed()*(-1));
			setY(radius);
			//setRandomColor();
		}
	}
	/**
	 * draws the GravityBall
	 */
	public void draw(Graphics g) {
		super.draw(g);
		g.drawImage(Doodle.getImage(), (int)(getX()-getRadius()-5), (int)(getY()-(2*getRadius())), (int)(getDiameter()*2), (int)(2*getDiameter()), null);
	}
}
