package ch.zhaw.inf_project;

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
