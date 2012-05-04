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
	static double[] yAnfang = new double[4];
	static double tAnfang = 0;
	int n = 10;
	
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
	public static void moveSatellite(Satellite satellite, Thread thread, Orbit orbit, Earth earth) 
	{
			Calculation calc = new Calculation();
			
			yAnfang[0] = satellite.getPosx();
			yAnfang[1] = satellite.getPosy();
			yAnfang[2] = satellite.getVx();
			yAnfang[3] = satellite.getVy();
			
			double[] y = calc.euler(tAnfang, tAnfang+0.05, yAnfang, 100000);
			
			satellite.setPosx(y[0]);
			satellite.setPosy(y[1]);
			satellite.setVx(y[2]);
			satellite.setVy(y[3]);
			
			tAnfang=tAnfang+0.05;
			
			//satellite.setPosx(400 + (((orbit.getRadx()/2) * Math.sin(c * t))));
			//satellite.setPosy(400 + (((orbit.getRady()/2) * Math.cos(c * t))));
			//t++;
	}
}