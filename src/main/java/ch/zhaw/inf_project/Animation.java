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
		
	/**
	 * Methode werden 3 Objekte Ã¼bergeben, und sie setzt die x und y Koordinaten des Satelliten
	 * neu. Dadurch bewegt er sich.
	 * 
	 * @param satellite
	 * @param thread
	 * @param orbit
	 */
	public static void moveSatellite(Thread thread, Earth earth,Missile missile, Missile missile2) {
			Calculation calc = new Calculation();
			
			miAnfang[0] = missile.getPosx();
			miAnfang[1] = missile.getPosy();
			miAnfang[2] = missile.getVx();
			miAnfang[3] = missile.getVy();
			
			double[] yMissile = calc.euler_mis(tAnfang, tAnfang+0.1, miAnfang, 10000, missile);			
			
			missile.setPosx(yMissile[0]);
			missile.setPosy(yMissile[1]);
			missile.setVx(yMissile[2]);
			missile.setVy(yMissile[3]);
			
			tAnfang=tAnfang+0.1;
			
			/*
			 * Zweite Rakete wird erst gestartet, wenn tAnfang die benutzerdefinierte Zeit angibt
			 */
			if (tAnfang >= missile2.getStartTime()){
				missile2.setStateTrue();
			}
			
	}
	
	public static void moveMissile2(Missile missile, Earth earth)
	{
		Calculation calc = new Calculation();
		
		yAnfang[0] = missile.getPosx();
		yAnfang[1] = missile.getPosy();
		yAnfang[2] = missile.getVx();
		yAnfang[3] = missile.getVy();
		
		calc.euler_mis(tAnfang, tAnfang+0.1, yAnfang, 10000, missile);
		
		missile.setPosx(yAnfang[0]);
		missile.setPosy(yAnfang[1]);
		missile.setVx(yAnfang[2]);
		missile.setVy(yAnfang[3]);
	}
}