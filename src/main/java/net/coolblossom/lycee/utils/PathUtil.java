package net.coolblossom.lycee.utils;

import java.io.File;

/**
 * パス操作ユーティリティ
 * @author ryouka0122@github
 * @category パス操作関連
 */
public class PathUtil {

	private PathUtil() {
		;
	}

	static public String getRootDir() {
		return System.getProperty("user.dir");
	}


	static public String joinPath(String dir, String name) {
		if(dir.endsWith(File.separator)) {
			if(name.startsWith(File.separator)) {
				return dir + name.substring(1);
			}else{
				return dir + name;
			}
		}else{
			if(name.startsWith(File.separator)) {
				return dir + name;
			}else{
				return dir + File.separator + name;
			}

		}
	}

}
