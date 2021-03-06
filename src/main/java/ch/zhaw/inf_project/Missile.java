package ch.zhaw.inf_project;

/**
 * Klasse symbolisiert Rakete
 * 
 * @author Piano Gennaro
 *
 */
public class Missile {
	
	private double angle;
	private double tank;
	private double posx,posy,vx,vy;;
	private double mass,verbrennung;
	private boolean state;
	private double acceleration;
	private double initialValuex, initialValuey, initialVx, initialVy;
	private double startTime;
	
	
	/**
	 * Konstruktor
	 * Initialisiert Tank
	 * 
	 * @param tank
	 */
	public Missile(double tank, double angle){
		this.tank = tank;
		this.mass = 500;
		this.verbrennung = 7;
		this.posx = 394;
		this.posy = 295;
		this.state = false;
		this.initialValuex = posx;
		this.initialValuey = posy;
	}

	public double getMass()
	{
		return mass;
	}
	public double getVerbrennung()
	{
		return verbrennung;
	}
	
	public boolean getState(){
		return state;
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
	public double getPosy(){
		return posy;
	}
	
	public void setStateTrue(){
		state = true;
	}
	
	public double getStartTime(){
		return startTime;
	}
	/**
	 * Setzt X-Koordinate
	 * @param x
	 */
	public void setPosx(double x)
	{
		this.posx = x;
	}
	
	public void setBurnRate(double burnRate){
		this.verbrennung = burnRate;
	}
	
	public void setStartTime(double startTime){
		this.startTime = startTime;
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
	 * Setzt Abschusswinkel
	 * 
	 * @param angle
	 */
	public void setAngle(double angle){
		this.angle = angle;
		this.vx = -100 * Math.cos(Math.toRadians(180+angle));
		this.vy = 100 * Math.sin(Math.toRadians(180+angle));
		this.initialVx = vx;
		this.initialVy = vy;
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
	public double getTank(){
		return this.tank;
	}
	
	/**
	 * Setzt die Füllmenge des Tankes neu
	 * @param d
	 */
	public void setTank(double d)
	{
		this.tank = d;
	}
	
	public double getAccelarationTime(){
		return acceleration;
	}
	
	public void setAccelerationTime(double t){
		this.acceleration = t;
	}
	
	public double getInitalValuex(){
		return initialValuex;
	}
	
	public double getInitialValuey(){
		return initialValuey;
	}
	public double getInitialVx(){
		return initialVx;
	}
	
	public double getInitialVy(){
		return initialVy;
	}
	
}
