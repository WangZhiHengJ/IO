package CommonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/27 15:46
 * @Description: 文件拷贝
 */
public class CIOTest05 {
    public static void main(String[] args) {


        try {
            //复制文件
//            FileUtils.copyFile(new File("D:\\ideaProjects\\Base\\IO\\resource\\IO类图.jpg"), new File("D:\\ideaProjects\\Base\\IO\\resource\\IO类图2.jpg"));

            //复制文件到目录
//            long time = System.currentTimeMillis();
//            System.out.println(time);
//            FileUtils.copyFileToDirectory(new File("D:\\ideaProjects\\Base\\IO\\resource\\testVideoFile.mp4"), new File("D:\\ideaProjects\\Base\\IO\\src\\CommonsIO"));
//            long endTime = System.currentTimeMillis();
//            System.out.println(endTime-time);

            //复制目录到目录
//            FileUtils.copyDirectoryToDirectory(new File("D:\\ideaProjects\\Base\\IO\\src\\CommonsIO"), new File("D:\\ideaProjects\\Base\\IO\\resource"));

            //复制目录:和上面的不同的是： copyDirectory这个将第一个文件夹目录下的所有文件复制到另一个文件夹下
//            FileUtils.copyDirectory(new File("D:\\ideaProjects\\Base\\IO\\lib"),new File("D:\\ideaProjects\\Base\\IO\\resource"));

            //拷贝URL内容
//            String urlPath = "file:///D:/ideaProjects/Base/IO/resource/IO%E7%B1%BB%E5%9B%BE.jpg";
//            FileUtils.copyURLToFile(new URL(urlPath), new File("resource/test2.jpg"));

            String str = IOUtils.toString(new URL("http://www.baidu.com"), "utf8");
            System.out.println(str);
            FileUtils.write(new File("baidu2.html"), str,"utf8");

            String str163 = IOUtils.toString(new URL("http://www.163.com"), "gbk");
            FileUtils.write(new File("test163.html"), str163, "gbk");

            System.out.println(str163);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}