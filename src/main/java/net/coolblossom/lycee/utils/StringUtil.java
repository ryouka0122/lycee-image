package net.coolblossom.lycee.utils;

public class StringUtil {

	public static String hr(char ch, int len) {
		StringBuffer sb = new StringBuffer();
		while(len-->0) sb.append(ch);
		return sb.toString();
	}

	public static boolean isEmpty(String str) {
		return (str==null || str.isEmpty() );
	}

	public static boolean equals(Object lhs, String rhs) {
		return lhs==null ? rhs==null : lhs.equals(rhs);
	}
}
