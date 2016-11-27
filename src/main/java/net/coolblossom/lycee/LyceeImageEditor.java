package net.coolblossom.lycee;

import java.io.IOException;

import net.coolblossom.lycee.gdi.ImageWindow;
import net.coolblossom.lycee.utils.ImageUtil;
import net.coolblossom.lycee.utils.PathUtil;
import net.coolblossom.lycee.utils.ResourcesUtil;

public class LyceeImageEditor {

	ImageWindow window;

	public void initialize() throws IOException {
		String path = PathUtil.joinPath(
				ResourcesUtil.getImageDir(), "test001.jpg");
		System.out.println("path : " + path);

		window = new ImageWindow();
		window.setSize(100, 100);
		window.setImage(ImageUtil.loadImage(path));
		;
		window.setTitle("Lycee Image Editor [1.0.0]");

	}

	public void execute() {
		window.setVisible(true);
	}


	public static void main(String[] args) throws IOException {
		LyceeImageEditor editor = new LyceeImageEditor();
		editor.initialize();
		editor.execute();
		return;
	}


}
