package ch.zhaw.inf_project;

/**
 * Klasse übernimmt die Aufgabe des Rechnens. 
 * Berechnet Flugbahn des Satelliten und der Rakete.
 * 
 * @author Piano Gennaro, Philipp Schalcher
 *
 */

public class Calculation {
	
	private double g = 10;
	/**
	 * Ableitung des aktuellen Satelliten-Vektors
	 * @param yAnfang
	 * @param earth
	 * @return res
	 */
	public double[] diff_sat(double[] yAnfang, Earth earth){
		double[] z = new double[yAnfang.length];
		double[] res = new double[yAnfang.length];
		double[] u = new double[2];
		double uBetrag,m;
	
		m = earth.getMass();	// Masse der Erde
		
		for(int i=0;i<yAnfang.length;i++)
			z[i] = yAnfang[i];
		
		u[0] = z[0] - (earth.getPosx() + earth.getRad()/2);
		u[1] = z[1] - (earth.getPosy() + earth.getRad()/2);
		
		uBetrag = Math.sqrt(u[0]*u[0] + u[1]*u[1]);		//Distanz zwischen Satellit und Erde
		
		//Ableitung von x- und y-Koordinate wird zur Geschwindigkeit
		res[0] = z[2];
		res[1] = z[3];
		
		//Ableitung von x- und y-Geschwindigkeit wird zur Beschleunigung
		res[2] = -g * m * (u[0]/Math.pow(uBetrag, 3));
		res[3] = -g * m * (u[1]/Math.pow(uBetrag, 3));
		
		return res;
	}
//-------------------------------------------------------------------------
	public double[] diff_mis(double[] yAnfang,double t, Earth earth, Missile missile){
		double[] z = new double[yAnfang.length];
		double[] res = new double[yAnfang.length];
		double[] u = new double[2];
		double uBetrag,vBetrag,m,k,mmissile;
		
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
		
		//System.out.println(missile.getVx() + ", " + missile.getVy());
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
	public double[] euler_sat(double tAnfang,double tEnde,double[] yAnfang, int n){
		double h = (tEnde-tAnfang)/n;	//korrektes h für Unterschiede berechnen
		
		double[] y = yAnfang;
		double[] k;
		double t = tAnfang;
		
		for(int i=1;i<=n;i++){
			k = diff_sat(y,new Earth()); //Ableitung des momentanen Vektors
			
			y = addVector(y,multScalarVector(h,k));	//neuer Vektor berechnen
			t = t+h;
		}
		
		return y;
	}
//------------------------------------------------------------------------------
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
	
	public boolean newton(double winkel, double tank, double zeit, double verbrennung, Missile missile1, Missile missile2){
		double[] m1 = new double[4];
		double[] m2 = new double[4];
		double[] parameter = new double[4];
		double[][] jacobi = new double[4][4];
		parameter[0] = winkel;
		parameter[1] = tank;
		parameter[2] = zeit;
		parameter[3] = verbrennung;
		double h = 0.1;
		m1[0] = missile1.getInitalValuex();
		m1[1] = missile1.getInitialValuey();
		m1[2] = missile1.getInitialVx();
		m1[3] = missile1.getInitialVy();
		m2[0] = m1[0];
		m2[1] = m1[1];
		m2[2] = missile2.getVx();
		m2[3] = missile2.getVy();
	
		double endzeit1 = zeit + 30;
		double[] y1 = euler_mis(0, endzeit1, m1, 10000, missile1);
		double[] y2 = euler_mis(zeit, endzeit1, m2, 10000, missile2);
		final double DELTA = 1E-7;
	/*	for (int i=0;i<4;i++){
			System.out.println(y1[i] + " " + y2[i]);
		}*/
		if (y1[0] - y2[0] < DELTA && y1[1] - y2[1] < DELTA && y1[2] - y2[2] < DELTA && y1[3] - y2[3] < DELTA){
			return true;
		}
		else {
			for (int i=0;i<y2.length;i++){
				Missile missileTest = new Missile(winkel, tank);
				double[] value = parameter;			// Die vier Parameter (Winkel, Tank, Startzeit und Verbrennung werden in eine temp Variable geschrieben
				double[] m3 = new double[4];
				value[i%4] = parameter[i%4] + h;
				missileTest.setAngle(value[0]);
				missileTest.setTank(value[1]);
				missileTest.setStartTime(value[2]);
				missileTest.setBurnRate(value[3]);
				m3[0] = missileTest.getInitalValuex();
				m3[1] = missileTest.getInitialValuey();
				m3[2] = missileTest.getInitialVx();
				m3[3] = missileTest.getInitialVy();
				double[]res = euler_mis(value[2], endzeit1, m3, 10000, missileTest);
				for (int j = 0;j<y2.length;j++){
					jacobi[i][j] = (res[j] - y2[j])/h;
				}
			}
			gaussSeidel(jacobi, y2);
			return false;
		}
		
	}
	
	public double[][] gaussSeidel(double[][] a, double[] yAnfang){
		double[] b = yAnfang.clone();
		for (int i = 0;i<yAnfang.length; i++){
			b[i] = -b[i];
		}
		for (int i=0;i<yAnfang.length; i++){
			for (int j=0;j<yAnfang.length; j++){
				if (i > j){
					double x = a[i][j] / a[j][j];
					a[i][j] = a[i][j] - x * a[j][j];
					b[i] = b[i] - x * b[j];
					for (int k=j+1;k<yAnfang.length; k++){
						a[i][k] = a[i][k] - x * a[j][k];
					}
				}
			}
		}
		return null;
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
