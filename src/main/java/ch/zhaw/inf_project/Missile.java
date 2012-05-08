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
	private int tank;
	private double posx,posy,vx,vy;
	private double destinationCoordinate;
	private double mass,acceleration,ax,ay,verbrennung,vgas;
	
	
	/**
	 * Konstruktor
	 * Initialisiert Tank
	 * 
	 * @param tank
	 */
	public Missile(int tank){
		this.tank = tank;
		this.mass = 500;
		this.verbrennung = 5;
		this.vgas = 50;
		this.vx = 0;
		this.vy = 0;
		this.posx = 394;
		this.posy = 295;
		this.angle = 10;
	}

	public double getMass()
	{
		return mass;
	}
	public double getVerbrennung()
	{
		return verbrennung;
	}
	
	public double getVgas()
	{
		return vgas;
	}
	
	public void setAx()
	{
		ax = 0;
	}

	public void setAy()
	{
		ay = 0;
	}
	
	public double getAx()
	{
		return ax;
	}
	
	public double getAy()
	{
		return ay;
	}	
	
	/**
	 * Gibt X-Koordinate aus
	 * @return posx
	 */
	public double getPosx()
	{
		return posx;
	}
	
	/** 
	 * Gibt Y-Koordinate aus
	 * @return posy
	 */
	public double getPosy()
	{
		return posy;
	}
	
	/**
	 * Setzt X-Koordinate
	 * @param x
	 */
	public void setPosx(double x)
	{
		this.posx = x;
	}
	
	/**
	 * Setzt Y-Koordinate
	 * @param y
	 */
	public void setPosy(double y)
	{
		this.posy = y;
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
	 * Setzt die Geschwindigkeit in X-Richtung
	 * @param vx
	 */
	public void setVx(double vx)
	{
		this.vx = vx;
	}
	
	/**
	 * Setzt die Geschwindigkeit in Y-Richtung
	 * @param vy
	 */
	public void setVy(double vy)
	{
		this.vy = vy;
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
	 * Gibt Geschwindigkeit in X-Richtung zurück
	 * @return vx
	 */
	public double getVx()
	{
		return vx;
	}
	
	/**
	 * Gibt Geschwindigkeit in Y-Richtung zurück
	 * @return vy
	 */
	public double getVy()
	{
		return vy;
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
	
	/**
	 * Setzt die Füllmenge des Tankes neu
	 * @param x
	 */
	public void setTank(int x)
	{
		this.tank = x;
	}
}
