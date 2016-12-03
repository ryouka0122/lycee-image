package net.coolblossom.lycee.application;

import java.awt.FileDialog;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

import net.coolblossom.lycee.guis.MainWindow;
import net.coolblossom.lycee.utils.ImageUtil;
import net.coolblossom.lycee.utils.PathUtil;
import net.coolblossom.lycee.utils.ResourcesUtil;

/**
 * アプリケーション本体
 * @author ryouka0122@github
 *
 */
public class LyceeImageEditor extends AbstractApplication {

	/** メインウィンドウ */
	MainWindow window;

	/** 読み込んだ画像パス */
	String path;

	/** オリジナル画像 */
	Image imgOriginal;

	@Override
	protected boolean initApplication(String[] args) {
		String path = PathUtil.joinPath(
				ResourcesUtil.getImageDir(), "test001.jpg");
		System.out.println("path : " + path);

		window = new MainWindow();
		window.setSize(100, 100);
		try {
			imgOriginal = ImageUtil.loadImage(path);
		} catch (IOException e) {
			return false;
		}

		window.addKeyListener(this);
		window.addWindowListener(this);
		return true;
	}

	void openImageDialog() {
		FileDialog dialog = new FileDialog(window, "ファイルを開く", FileDialog.LOAD);
		dialog.setVisible(true);
		System.out.println("dictory :" + dialog.getDirectory());
		System.out.println("file    : " + dialog.getFile());
	}

	@Override
	protected void executeApplication() {
		window.setVisible(true);

	}

	@Override
	protected void releaseApplication() {
		;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
		case 'o':
			openImageDialog();
			break;
		}
		//System.out.println("KeyCode:" + e.getKeyChar());
	}

}
