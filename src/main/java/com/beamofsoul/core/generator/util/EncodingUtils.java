package com.beamofsoul.core.generator.util;

import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;

/**
 * @ClassName EncodingUtils
 * @Description 编码方式转换工具类
 * @author MingshuJian
 * @Date 2017年4月1日 下午1:18:44
 * @version 1.0.0
 */
public class EncodingUtils {

	public static String utf8ToUnicode(String utf8Str) {
		char[] myBuffer = utf8Str.toCharArray();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < utf8Str.length(); i++) {
			UnicodeBlock ub = UnicodeBlock.of(myBuffer[i]);
			if (ub == UnicodeBlock.BASIC_LATIN) {
				// 英文及数字等
				sb.append(myBuffer[i]);
			} else if (ub == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
				// 全角半角字符
				int j = (int) myBuffer[i] - 65248;
				sb.append((char) j);
			} else {
				// 汉字
				short s = (short) myBuffer[i];
				String hexS = Integer.toHexString(s);
				String unicode = "\\u" + hexS;
				sb.append(unicode.toLowerCase());
			}
		}
		return sb.toString();
	}

	public static String unicodeToUtf8(String unicodeStr) {
		char aChar;
		int len = unicodeStr.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = unicodeStr.charAt(x++);
			if (aChar == '\\') {
				aChar = unicodeStr.charAt(x++);
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = unicodeStr.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}

	public static String utf8ToGB2312(String utf8Str) {
		byte[] b;
		String result = null;
		try {
			b = utf8Str.getBytes("UTF-8");
			result = new String(b, "GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String gb2312ToUtf8(String gb2312Str) {
		StringBuffer sb = new StringBuffer();
		try {
			sb.append(new String(gb2312Str.getBytes("GB2312"),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
