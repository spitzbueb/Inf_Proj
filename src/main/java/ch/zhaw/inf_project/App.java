package ch.zhaw.inf_project;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ch.zhaw.inf_project.Animation;


/**
 * Die Klass App.java hat die Aufgabe das Fenster (GUI) zu zeichnen.
 * Sie ist die Hauptklasse, welche ausgeführt wird.
 * Momentan kann per Leertaste die Animation gestoppt und gestartet werden.
 * App.java ist erweitert mit Frame und implementier Runnable.
 * 
 * @see GUI mit Planet, Satellit und Orbit
 * @author Piano Gennaro
 *
 */
public class App extends Frame implements Runnable
{
	private JFrame frame;
	private Earth earth = new Earth();
	private Satellite satellite = new Satellite();
	private Missile missile = new Missile(0,0);
	private Missile missile2 = new Missile(0,0);
	private Thread animThread;
	private JPanel circlePanel;
	private boolean ready1,ready2 = false;
    
	/**
	 * Klassenkonstruktor:
	 * startet Methode createGUI();
	 */
	public App() {
		createGui();
    }
	
	/**
	 * Zeichnet das Fenster mit allen Inhalten.
	 * Der KeyboardListener wird erstellt.
	 * 
	 * @see Programmfenster wird geöffnet
	 */
	private void createGui(){
		JMenuBar bar = new JMenuBar();
		frame = new JFrame("Informatik Projekt 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setJMenuBar(bar);
		JMenu dateiMenu = new JMenu("Datei");
		JMenu initialMenu = new JMenu("Initialisierung");
		JMenu animationMenu = new JMenu("Animation");
		JMenu hilfeMenu = new JMenu("?");
		bar.add(dateiMenu);
		bar.add(initialMenu);
		bar.add(animationMenu);
		bar.add(hilfeMenu);
		
		JMenuItem schliessen = new JMenuItem("Schliessen");
		dateiMenu.add(schliessen);
		JMenuItem initialMissile = new JMenuItem("Rakete 1 initialisieren");
		initialMenu.add(initialMissile);
		JMenuItem initialMissile2 = new JMenuItem("Rakete 2 initialisieren");
		initialMenu.add(initialMissile2);
		final JMenuItem go = new JMenuItem("Go!");
		final JMenuItem stopp = new JMenuItem("Stopp!");
		JMenuItem reset = new JMenuItem("Reset!");
		animationMenu.add(go);
		go.setEnabled(false);
		animationMenu.add(stopp);
		stopp.setEnabled(false);
		animationMenu.add(reset);
		JMenuItem hilfe = new JMenuItem("Hilfe");
		JMenuItem ueber = new JMenuItem("�ber");
		hilfeMenu.add(hilfe);
		hilfeMenu.add(ueber);
		
		Container contentPane = frame.getContentPane();
		
		circlePanel = new CirclePanel(earth,satellite,missile,missile2);
		contentPane.add(circlePanel);
		
		initialMissile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new initialMissileGUI().createGUI(missile);
				go.setEnabled(true);
				ready1 = true;
			}
			
		});
		
		initialMissile2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new initialMissileGUI().createGUI(missile2);
				go.setEnabled(true);
				ready2 = true;
			}
			
		});
		
		go.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				start();
				go.setEnabled(false);
				stopp.setEnabled(true);
			}

		});
		
		stopp.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stop();
				stopp.setEnabled(false);
			}
			
		});
		
		reset.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Noch keine Methode für Reset!");
			}
			
		});
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		
	}
	
	/**
	 * Startet den Thread für die Animation
	 */
	
	public void start()
	{
		if(animThread == null)
		{
			animThread = new Thread(this);
			animThread.start();
		}
	}
	
	/**
	 * Stoppt den Thread der Animation.
	 */
	
	public void stop()
	{
		if(animThread != null)
		{
			animThread.stop();
			animThread = null;
		}
	}
	
	/**
	 * Standardklasse für Thread. App implementiert Runnable.
	 * Run lässt die Animation durchlaufen (während der momentane Thread
	 * gleich wie "animThread" ist. Dann wird Frame neugezeichnet.
	 */
	public void run()
	{
		while(Thread.currentThread() == animThread)
		{
			if(ready1 == true)
			{
				Animation.moveSatellite(satellite, animThread, earth, missile);
			}
			
			if(ready2 == true)
			{
				Animation.moveMissile2(missile2, earth);
			}
			
			frame.repaint();
		
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new App();
	}
}
