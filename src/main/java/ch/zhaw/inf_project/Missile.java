package ch.zhaw.inf_project;

/**
 * Klasse symbolisiert Rakete
 * 
 * @author Piano Gennaro
 *
 */
public class Missile {
	
	private double angle;
	private double velocity;
	private double acceleration;
	private int tank;
	private double startCoordinate;
	private double destinationCoordinate;
	
	
	/**
	 * Konstruktor
	 * Initialisiert Tank
	 * 
	 * @param tank
	 */
	public Missile(int tank){
		this.tank = tank;
	}
	
	/**
	 * Setzt Start-Koordinaten
	 * 
	 * @param startCoordinate
	 */
	public void setStartCoordinate(double startCoordinate){
		this.startCoordinate = startCoordinate;
	}
	
	/**
	 * Setzt Ziel-Koordinaten
	 * 
	 * @param destinationCoordinate
	 */
	public void setDestinationCoordinate(double destinationCoordinate){
		this.destinationCoordinate = destinationCoordinate;
	}
	
	/**
	 * Setzt Beschleunigung
	 * 
	 * @param acceleration
	 */
	public void setAcceleration(double acceleration){
		this.acceleration = acceleration;
	}
	
	/**
	 *  Setzt ???
	 * 
	 * @param velocity
	 */
	public void setVelocity(double velocity){
		this.velocity = velocity;
	}
	
	
	/**
	 * Setzt Abschusswinkel
	 * 
	 * @param angle
	 */
	public void setAngle(double angle){
		this.angle = angle;
	}
	
	/**
	 * Gibt Beschleunigung zurück
	 * @return acceleration
	 */
	public double getAcceleration(){
		return this.acceleration;
	}
	
	/**
	 * Gibt ??? zurück
	 * @return velocity
	 */
	public double getVelocity(){
		return this.velocity;
	}
	
	/**
	 * Gibt Abschusswinkel zurück
	 * @return angle
	 */
	public double getAngle() {
		return this.angle;
	}
	
	/**
	 * Gibt Tankinhalt zurück
	 * @return tank
	 */
	public int getTank(){
		return this.tank;
	}
}
