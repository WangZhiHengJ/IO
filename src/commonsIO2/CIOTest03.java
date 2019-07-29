package commonsIO2;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/27 19:40
 * @Description: 文件复制
 */
public class CIOTest03 {
    public static void main(String[] args) throws IOException {

        //读文件
        String str = FileUtils.readFileToString(new File("D:\\ideaProjects\\Base\\IO\\resource\\aaa.txt"), "utf8");
        System.out.println(str);
        List<String> list= FileUtils.readLines(new File("D:\\ideaProjects\\Base\\IO\\resource\\aaa.txt"), "utf8");
        System.out.println(list);

        LineIterator a = FileUtils.lineIterator(new File("D:\\ideaProjects\\Base\\IO\\resource\\aaa.txt"), "utf8");
        while (a.hasNext()) {
            System.out.println(a.next());
        }

        //写文件
        FileUtils.write(new File("resource/aaa.txt"), "测试是否成功\n", "utf8", true);
        FileUtils.writeStringToFile(new File("resource/aaa.txt"), "222222222\n", "utf8", true);
        FileUtils.writeByteArrayToFile(new File("resource/aaa.txt"), "333333".getBytes("utf8"), true);

//        拷贝
//        拷贝文件到文件
        FileUtils.copyFile(new File("resource/aaa.txt"), new File("resource/aaa2.txt"));
//        FileUtils.copyDirectory(new File("resource"),new File("D:\\ideaProjects\\Base\\IO\\src\\commonsIO2"));
        FileUtils.copyFileToDirectory(new File("resource/aaa.txt"), new File("D:\\ideaProjects\\Base\\IO\\src\\commonsIO2"));
        FileUtils.copyDirectoryToDirectory(new File("resource"),new File("resource"));
    }
}
