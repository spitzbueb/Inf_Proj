package ch.zhaw.inf_project;

/**
 * Klasse lässt Route anzeigen
 * 
 * @author Piano Gennaro
 *
 */
public class Route {
	private Earth earth;
	private Satellite satellite;
	private Missile missile;
	
	public Route(Missile missile){
		this.missile = missile;
		this.earth = new Earth();
		this.satellite = new Satellite();
	}
}
