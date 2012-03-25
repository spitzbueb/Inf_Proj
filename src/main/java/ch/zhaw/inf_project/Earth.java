package ch.zhaw.inf_project;

public class Earth {
	
	private double gravitation;
	private double coordinate;
	
	public Earth(){
		this.gravitation = 9.81;
		this.coordinate = 0;
	}
	
	public double getCoordinate(){
		return coordinate;
	}
	
	public double getGravitation(){
		return gravitation;
	}
}
