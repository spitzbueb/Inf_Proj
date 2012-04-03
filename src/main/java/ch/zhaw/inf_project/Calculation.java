package ch.zhaw.inf_project;

/**
 * Klasse übernimmt die Aufgabe des Rechnens. 
 * Berechnet ...
 * 
 * @author Piano Gennaro
 *
 */

public class Calculation {
	public double[] newCoordinate(double[] satelliteCoordinate, double[] earthCoordinate){
		double res[] = new double[6];
		double[] force = force(satelliteCoordinate, earthCoordinate);
		
		double u[] = new double[3];
		
		double uBetrag;
		
		// Aenderung der Werte durch die Anziehungskraft der Erde
		u[0] = satelliteCoordinate[3] - force[0];
		u[1] = satelliteCoordinate[4] - force[1];
		u[2] = satelliteCoordinate[5] - force[2];
		uBetrag = Math.sqrt(Math.sqrt(u[0]*u[0] +  u[1]*u[1]) + u[2]*u[2]);
		
		//Ableitung des Weges ist die Geschwindigkeit
		res[0] = satelliteCoordinate[3];
		res[1] = satelliteCoordinate[4];
		res[2] = satelliteCoordinate[5];  
		
		// Ableitung der Geschwindigkeit ist die Beschleunigung
		res[3] = u[0]*uBetrag;
		res[4] = u[1]*uBetrag;
		res[5] = u[2]*uBetrag;
		
		return satelliteCoordinate;
	}
	
	
	/**
	 * Berechnet Krafteinwirkung auf ...
	 * 
	 * @param satelliteCoordinate
	 * @param earthCoordinate
	 * @return
	 */
	public double[]  force(double[] satelliteCoordinate, double[] earthCoordinate){
		
		
		return null;
	}
}
