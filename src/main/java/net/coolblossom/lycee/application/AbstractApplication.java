package net.coolblossom.lycee.application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public abstract class AbstractApplication
	implements Application
	, WindowListener
	, KeyListener
{


	abstract protected boolean initApplication(String[] args);
	abstract protected void executeApplication();
	abstract protected void releaseApplication();

	@Override
	public void run(String[] args) {
		try{
			if(initApplication(args)) {
				executeApplication();
			}
		}finally{
			releaseApplication();
		}
	}

	// ==========================================================
	// KeyListener
	//
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	// ==========================================================
	// WindowListener
	//
	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

}
