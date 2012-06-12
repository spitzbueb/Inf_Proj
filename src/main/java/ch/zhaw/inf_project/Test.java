package ch.zhaw.inf_project;

public class Test {	
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
		
		public double[] diff_mis(double[] yAnfang,double t, Earth earth, Missile missile){
			double[] z = new double[yAnfang.length];
			double[] res = new double[yAnfang.length];
			double[] u = new double[2];
			double uBetrag,vBetrag,m,k,mmissile;
			
			m = earth.getMass();	// Masse der Erde
			mmissile = missile.getMass() + missile.getTank();
			for(int i=0;i<yAnfang.length;i++)
				z[i] = yAnfang[i];
			
			u[0] = z[0] - (earth.getPosx() + earth.getRad()/2);
			u[1] = z[1] - (earth.getPosy() + earth.getRad()/2);
			
			uBetrag = Math.sqrt(u[0]*u[0] + u[1]*u[1]);		//Distanz zwischen Rakete und Erde
			vBetrag = Math.sqrt(z[2]*z[2] + z[3]*z[3]);
			
			k = 400;											//Leistungskonstante
			
			//Ableitung von x- und y-Koordinate wird zur Geschwindigkeit
			res[0] = z[2];
			res[1] = z[3];
			
			//System.out.println(missile.getVx() + ", " + missile.getVy());
			//Ableitung von x- und y-Geschwindigkeit wird zur Beschleunigung
				res[2] = - 10*m*(u[0]/Math.pow(uBetrag, 3)) + (((k*missile.getVerbrennung())/mmissile)*(z[2]/vBetrag));
				res[3] = - 10*m*(u[1]/Math.pow(uBetrag, 3)) + (((k*missile.getVerbrennung())/mmissile)*(z[3]/vBetrag));
				missile.setTank(missile.getTank()-(t*missile.getVerbrennung()));
			
			return res;
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
		
		public static void main(String[] args) {
				double[] y = new double[4];
				double[] yA = new double[4];
				y[0] = 590.7212401129811;
				y[1] = 479.1871075488176;
				y[2] = -34.627184494473596;
				y[3] = 56.83603191805843;
				yA[0] = 394;
				yA[1] = 295;
				double[] k;
				Missile missile = new Missile(0, 80);
				Test test = new Test();
				double i = 1;
				/*while (i >= 0.1){
					y = test.euler_mis(i,i-0.1, y, 10000, missile);
					System.out.println(y[0] + " " + y[1]);
					i = i - 0.1;
					System.out.println(missile.getTank());
				}*/
				
				while (i >= 0.1){
					k = test.testAddVector(yA, y);
					k = test.testmulScalarVector(1000, k);
					y = test.y(y,k,missile);
					System.out.println(y[0] + " " + y[1]);
					i = i - 0.1;
				}
		}
		
		public double[] testAddVector(double[] yAnfang, double[] yEnd){
			double[] k = new double[yAnfang.length];
			for (int i = 0;i<yAnfang.length;i++){
				k[i] = yEnd[i] - yAnfang[i];
			}
			return k;
		}
		
		public double[] testmulScalarVector(double h, double[] k){
			for(int i = 0; i<k.length;i++){
				k[i]=k[i]/h;
			}
			
			return k;
		}
		
		public double[] y (double[] y, double[] k, Missile missile){
			double[] res = new double[4];
			res[2] = k[0];
			res[3] = k[1];
			double mmissile = missile.getMass() + missile.getTank();
			double vBetrag = Math.sqrt(res[2] * res[2] + res[3] * res[3]);
			res[0] = k[2]-(((400*missile.getVerbrennung())/mmissile)*(res[2]/vBetrag)) / (-10 * 100000);
			res[1] = k[3]-(((400*missile.getVerbrennung())/mmissile)*(res[3]/vBetrag)) / (-10 * 100000);
			
			return res;
			
		}
		
}
