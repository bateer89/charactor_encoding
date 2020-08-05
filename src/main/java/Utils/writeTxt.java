package Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class writeTxt {

	public static void write(String path, List<String> args) throws IOException {
		// 将写入转化为流的形式
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		// 一次写一行
		for (int i = 0; i < args.size(); i++) {
			bw.write(args.get(i));
			bw.newLine(); // 换行用
		}
		// 关闭流
		bw.close();
	}
}
