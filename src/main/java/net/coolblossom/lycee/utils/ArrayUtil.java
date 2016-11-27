package net.coolblossom.lycee.utils;

public class ArrayUtil {

	private ArrayUtil() {

	}

	public static String join(String delim, String ...ary) {
		if(delim==null || ary==null || ary.length==0) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0 ; i<ary.length ; i++) {
			sb.append(delim).append(ary[i]);
		}
		return sb.substring(delim.length());
	}

}
