package ch.zhaw.inf_project;

public class Satellite {
	
	private double coordinate;
	private int posx,posy,posz,rad;
	
	public Satellite(){
		this.coordinate = 10.1;
		this.posx = 687;
		this.posy = 387;
		this.posz = 0;
		this.rad = 26;
	}
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


	
	public double getCoordinate(){
		return this.coordinate;
	}
}
