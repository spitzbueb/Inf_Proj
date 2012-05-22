package ch.zhaw.inf_project;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Klasse zeichnet die drei Kreise (Erde, Satellit und Orbit) in ein Frame.
 * 
 * @author Schalcher Philipp
 *
 */

public class CirclePanel extends JPanel{
	private Earth earth = new Earth();
	private Orbit orbit = new Orbit();
	private Satellite satellite = new Satellite();
	private Missile missile;
	
	/**
	 * Standard-Konstruktor
	 * earth, orbit und satellite werden initialisiert.
	 * 
	 * @param earth
	 * @param orbit
	 * @param satellite
	 */
	public CirclePanel(Earth earth,Orbit orbit,Satellite satellite,Missile missile)
	{
		this.earth = earth;
		this.satellite = satellite;
		this.missile = missile;
		
	}
	
	/**
	 * Methode zeichnet die drei Kreise.
	 */
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.GREEN);
		g.fillOval(earth.getPosx(), earth.getPosy(), earth.getRad(), earth.getRad());
		
		g.setColor(Color.BLACK);
		g.fillOval((int) satellite.getPosx(),(int) satellite.getPosy(),(int) satellite.getRad(),(int) satellite.getRad());
		g.fillRect((int)Math.round(missile.getPosx()), (int)Math.round(missile.getPosy()),6,10);
		
	}
}
