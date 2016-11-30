package net.coolblossom.lycee.utils;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import net.coolblossom.lycee.ext.LyceeProperties;

public class PropertiesUtilTest {

	static String RESOURCE_BASEDIR = "src/test/resources";

	String test_path = PathUtil.joinPath(RESOURCE_BASEDIR, "app_test.properties");

	@Test
	public void test() {

		try {
			LyceeProperties props = PropertiesUtil.load(test_path);

			for(Object key : props.keySet()) {
				System.out.println(key+":"+props.getProperty(key.toString()));
			}

		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test_001() {
		Pattern ptn = Pattern.compile("(\\$[^\\$]+\\$)");
		String[] text = {
			//	"a", "a$test$", "$test$a", "a$test$a",
			//	"$", "a$", "$a", "a$a",
			//	"$$", "a$$", "$$a", "a$$a",
			//	"$test$",
				"$test$$text$",
				"$key$",
			//	"$test$",
				};

		for(String str : text) {
			Matcher m = ptn.matcher(str);

			if(!m.find()) {
				continue;
			}

			StringBuilder sb = new StringBuilder();
			for(int i=1 ; i<=m.groupCount() ; i++) {
				sb.append(",").append(m.group(i));
			}
			System.out.println(str + ": {"+sb.substring(1)+"}");
		}
	}

	@Test
	public void test_003() {
		LyceeProperties props = null;
		try {
			props = PropertiesUtil.load(test_path);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		Pattern ptn = Pattern.compile("(\\$[^\\$]+\\$)");

		for(Object key : props.keySet()) {
			String target = props.getProperty(key.toString());
			Matcher matcher = ptn.matcher(target);
			String result = target;
			int pos =0;
			System.out.println(StringUtil.hr('-', 50));
			System.out.println("key    : " + key);
			System.out.println("target : " + target);
			while(matcher.find(pos)) {
				// 置換文字列取得
				String str = matcher.group(1);
				String altkey = str.substring(1, str.length()-1);
				System.out.println("★" + str + " -> " + altkey);

				// 再帰参照チェック
				if(StringUtil.equals(key, altkey)) {
					System.out.println("Recursive reference value.");
					break;
				}
				// 置換処理
				String altval = props.getProperty(altkey);
				if(StringUtil.isEmpty(altval)) {
					pos = matcher.end();
				}else{
					result = matcher.replaceAll(altval);
					// マッチさせる文字列を更新させたのでリセット
					matcher = ptn.matcher(result);
					pos = 0;
				}
			}
			System.out.println("props["+key+"] = " + result);

		}
	}


}
