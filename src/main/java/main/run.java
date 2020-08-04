package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author BaTeer
 * @Time 2020��8��3�� ����11:38:33
 *       <p>
 *       Description:
 *       </p>
 */
public class run {
	private static final String CHAR_SET = "GB18030";
	private static final String PATH1 = "D:\\�û�Ŀ¼\\�ҵ��ĵ�\\WXWork\\1688851924181626\\Cache\\File\\2020-08\\�ֿ����new.doc";
	private static final String PATH2 = "D:\\�û�Ŀ¼\\�ҵ��ĵ�\\WXWork\\1688851924181626\\Cache\\File\\2020-08\\�ִ����ﳣ�ôʱ�.docx";

	public static void main(String[] args) throws IOException {
		int count = 0;
		System.out.println("ok");
		Map<String, String> words = getOrigin.getData(PATH1, CHAR_SET);// ��ȡ���ֱ��뵽map��
		List<String> targetList = getTarget.getWords(PATH2, CHAR_SET);// ��ȡ���ﵽlist��
		List<String> errorList = new ArrayList<String>();
		errorList.addAll(targetList);// ���Ƶ�list��
		List<String[]> targetListSplited = new ArrayList<String[]>();// list��Ĵʻ��ֳɵ�������
		targetList.forEach((e) -> {
			targetListSplited.add(e.split(""));
		});

		for (int i = 0; i < targetListSplited.size(); i++) {
			String temp = "";
Boolean err = true;
			for (int j = 0; j < targetListSplited.get(i).length; j++) {
				if (words.get(targetListSplited.get(i)[j]) != null) {
					temp += words.get(targetListSplited.get(i)[j]);
				} else {
					temp += "?";
					count++;
					err=false;
				}
			}
			if(err==false){
				errorList.set(i, errorList.get(i) + temp);
			}
			targetList.set(i, targetList.get(i) + temp);
		}
		for (int i = 0; i < targetListSplited.size(); i++) {
			System.out.println(targetList.get(i));
		}
		System.out.println(count);
		for (int i = 0; i < errorList.size(); i++) {
			System.out.println(errorList.get(i));
		}
	}

}
