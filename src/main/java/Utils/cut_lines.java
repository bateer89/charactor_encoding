package Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cut_lines {
	/*
	 * 获取字对应编码的map 去掉字母
	 */
	public static void getWordMap(Map<String, String> map, String[] s) {
		char c;
		int i;
		for (int it = 0; it < s.length; it++) {
			s[it] = s[it].replaceAll("　", " ");
			s[it] = s[it].replaceAll("[a-zA-Z]", "");
			s[it] = s[it].replaceAll(" ", "");
			s[it] = s[it].trim();
			for (i = 0; i < s[it].length(); i++) {
				c = s[it].charAt(i);
				if (c >= '0' && c <= '9')
					break;
			}
			if (i != s[it].length()) {
				map.put(s[it].substring(0, i), s[it].substring(i));
			}
		}
	}

	/*
	 * 获取每一行开头的词语
	 */
	public static void getFirstWordList(List<String> res, String[] s) {
		for (int it = 0; it < s.length; it++) {
			int i;
			char c;
			s[it] = s[it].replaceAll("	", " ");
			s[it] = s[it].replaceAll(" ", "");
			s[it] = s[it].trim();
			for (i = 0; i < s[it].length(); i++) {
				c = s[it].charAt(i);
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
					break;
			}
			if (i != s[it].length()) {
				res.add(s[it].substring(0, i));
			}
		}
	}

	/*
	 * 获取字对应编码的map 去掉字母
	 */
	public static void getWordMapWithCharacter(Map<String, String> map, String[] s) {
		char c;
		int i;
		for (int it = 0; it < s.length; it++) {
			s[it] = s[it].replaceAll("　", " ");
			s[it] = s[it].replaceAll(" ", "");
			s[it] = s[it].trim();
			for (i = 0; i < s[it].length(); i++) {
				c = s[it].charAt(i);
				if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
					break;
			}
			if (i != s[it].length()) {
				map.put(s[it].substring(0, i), s[it].substring(i));
			}
		}
	}
}
