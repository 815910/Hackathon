import java.awt.Color;

public class Player extends GravityBall{

	private double jumpHeight;
	
	
	public Player(double x, double y, double diameter, Color color) {
		super(x,y,diameter,color);
	}
	
	public void jump() {
		setYSpeed(getJumpHeight());
	}
	
	public void move(double deltaTime) {
		
		
		setXSpeed(getXSpeed());
		setYSpeed(getYSpeed() - (getAcceleration()*deltaTime));
		
		setX(getX() + getXSpeed()*(deltaTime/1000));
		setY(getY() + getYSpeed()*(deltaTime/1000));
		
		
	}

	/**
	 * @return the jumpHeight
	 */
	public double getJumpHeight() {
		return jumpHeight;
	}

	/**
	 * @param jumpHeight the jumpHeight to set
	 */
	public void setJumpHeight(double jumpHeight) {
		this.jumpHeight = jumpHeight;
	}
	
	
}
