package ch.zhaw.inf_project;

import junit.framework.TestCase;

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
    	Missile missile = new Missile(45,45);
    	missile.setAngle(45);
    	Calculation calc = new Calculation();
    	double[] yAnfang = new double[4];
    	double[] res = new double[4];
    	double[] yEnde = new double[4];
    	
    	res[0] = 401.10463102286235;
    	res[1] = 288.3448599589526;
    	res[2] = 71.2869408336486;
    	res[3] = -62.55484423893567;

    	
    	yAnfang[0] = missile.getPosx();
    	yAnfang[1] = missile.getPosy();
    	yAnfang[2] = missile.getVx();
    	yAnfang[3] = missile.getVy();
    	
    	yEnde = calc.euler_mis(0, 0.1, yAnfang, 10000, missile);
    	
    	for(int i=0;i<res.length;i++){
    		assertTrue(res[i]==yEnde[i]);
    	}
    }
}
