package Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class writeTxt {

	public static void write(String path, List<String> args) throws IOException {
		// ��д��ת��Ϊ������ʽ
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		// һ��дһ��
		for (int i = 0; i < args.size(); i++) {
			bw.write(args.get(i));
			bw.newLine(); // ������
		}
		// �ر���
		bw.close();
	}
}
