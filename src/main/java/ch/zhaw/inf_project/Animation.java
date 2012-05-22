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
	private static double[] yAnfang = new double[4];
	private static double[] miAnfang = new double[4];
	private static double tAnfang = 0;
	private int n = 10;
		
	/**
	 * Methode werden 3 Objekte übergeben, und sie setzt die x und y Koordinaten des Satelliten
	 * neu. Dadurch bewegt er sich.
	 * 
	 * @param satellite
	 * @param thread
	 * @param orbit
	 */
	public static void moveSatellite(Satellite satellite, Thread thread, Earth earth,Missile missile) {
			Calculation calc = new Calculation();
			
			yAnfang[0] = satellite.getPosx();
			yAnfang[1] = satellite.getPosy();
			yAnfang[2] = satellite.getVx();
			yAnfang[3] = satellite.getVy();
			
			miAnfang[0] = missile.getPosx();
			miAnfang[1] = missile.getPosy();
			miAnfang[2] = missile.getVx();
			miAnfang[3] = missile.getVy();
			
			double[] y = calc.euler_sat(tAnfang, tAnfang+0.1, yAnfang, 10000);
			double[] yMissile = calc.euler_mis(tAnfang, tAnfang+0.1, miAnfang, 10000, missile);
			
			satellite.setPosx(y[0]);
			satellite.setPosy(y[1]);
			satellite.setVx(y[2]);
			satellite.setVy(y[3]);
			
			missile.setPosx(yMissile[0]);
			missile.setPosy(yMissile[1]);
			missile.setVx(yMissile[2]);
			missile.setVy(yMissile[3]);
			
			tAnfang=tAnfang+0.1;
	}
}