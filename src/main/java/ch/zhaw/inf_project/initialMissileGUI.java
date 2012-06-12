package ch.zhaw.inf_project;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class initialMissileGUI {
	
	private JTextField tankfuellung, abschusswinkel, startzeit, verbrennung ;
	private JFrame frame;

	
	public void createGUI(final Missile missile)
	{
		frame = new JFrame("Rakete initialisieren");
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		
		Container contentpane = frame.getContentPane();
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Tankfuellung angeben:");
		tankfuellung = new JTextField(10);
		JLabel winkel = new JLabel("Abschusswinkel angeben: ");
		abschusswinkel = new JTextField(10);
		JButton accept = new JButton("Initialisiere!");
		JLabel startTime = new JLabel("Startzeit angeben");
		startzeit = new JTextField(10);
		JLabel accelaration = new JLabel("Verbrennung angeben");
		verbrennung = new JTextField(10);
		
		panel.add(label);
		panel.add(tankfuellung);
		panel.add(winkel);
		panel.add(abschusswinkel);
		panel.add(startTime);
		panel.add(startzeit);
		panel.add(accelaration);
		panel.add(verbrennung);
		panel.add(accept);
		
		accept.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				double tank = Double.parseDouble(tankfuellung.getText());
				double winkel = Double.parseDouble(abschusswinkel.getText());
				double zeit = Double.parseDouble(startzeit.getText());
				double burnRate = Double.parseDouble(verbrennung.getText());
				
				missile.setTank(tank);
				missile.setAngle(winkel);
				missile.setStartTime(zeit);
				missile.setBurnRate(burnRate);
				frame.dispose();
				
			}
			
		});
		
		contentpane.add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
}