package ch.zhaw.inf_project;

/**
 * Klasse symbolisiert Satellit
 * 
 * @author Team_1
 *
 */

public class Satellite {
	
	private double posx,posy,posz,rad,mass,vx,vy,vz;
	
	/**
	 * Konstruktor
	 * Initialisiert Koordinaten, Radius
	 */
	
	public Satellite(){
		this.posx = 887;
		this.posy = 387;
		this.posz = 0;
		this.vx = 0;
		this.vy = 35;
		this.vz = 0;
		this.rad = 26;
		this.mass = 500;
	}
	
	/**
	 * Gibt Geschwindigkeit in X-Richtung wieder
	 * @return vx
	 */
	public double getVx() {
		return vx;
	}

	/**
	 * Setzt X-Geschwindigkeit neu
	 * @param vx
	 */
	public void setVx(double vx) {
		this.vx = vx;
	}

	/**
	 * Gibt Geschwindigkeit in Y-Richtung wieder
	 * @return vy
	 */
	public double getVy() {
		return vy;
	}

	/**
	 * Setzt Y-Geschwindigkeit neu
	 * @param vy
	 */
	public void setVy(double vy) {
		this.vy = vy;
	}

	/**
	 * Gibt Geschwindigkeit in Z-Richtung wieder
	 * @return vz
	 */
	public double getVz() {
		return vz;
	}

	/**
	 * Setzt Z-Geschwindigkeit neu
	 * @param vz
	 */
	public void setVz(double vz) {
		this.vz = vz;
	}

	/**
	 * Gibt das Gewicht wieder
	 * @return weight
	 */
	public double getMass()
	{
		return mass;
	}
	
	/**
	 * Setzt das Gewicht neu
	 * @param weight
	 */
	public void setMass(double mass)
	{
		this.mass = mass;
	}
	
	/**
	 * Gibt X-Koordinate wieder
	 * @return posx
	 */
	public double getPosx() {
		return posx;
	}

	/**
	 * Setzt X-Koordinate neu
	 * @param posx
	 */
	public void setPosx(double posx) {
		this.posx = posx;
	}

	/**
	 * Gibt Y-Koordinate wieder
	 * @return posy
	 */
	public double getPosy() {
		return posy;
	}

	
	/**
	 * Setzt Y-Koordinate neu
	 * @param posy
	 */
	public void setPosy(double posy) {
		this.posy = posy;
	}

	/**
	 * Gibt Radius wieder
	 * @return rad
	 */
	public double getRad() {
		return rad;
	}

	/**
	 * Setzt Radius neu
	 * @param rad
	 */
	public void setRad(double rad) {
		this.rad = rad;
	}
}
