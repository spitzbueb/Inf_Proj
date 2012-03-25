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


/**
 * Hello world!
 *
 */
public class App extends Frame
{
	private JFrame frame;
	private Earth earth = new Earth();
	private SatelliteRoute orbit = new SatelliteRoute();
	private Satellite satellite = new Satellite();
    
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
	
	public void handleKeyPress(int keyCode)
	{
		switch(keyCode)
		{
		case 32	:
			satellite.setPosy(satellite.getPosy()+1);
			frame.repaint();
;		break;
		}
	}
	
	public static void main(String[] args) {
		new App();
	}
}
