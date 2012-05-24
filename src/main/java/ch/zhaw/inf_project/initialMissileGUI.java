package ch.zhaw.inf_project;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class initialMissileGUI {
	
	private JTextField tankfuellung;
	private JFrame frame;

	
	public void createGUI(final Missile missile)
	{
		frame = new JFrame("Rakete initialisieren");
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		
		Container contentpane = frame.getContentPane();
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Tankfuellung angeben:");
		tankfuellung = new JTextField(10);
		JButton accept = new JButton("Initialisiere!");
		panel.add(label);
		panel.add(tankfuellung);
		panel.add(accept);
		
		accept.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				double t = Double.parseDouble(tankfuellung.getText());
				
				missile.setTank(t);
				frame.dispose();
				
			}
			
		});
		
		contentpane.add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
}