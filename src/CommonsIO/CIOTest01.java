package CommonsIO;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/27 15:46
 * @Description:
 * 文件大小
 */
public class CIOTest01 {
    public static void main(String[] args) {

        //文件大小
        long len = FileUtils.sizeOf(new File("resource/aaa.txt"));
        System.out.println(len);
        //目录大小
        len = FileUtils.sizeOf(new File("resource"));
        System.out.println(len);
    }
}