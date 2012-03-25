package ch.zhaw.inf_project;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CirclePanel extends JPanel{
	private Earth earth = new Earth();
	private SatelliteRoute orbit = new SatelliteRoute();
	private Satellite satellite = new Satellite();
	
	public CirclePanel(Earth earth,SatelliteRoute orbit,Satellite satellite)
	{
		this.earth = earth;
		this.orbit = orbit;
		this.satellite = satellite;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.GREEN);
		g.fillOval(earth.getPosx(), earth.getPosy(), earth.getRad(), earth.getRad());
		
		g.setColor(Color.BLACK);
		g.fillOval(satellite.getPosx(), satellite.getPosy(), satellite.getRad(), satellite.getRad());
		g.drawOval(orbit.getPosx(), orbit.getPosy(), orbit.getRad(), orbit.getRad());

	}
}
