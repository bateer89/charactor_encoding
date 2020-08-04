package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import Utils.cut_lines;
import Utils.readFileUtils;

public class getTarget {
	public static List<String> getWords(String PATH, String codeSet) throws IOException {
		List<String> res = new ArrayList<String>();
		InputStreamReader ir = readFileUtils.getReaderByPath(PATH, codeSet);
		BufferedReader bufReader = new BufferedReader(ir);
		Stream<String> ss = bufReader.lines();
		String[] lines = ss.toArray(String[]::new);
		cut_lines.getFirstWordList(res, lines);
		return res;
	}
}
