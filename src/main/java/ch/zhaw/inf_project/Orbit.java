package ch.zhaw.inf_project;

/**
 * Klasse symbolisiert den Orbit des Satelliten
 * 
 * @author Team 1
 *
 */

public class Orbit {
	private int posx,posy,radx,rady;
	
	/**
	 * Gibt X-Koordinate zurück
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
	 * gibt Y-Koordinate zurück
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
	 * Gibt Radius in Y-Richtung zurück
	 * @return rady
	 */
	public int getRady() {
		return rady;
	}

	/**
	 * Setzt den Radius in Y-Richtung neu
	 * @param rady
	 */
	public void setRady(int rady) {
		this.rady = rady;
	}
	
	/**
	 * Gibt den Radius in X-Richtung zurück
	 * @return radx
	 */
	public int getRadx() {
		return radx;
	}

	/**
	 * Setzt den Radius in X-Richtung neu
	 * @param radx
	 */
	public void setRadx(int radx) {
		this.radx = radx;
	}

	/**
	 * Gibt Farbe zurück
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Setzt Farbe neu
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	private String color = "black";
	
	/**
	 * Konstruktor
	 * Initialisiert Variablen
	 */
	public Orbit()
	{
		this.posx = 100;
		this.posy = 200;
		this.radx = 600;
		this.rady = 400; 	
	}
}
