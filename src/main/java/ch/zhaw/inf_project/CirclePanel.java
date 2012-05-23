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
	private Satellite satellite = new Satellite();
	private Missile missile,missile2;
	
	/**
	 * Standard-Konstruktor
	 * earth, orbit und satellite werden initialisiert.
	 * 
	 * @param earth
	 * @param orbit
	 * @param satellite
	 */
	public CirclePanel(Earth earth,Satellite satellite,Missile missile, Missile missile2){
		this.earth = earth;
		this.satellite = satellite;
		this.missile = missile;
		this.missile2 = missile2;
		
	}
	
	/**
	 * Methode zeichnet die drei Kreise.
	 */
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.GREEN);
		g.fillOval(earth.getPosx(), earth.getPosy(), earth.getRad(), earth.getRad());
		
		g.setColor(Color.BLACK);
		//g.fillOval((int) satellite.getPosx(),(int) satellite.getPosy(),(int) satellite.getRad(),(int) satellite.getRad());
		g.fillRect((int)Math.round(missile.getPosx()), (int)Math.round(missile.getPosy()),6,10);
		g.fillRect((int)Math.round(missile2.getPosx()), (int)Math.round(missile2.getPosy()),6,10);
	}
}
