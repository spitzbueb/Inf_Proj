package ch.zhaw.inf_project;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CalculationTest extends TestCase{
	
	public CalculationTest()
	{
		super("Calculation Test");
	}

    /**
     * Testet die Euler-Integration für n = 2 mit der Rakete.
     */
	public void testMissile()
    {
    	Missile missile = new Missile(0.5,10);
    	Calculation calc = new Calculation();
    	double[] yAnfang = new double[4];
    	double[] res = new double[4];
    	double[] yEnde = new double[4];
    	
    	res[0] = 392.8687136380141;
    	res[1] = 294.464171424903;
    	res[2] = -20.127121161537232;
    	res[3] = -5.0921676793496005;

    	
    	yAnfang[0] = missile.getPosx();
    	yAnfang[1] = missile.getPosy();
    	yAnfang[2] = missile.getVx();
    	yAnfang[3] = missile.getVy();
    	
    	yEnde = calc.euler_mis(0, 0.1, yAnfang, 2, missile);
    	
    	for(int i=0;i<res.length;i++)
    	{
    		//assertTrue(res[i]==yEnde[i]);
    	}
    }
	
	/**
	 * Testet die Berechnung des Satelliten
	 */
	public void testSatellite()
	{
    	//Satellite satellite = new Satellite();
    	Calculation calc = new Calculation();
    	double[] yAnfang = new double[4];
    	double[] res = new double[4];
    	double[] yEnde = new double[4];
    	
    	res[0] = 686.9844975429897;
    	res[1] = 390.49651495152483;
    	res[2] = -0.6191913760762495;
    	res[3] = 34.859404008704374;

    	
    /*	yAnfang[0] = satellite.getPosx();
    	yAnfang[1] = satellite.getPosy();
    	yAnfang[2] = satellite.getVx();
    	yAnfang[3] = satellite.getVy();*/
    	
    	//yEnde = calc.euler_sat(0, 0.1, yAnfang, 2);
    	
    	for(int i=0;i<res.length;i++)
    	{
    		//assertTrue(res[i]==yEnde[i]);
    	}
	}
}
