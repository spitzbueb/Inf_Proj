package ch.zhaw.inf_project;


public class Animation
{
	static double c = 0.05;
	static int t = 1;
	
	public Animation()
	{

	}
	
	public static void moveSatellite(Satellite satellite, Thread thread, SatelliteRoute orbit) 
	{
			satellite.setPosx(400 + ((int)((orbit.getRadx()/2) * Math.sin(c * t))));
			satellite.setPosy(400 + ((int)((orbit.getRady()/2) * Math.cos(c * t))));
			t++;
	}
	
}