package ch.zhaw.inf_project;

public class Earth {
	
	private double gravitation;
	private double coordinate;
	private int posx,posy,rad;
	private String color = "green";
	
	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Earth(){
		this.gravitation = 9.81;
		this.coordinate = 0;
		this.posx=300;
		this.posy=300;
		this.rad=200;
	}
	
	public double getCoordinate(){
		return coordinate;
	}
	
	public double getGravitation(){
		return gravitation;
	}
}
