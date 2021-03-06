package ch.zhaw.inf_project;

/**
 * Klasse übernimmt die Aufgabe des Rechnens. 
 * Berechnet Flugbahn des Satelliten und der Rakete.
 * 
 * @author Piano Gennaro, Philipp Schalcher
 *
 */

public class Calculation {
	
	/**
	 * Ableitung des aktuellen Raketen-Vektors
	 * @param yAnfang
	 * @param earth
	 * @return res
	 */
//-------------------------------------------------------------------------
	public double[] diff_mis(double[] yAnfang,double t, Earth earth, Missile missile){
		double[] z = new double[yAnfang.length];
		double[] res = new double[yAnfang.length];
		double[] u = new double[2];
		double uBetrag,vBetrag,m,k,mmissile;
		int g = earth.getG();
		
		m = earth.getMass();	// Masse der Erde
		mmissile = missile.getMass() + missile.getTank();
		for(int i=0;i<yAnfang.length;i++)
			z[i] = yAnfang[i];
		
		u[0] = z[0] - (earth.getMiddlePoint()[0]);
		u[1] = z[1] - (earth.getMiddlePoint()[1]);
		
		uBetrag = Math.sqrt(u[0]*u[0] + u[1]*u[1]);		//Distanz zwischen Rakete und Erde
		vBetrag = Math.sqrt(z[2]*z[2] + z[3]*z[3]);
		
		k = 400;											//Leistungskonstante
		
		//Ableitung von x- und y-Koordinate wird zur Geschwindigkeit
		res[0] = z[2];
		res[1] = z[3];
		
		//Ableitung von x- und y-Geschwindigkeit wird zur Beschleunigung
		if (missile.getTank() > 0.00000)	{
			if (missile.getTank() < missile.getVerbrennung()){
				k = k / missile.getVerbrennung() * missile.getTank();
			}
			res[2] = -g*m*(u[0]/Math.pow(uBetrag, 3)) + (((k*missile.getVerbrennung())/mmissile)*(z[2]/vBetrag));
			res[3] = -g*m*(u[1]/Math.pow(uBetrag, 3)) + (((k*missile.getVerbrennung())/mmissile)*(z[3]/vBetrag));
			missile.setTank(missile.getTank()-(t*missile.getVerbrennung()));
		}
		else {
			res[2] = -g*m*(u[0]/Math.pow(uBetrag, 3));
			res[3] = -g*m*(u[1]/Math.pow(uBetrag, 3));
		}
		
		return res;
	}
//-------------------------------------------------------------------------
	/**
	 * Polygon-Integration nach Euler zwischen tAnfang und tEnde mit einer
	 * Aufteilung nach n. tEnde ist momentan immer tAnfang + 0.1
	 * @param tAnfang
	 * @param tEnde
	 * @param yAnfang
	 * @param n
	 * @return
	 */
	public double[] euler_mis(double tAnfang,double tEnde,double[] yAnfang, int n,Missile missile){
		double h = (tEnde-tAnfang)/n;	//korrektes h für Unterschiede berechnen
		
		double[] y = yAnfang;
		double[] k;
		double t = tAnfang;
		
		for(int i=1;i<=n;i++){
			k = diff_mis(y,h,new Earth(),missile); //Ableitung des momentanen Vektors
			
			y = addVector(y,multScalarVector(h,k));	//neuer Vektor berechnen
			t = t+h;
		}
		
		return y;
	}
	
//------------------------------------------------------------------------------
	public double[] multScalarVector(double h, double[] k){
		for(int i = 0; i<k.length;i++){
			k[i]=h*k[i];
		}
		
		return k;
	}
//------------------------------------------------------------------------
	public double[] addVector(double[] y, double[] k){
		for(int i = 0;i<y.length;i++){
			y[i] = y[i] + k[i];
		}
		return y;
	}
}
