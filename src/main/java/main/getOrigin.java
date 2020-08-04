package main;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import Utils.cut_lines;
import Utils.readFileUtils;

public class getOrigin {
	public static Map<String, String> getData(String path, String codeSet) throws IOException {
		String str = readFileUtils
				.getContentByPath(path);
		ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
		InputStreamReader is = new InputStreamReader(stream, codeSet);
		BufferedReader bufReader = new BufferedReader(is);
		Map<String, String> words = new HashMap<String, String>();// ´æ·Å
		Stream<String> ss = bufReader.lines();
		String[] lines = ss.toArray(String[]::new);
		cut_lines.getWordMap(words, lines);
//		System.out.println(words.size());
//		words.forEach((key, value) -> {
//			System.out.println(key + ":" + value);
//		});
		return words;
	}
}
