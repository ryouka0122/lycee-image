package net.coolblossom.lycee.utils;

import java.io.File;

/**
 * リソース関連ユーティリティ
 * @author ryouka0122@github
 * @category リソース関連
 *
 */
public class ResourcesUtil {

	static private String resourcesRootDir =
			ArrayUtil.join(File.separator, "src", "main", "resources");

	private ResourcesUtil() {
		;
	}

	static public String getResourcesRootPath() {
		return PathUtil.joinPath(PathUtil.getRootDir(), resourcesRootDir);
	}

	static public String getImageDir() {
		return PathUtil.joinPath(getResourcesRootPath(), "image");
	}

}
