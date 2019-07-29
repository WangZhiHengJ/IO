package commonsIO2;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/27 19:40
 * @Description: 读取文件大小
 */
public class CIOTest01 {
    public static void main(String[] args) {
        long size = FileUtils.sizeOf(new File("resource/aaa.txt"));
        System.out.println(size);
        size = FileUtils.sizeOf(new File("resource"));
        System.out.println(size);

    }
}