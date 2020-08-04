package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

/** 
* @Author BaTeer
* @Time 2020年8月3日 下午11:26:26 
* <p>Description:</p>
*/
public class readFileUtils {
	public static String getContentByPath(String filepath) throws IOException{
        String []fileTypeArr=filepath.split( "\\." );
        String fileType=fileTypeArr[fileTypeArr.length-1];
        if("doc".equals( fileType ) || "docx".equals( fileType )){
            return readWord( filepath,fileType );
        }else{
            System.out.println("不支持的文件类型！");
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
                System.out.println("此文件不是word文件！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
