package ch.zhaw.inf_project;

public class SatelliteRoute {
	private int posx,posy,rad;
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

	private String color = "black";
	
	public SatelliteRoute()
	{
		this.posx = 100;
		this.posy = 100;
		this.rad = 600;
	}
}
