package ch.zhaw.inf_project;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class initialMissileGUI {
	
	double tank;
	JTextField textfield;
	JFrame frame;
	
	public void initialMissileGUI()
	{
		
	}
	
	public void createGUI(final Missile missile)
	{
		frame = new JFrame("Rakete initialisieren");
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		
		Container contentpane = frame.getContentPane();
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Tankfuellung angeben:");
		textfield = new JTextField(10);
		JButton accept = new JButton("Initialisiere!");
		panel.add(label);
		panel.add(textfield);
		panel.add(accept);
		
		accept.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				missile.setTank(initialTank(textfield.getText()));
				frame.dispose();
			}
			
		});
		
		contentpane.add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public double initialTank(String string)
	{
		return Double.valueOf(string).doubleValue();
	}
}