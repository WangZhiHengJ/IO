package CommonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.*;

import java.io.File;
import java.util.Collection;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/27 15:46
 * @Description:
 * 文件过滤，遍历文件夹
 */
public class CIOTest02 {
    public static void main(String[] args) {

        Collection<File> files = FileUtils.listFiles(new File("D:/ideaProjects/Base/IO/resource"), EmptyFileFilter.EMPTY, null);
        for (File file : files
        ) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("--------------------------- 2");
        Collection<File> files1 = FileUtils.listFiles(new File("D:/ideaProjects/Base/IO/src"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for (File file : files1
        ) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("--------------------------- 3");
        Collection<File> files2 = FileUtils.listFiles(new File("D:/ideaProjects/Base/IO/src"), new PrefixFileFilter("Print"), DirectoryFileFilter.INSTANCE);
        for (File file : files2
        ) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("--------------------------- 4");
        Collection<File> files3 = FileUtils.listFiles(new File("D:\\ideaProjects\\Base\\IO\\resource"), FileFilterUtils.or(new SuffixFileFilter("jpg"), new SuffixFileFilter("mp4")), DirectoryFileFilter.INSTANCE);
        for (File file : files3
        ) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("--------------------------- 5");
        Collection<File> files4 = FileUtils.listFiles(new File("D:\\ideaProjects\\Base\\IO\\src"),
                FileFilterUtils.and(new PrefixFileFilter("C"), new SuffixFileFilter("java"),EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);
        for (File file : files4
        ) {
            System.out.println(file.getAbsolutePath());
        }
    }
}