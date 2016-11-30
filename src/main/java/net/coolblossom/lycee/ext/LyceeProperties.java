package net.coolblossom.lycee.ext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.coolblossom.lycee.consts.LyceeConsts;
import net.coolblossom.lycee.utils.StringUtil;

public class LyceeProperties extends Properties {

	private static final Pattern ptn = Pattern.compile("(\\$[^\\$]+\\$)");

	public LyceeProperties() {
		super();
	}

	@Override
	public String getProperty(String key) {
		String value = super.getProperty(key);
		if(StringUtil.isEmpty(value))
			return value;
		return expand(key, value);
	}


	private String expand(String key, String value) {
		Matcher matcher = ptn.matcher(value);
		String result = value;
		int pos =0;
		while(matcher.find(pos)) {

			// 置換文字列取得
			String str = matcher.group(1);
			String altkey = str.substring(1, str.length()-1);

			// 再帰参照チェック
			if(StringUtil.equals(key, altkey)) {
				// TODO Exceptionに変更させる
				System.out.println("Recursive reference value.");
				break;
			}

			// 置換処理
			String altval = super.getProperty(altkey);
			if(StringUtil.isEmpty(altval)) {
				pos = matcher.end();
			}else{
				result = matcher.replaceAll(altval);
				// マッチさせる文字列を更新させたのでリセット
				matcher = ptn.matcher(result);
				pos = 0;
			}
		}
		return result;
	}






	public synchronized void load(String path) throws FileNotFoundException, IOException {
		load0(new PropertyFileReader(
				new BufferedReader(
				new InputStreamReader(
				new FileInputStream(path), LyceeConsts.FILE_CHARSET)
				)
				) );
	}

	public synchronized void load(File file) throws IOException {
		load0( new PropertyFileReader(
				new BufferedReader(
					new FileReader(file))
				) );
	}

	@Override
	public synchronized void load(InputStream inStream) throws IOException {
		load0(new PropertyFileReader(
				new BufferedReader(
						new InputStreamReader(inStream) )
		) );
	}

	@Override
	public synchronized void load(Reader reader) throws IOException {
		if(reader instanceof BufferedReader)
			load0(new PropertyFileReader((BufferedReader)reader));
		else
			load0(new PropertyFileReader(new BufferedReader(reader)));
	}



	/**
	 * 日本語を正常に読み込むために自作
	 * @param reader
	 * @throws IOException
	 */
	private void load0(PropertyFileReader reader) throws IOException {
		super.clear();

		String line;
		while( (line=reader.readLine())!=null) {
			line = line.trim();
			if(line.isEmpty() || line.startsWith("#")) {
				continue;
			}
			int pos = line.indexOf('=');
			if(pos==-1) continue;
			String key = line.substring(0, pos).trim();
			super.put(key, line.substring(pos+1).trim());
		}

	}


	class PropertyFileReader {
		private BufferedReader reader;

		public PropertyFileReader(BufferedReader reader) {
			if(reader==null) throw new NullPointerException("reader is null.");
			this.reader = reader;
		}

		public String readLine() throws IOException {
			return reader.readLine();
		}

	}

}
