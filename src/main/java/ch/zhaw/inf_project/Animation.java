package ch.zhaw.inf_project;

/**
 * Die Klasse Animation übernimmt das setzen der neuen 
 * Positionen des Satelliten.
 * 
 * @author Schalcher Philipp
 *
 */


public class Animation
{
	static double c = 0.05;
	static int t = 1;
	
	/**
	 * Standard Konstruktor
	 */
	public Animation()
	{

	}
	
	/**
	 * Methode werden 3 Objekte übergeben, und sie setzt die x und y Koordinaten des Satelliten
	 * neu. Dadurch bewegt er sich.
	 * 
	 * @param satellite
	 * @param thread
	 * @param orbit
	 */
	public static void moveSatellite(Satellite satellite, Thread thread, Orbit orbit) 
	{
			satellite.setPosx(400 + ((int)((orbit.getRadx()/2) * Math.sin(c * t))));
			satellite.setPosy(400 + ((int)((orbit.getRady()/2) * Math.cos(c * t))));
			t++;
	}
	
}