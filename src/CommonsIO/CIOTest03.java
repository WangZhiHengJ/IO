package CommonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/27 15:46
 * @Description:
 * 读写文件
 */
public class CIOTest03 {
    public static void main(String[] args) {

        try {
            //读取文件
            String msg = FileUtils.readFileToString(new File("resource/aaa.txt"), "utf8");
            System.out.println(msg);
            byte[] datas = FileUtils.readFileToByteArray(new File("resource/aaa.txt"));
            System.out.println(datas.length);

            System.out.println("----------------------");
            //逐行读取
            List<String> msgs = FileUtils.readLines(new File("resource/aaa.txt"), "utf8");
            for (String str : msgs
            ) {
                System.out.println(str);
            }
            System.out.println("----------------------");
            LineIterator it = FileUtils.lineIterator(new File("resource/aaa.txt"), "utf8");
            while (it.hasNext()) {
                String s = it.nextLine();
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}