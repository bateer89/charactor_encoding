package main;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import Utils.readFileUtils;

/** 
* @Author BaTeer
* @Time 2020年8月3日 下午11:38:33 
* <p>Description:</p>
*/
public class run {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("ok");
		String str = readFileUtils.getContentByPath("C:\\Users\\Administrator\\Documents\\WXWork\\1688851924181626\\Cache\\File\\2020-08\\字库编码new.doc");
		ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
		InputStreamReader is = new InputStreamReader(stream,"GBK");
		BufferedReader bufReader=new BufferedReader(is);
//		System.out.println(bufReader);
		int len = 0 ;
		char[] chs = new char[1024];
	    while((len=bufReader.read(chs))!=-1) {
	        System.out.println(new String(chs,0,len));
	    }
	}

}
