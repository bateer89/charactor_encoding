package Utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

/** 
* @Author BaTeer
* @Time 2020��8��3�� ����11:26:26 
* <p>Description:</p>
*/
public class readFileUtils {
	/*
	 * ��ȡ�ֽ��� 
	 * @param �ļ�·��     ���뷽ʽ
	 */
	public static InputStreamReader getReaderByPath(String filepath, String coding) throws IOException{
		ByteArrayInputStream stream = getByteStreamByPath(filepath);
		InputStreamReader is = new InputStreamReader(stream,coding);
		return is;
	}
	
	/*
	 * s
	 */
	public static ByteArrayInputStream getByteStreamByPath(String filepath) throws IOException{
		String str = readFileUtils.getContentByPath(filepath);
		ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
		return stream;
	}
	
	public static String getContentByPath(String filepath) throws IOException{
        String []fileTypeArr=filepath.split( "\\." );
        String fileType=fileTypeArr[fileTypeArr.length-1];
        if("doc".equals( fileType ) || "docx".equals( fileType )){
            return readWord( filepath,fileType );
        }else{
            System.out.println("��֧�ֵ��ļ����ͣ�");
        }
        return "";
    }
	public static String readWord(String path,String fileType) {
        String buffer = "";
        try {
            if ("doc".equals( fileType )) {
                InputStream is = new FileInputStream(new File(path));
                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
//                ex.close();
            } else if ("docx".equals( fileType )) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                buffer = extractor.getText();
//                extractor.close();

            } else {
                System.out.println("���ļ�����word�ļ���");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
