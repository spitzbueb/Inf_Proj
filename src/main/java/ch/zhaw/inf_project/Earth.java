package ch.zhaw.inf_project;

/**
 * Klasse symbolisiert die Erde
 * 
 * @author Piano Gennaro
 *
 */
public class Earth {
	
	private double gravitation;
	private double coordinate;
	private int posx,posy,rad,mass;
	
	/**
	 * Gibt Masse der Erde zurück
	 * @return mass
	 */
	public int getMass() {
		return mass;
	}

	/**
	 * Setzt die masse der Erde neu
	 * @param mass
	 */
	public void setMass(int mass) {
		this.mass = mass;
	}

	private String color = "green";
	
	/**
	 * Gibt X-Koordinate wieder
	 * @return posx
	 */
	public int getPosx() {
		return posx;
	}

	/**
	 * Setzt X-Koordinate
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
	 * Setzt Y-Koordinate
	 * @param posy
	 */
	public void setPosy(int posy) {
		this.posy = posy;
	}

	/**
	 * Gibt den Radius wieder
	 * @return rad
	 */
	public int getRad() {
		return rad;
	}

	/**
	 * Setzt den Radius
	 * @param rad
	 */
	public void setRad(int rad) {
		this.rad = rad;
	}

	/**
	 * Gibt die Farbe zurück
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Setzt die Farbe neu
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Standard-Konstruktor
	 * Setzt graviation, coordinate und radius
	 */
	public Earth(){
		this.gravitation = 9.81;
		this.coordinate = 0;
		this.posx=300;
		this.posy=300;
		this.rad=200;
		this.mass = 1000000;
	}
	
	/**
	 * Gibt Koordinate zurück
	 * @return coordinate
	 */
	public double getCoordinate(){
		return coordinate;
	}
	
	/**
	 * Gibt Gravitation zurück
	 * @return gravitation
	 */
	public double getGravitation(){
		return gravitation;
	}
	
}
