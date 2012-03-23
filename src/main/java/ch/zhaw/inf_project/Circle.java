package ch.zhaw.inf_project;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Circle extends JPanel{
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		paintEarth(g);
		paintOrbit(g);
		paintSatellite(g);
	}
	
	public void paintEarth(Graphics g)
	{
		g.setColor(Color.green);
		g.fillOval(300,300,200,200);
	}
	
	public void paintSatellite(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(687, 387, 26, 26);
	}
	
	public void paintOrbit(Graphics g)
	{
		g.setColor(Color.black);
		g.drawOval(100,100,600,600);
	}
}
