package ch.zhaw.inf_project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * Hello world!
 *
 */
public class App extends Frame
{
	private JFrame frame;
	Circle[] circle = new Circle[3];
    
	public App() {
		createGui();
    }
	
	private void createGui(){
		JMenuBar bar = new JMenuBar();
		frame = new JFrame("Informatik Projekt 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setJMenuBar(bar);
		JMenu dateiMenu = new JMenu("Datei");
		JMenu hilfeMenu = new JMenu("?");
		bar.add(dateiMenu);
		bar.add(hilfeMenu);
		
		JMenuItem schliessen = new JMenuItem("Schliessen");
		dateiMenu.add(schliessen);
		JMenuItem hilfe = new JMenuItem("Hilfe");
		JMenuItem ueber = new JMenuItem("�ber");
		hilfeMenu.add(hilfe);
		hilfeMenu.add(ueber);
		
		Container contentPane = frame.getContentPane();
		
		contentPane.add(new Circle());
		
		frame.setSize(800,800);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new App();
	}
}
