package net.coolblossom.lycee.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.coolblossom.lycee.ext.LyceeProperties;

/**
 * プロパティ関連ユーティリティ
 * @author ryouka0122@github
 * @category プロパティ関連
 */
public class PropertiesUtil {

	private PropertiesUtil() {
		;
	}

	public static LyceeProperties load(String path) throws FileNotFoundException, IOException {
		LyceeProperties props = new LyceeProperties();
		props.load(path);
		return props;
	}

	public static LyceeProperties loadQuietly(String path) {
		LyceeProperties props = new LyceeProperties();
		try {
			props.load(path);
		} catch (IOException e) {
			// nop
		}
		return props;
	}



}
