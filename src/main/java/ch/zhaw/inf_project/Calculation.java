package ch.zhaw.inf_project;

/**
 * Klasse übernimmt die Aufgabe des Rechnens. 
 * Berechnet Flugbahn des Satelliten und der Rakete.
 * 
 * @author Piano Gennaro
 *
 */

public class Calculation {
	public double[] diff_sat(double[] yAnfang, Earth earth)
	{
		double[] z = new double[yAnfang.length];
		double[] res = new double[yAnfang.length];
		double[] u = new double[2];
		double uBetrag,g,m;
		
		g = 10;
		m = earth.getMass();
		
		for(int i=0;i<yAnfang.length;i++)
			z[i] = yAnfang[i];
		
		u[0] = z[0] - earth.getPosx();
		u[1] = z[1] - earth.getPosy();
		
		uBetrag = Math.sqrt(u[0]*u[0] + u[1]*u[1]);
		
		res[0] = z[2];
		res[1] = z[3];
		
		res[2] = -g * m * (u[0]/Math.pow(uBetrag, 3));
		res[3] = -g * m * (u[1]/Math.pow(uBetrag, 3));
		
		return res;
	}
//-------------------------------------------------------------------------
	public double[] euler(double tAnfang,double tEnde,double[] yAnfang, int n)
	{
		double h = (tEnde-tAnfang)/n;
		
		double[] y = yAnfang;
		double[] k;
		double t = tAnfang;
		
		for(int i=1;i<=n;i++)
		{
			k = diff_sat(y,new Earth());
			
			y = addVector(y,multScalarVector(h,k));
			t = t+h;
		}
		
		return y;
	}
//------------------------------------------------------------------------------
	public double[] multScalarVector(double h, double[] k)
	{
		for(int i = 0; i<k.length;i++)
		{
			k[i]=h*k[i];
		}
		
		return k;
	}
//------------------------------------------------------------------------
	public double[] addVector(double[] y, double[] k)
	{
		for(int i = 0;i<y.length;i++)
		{
			y[i] = y[i] + k[i];
		}
		return y;
	}
}
