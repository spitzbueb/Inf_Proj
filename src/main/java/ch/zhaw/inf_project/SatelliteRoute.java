package ch.zhaw.inf_project;

public class SatelliteRoute {
	private int posx,posy,radx,rady;
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
	
	public int getRady() {
		return rady;
	}

	public void setRady(int rady) {
		this.rady = rady;
	}
	
	public int getRadx() {
		return radx;
	}

	public void setRadx(int radx) {
		this.radx = radx;
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
		this.posy = 200;
		this.radx = 600;
		this.rady = 400; 	
	}
}
