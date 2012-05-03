package ch.zhaw.inf_project;

/**
 * Klasse übernimmt die Aufgabe des Rechnens. 
 * Berechnet Flugbahn des Satelliten und der Rakete.
 * 
 * @author Piano Gennaro
 *
 */

public class Calculation {
	//-----------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Die Methode diff_sat errechnet aus der gegebenen Position
	 * die Ableitung. Aus der Ableitung von z können wir dann die aktuelle Geschwindigkeit
	 * und die Beschleunigung ausrechnen. Zurück wird ein Vektor gegeben, welcher die Geschwindigkeit
	 * und die Beschleunigung enthält.
	 * @param t
	 * @param z
	 * @param earth
	 * @param satellite
	 * @return res
	 */
	public double[] diff_sat(double t, double[] z, Earth earth)
	{
		// Eingabevektor für Ausgangsgrössen
		// z[0] = x-Wert der Position
		// z[1] = y-Wert der Position
		// z[2] = Wert der Geschwindigkeit in x-Richtung
		// z[3] = Wert der Geschwindigkeit in y-Richtung
		
		// res = Resultat der Ableitung der Eingabevektoren
		double[] res = new double[4];
		
		// Systemgrössen
		double g = 1;
		double m = 100000;
		
		double[] u = new double[2];
		double uBetrag;
		
		// Berechnung der Distanz zwischen Satellit und Erde
		u[0] = z[0] - earth.getPosx();
		u[1] = z[1] - earth.getPosy();
		uBetrag = Math.sqrt(u[0]*u[0] + u[1]*u[1]);
		
		// Ableiten des Eingabevektors. Da die Positionen x und y bei der Ableitung zur Geschwindigkeit 
		// werden, können wir sie direkt übertragen!
		
		res[0] = z[2];
		res[0] = z[3];
		
		// Die Beschleunigung wird durch -g * m * (u/uBetrag^3) berechnet.
		res[2] = -g * m * (u[0]/Math.pow(uBetrag, 3));
		res[3] = -g * m * (u[1]/Math.pow(uBetrag, 3));
		
		return res;
	}
	//--------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Die Methode euler nähert die Flugbahn des Satelliten durch ein Polygon an.
	 * @param tAnfang
	 * @param tEnde
	 * @param yAnfang
	 * @param h
	 * @return coordinates
	 */
	public double[]  euler(double tAnfang, double tEnde, double[] yAnfang, int n, Earth earth)
	{
		double[] y = yAnfang;
		double k[];
		double t = tAnfang;
		double h;
		
		int i

		h = (tEnde - tAnfang)/n;
		
		for(i =1;i<n;i++)
		{
			k = diff_sat(t,y,earth);
			for (int m=0;m<k.length;m++)
			{
				k = diff_sat(t,yAnfang,earth);
				y = y + h*k;  //Bearbeiten für Vectoraddition
				t = t + h;
			}
		
		return y;
	}
}
;