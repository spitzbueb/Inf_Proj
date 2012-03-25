package ch.zhaw.inf_project;

public class Missile {
	
	private double angle;
	private double velocity;
	private double acceleration;
	private int tank;
	private double startCoordinate;
	private double destinationCoordinate;
	
	public Missile(int tank){
		this.tank = tank;
	}
	
	public void setStartCoordinate(double startCoordinate){
		this.startCoordinate = startCoordinate;
	}
	
	public void setDestinationCoordinate(double destinationCoordinate){
		this.destinationCoordinate = destinationCoordinate;
	}
	
	public void setAcceleration(double acceleration){
		this.acceleration = acceleration;
	}
	
	public void setVelocity(double velocity){
		this.velocity = velocity;
	}
	
	public void setAngle(double angle){
		this.angle = angle;
	}
	
	public double getAcceleration(){
		return this.acceleration;
	}
	
	public double getVelocity(){
		return this.velocity;
	}
	
	public double getAngle() {
		return this.angle;
	}
	
	public int getTank(){
		return this.tank;
	}
}
