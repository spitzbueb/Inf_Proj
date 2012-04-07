package ch.zhaw.inf_project;

/**
 * Klasse symbolisiert Satellit
 * 
 * @author Team_1
 *
 */

public class Satellite {
	
	private double coordinate;
	private int posx,posy,posz,rad,mass;
	
	/**
	 * Konstruktor
	 * Initialisiert Koordinaten, Radius
	 */
	
	public Satellite(){
		this.coordinate = 10.1;
		this.posx = 687;
		this.posy = 387;
		this.posz = 0;
		this.rad = 26;
		this.mass = 1000;
	}
	
	/**
	 * Gibt das Gewicht wieder
	 * @return weight
	 */
	public int getMass()
	{
		return mass;
	}
	
	/**
	 * Setzt das Gewicht neu
	 * @param weight
	 */
	public void setMass(int mass)
	{
		this.mass = mass;
	}
	
	/**
	 * Gibt X-Koordinate wieder
	 * @return posx
	 */
	public int getPosx() {
		return posx;
	}

	/**
	 * Setzt X-Koordinate neu
	 * @param posx
	 */
	public void setPosx(int posx) {
		this.posx = posx;
	}

	/**
	 * Gibt Y-Koordinate wieder
	 * @return posy
	 */
	public int getPosy() {
		return posy;
	}

	
	/**
	 * Setzt Y-Koordinate neu
	 * @param posy
	 */
	public void setPosy(int posy) {
		this.posy = posy;
	}

	/**
	 * Gibt Radius wieder
	 * @return rad
	 */
	public int getRad() {
		return rad;
	}

	/**
	 * Setzt Radius neu
	 * @param rad
	 */
	public void setRad(int rad) {
		this.rad = rad;
	}


	/**
	 * Gibt Koordinaten zurück
	 * @return coordinate
	 */
	public double getCoordinate(){
		return this.coordinate;
	}
}
