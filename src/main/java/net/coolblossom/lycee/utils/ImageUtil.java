package net.coolblossom.lycee.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 画像関連ユーティリティ
 * @author ryouka0122@github
 * @category 画像関連
 */
public class ImageUtil {

	private ImageUtil() {

	}

	static public Image loadImage(String path) throws IOException {
		return loadImage(new File(path));
	}

	static public Image loadImage(File file) throws IOException {
		return ImageIO.read(file);
	}

	static public Image loadImageQuietly(File file) {
		try {
			if(file==null) {
				return null;
			}
			return loadImage(file);
		} catch (IOException e) {
			return null;
		}
	}

}
