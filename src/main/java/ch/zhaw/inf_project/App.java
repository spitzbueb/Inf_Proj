package ch.zhaw.inf_project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

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
	private Orbit orbit = new Orbit();
	private Satellite satellite = new Satellite();
	Thread animThread;
	boolean animation = false;
    
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
		
		JPanel circlePanel = new CirclePanel(earth,orbit,satellite);
		contentPane.add(circlePanel);
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher()
		{

			@Override
			public boolean dispatchKeyEvent(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getID() == KeyEvent.KEY_PRESSED)
				{
					handleKeyPress(arg0.getKeyCode());
					return true;
				}
				
				return false;
			}
			
		});
		
		frame.setSize(800,800);
		frame.setVisible(true);
		
	}
	
	/**
	 * Verarbeitet den eingebenen Keycode.
	 * Wenn die Leertaste gedrückt wird, wird die Animation gestoppt oder gestartet.
	 * Das ganze durch die Variable "animation".
	 * 
	 * @param keyCode
	 */
	public void handleKeyPress(int keyCode)
	{
		switch(keyCode)
		{
		case 32	:
			if(animation == false)
			{
				animation = true;
				start();
			}
			else
			{
				animation = false;
				stop();
			}
		break;
		}
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
			Animation.moveSatellite(satellite, animThread, orbit);
			frame.repaint();
		
			try {
				Thread.currentThread().sleep(60);
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
