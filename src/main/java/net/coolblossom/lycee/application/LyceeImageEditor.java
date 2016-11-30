package net.coolblossom.lycee.application;

import java.awt.Image;
import java.io.IOException;

import net.coolblossom.lycee.guis.MainWindow;
import net.coolblossom.lycee.utils.ImageUtil;
import net.coolblossom.lycee.utils.PathUtil;
import net.coolblossom.lycee.utils.ResourcesUtil;

public class LyceeImageEditor extends AbstractApplication {

	MainWindow window;

	String path;

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
		return true;
	}

	@Override
	protected void executeApplication() {
		window.setVisible(true);

	}

	@Override
	protected void releaseApplication() {
		;
	}


}
