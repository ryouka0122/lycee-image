package net.coolblossom.lycee.guis;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * <b>抽象ウィンドウクラス</b>
 * <p>
 * 主にメインウィンドウ用に用意してあります
 * </p>
 * @author ryouka0122@github
 *
 */
public abstract class LyceeAbstractWindow extends Frame implements WindowListener {

	public LyceeAbstractWindow() {
		super();
	}

	public LyceeAbstractWindow(String title) {
		super(title);
	}

	public LyceeAbstractWindow(GraphicsConfiguration gc) {
		super(gc);
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
