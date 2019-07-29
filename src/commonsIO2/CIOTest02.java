package commonsIO2;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.*;

import java.io.File;
import java.util.Collection;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/27 19:40
 * @Description: 文件过滤，遍历文件夹
 */
public class CIOTest02 {
    public static void main(String[] args) {
        System.out.println("---------------------");
        Collection<File> files = FileUtils.listFiles(new File("D:\\ideaProjects\\Base\\IO"), EmptyFileFilter.NOT_EMPTY, null);
        for (File file : files
        ) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("-----------------------");
        Collection<File> files1 = FileUtils.listFiles(new File("D:\\ideaProjects\\Base\\IO"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);

        for (File file : files1
        ) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("--------------3-");

        Collection<File> file2 = FileUtils.listFiles(new File("D:\\ideaProjects\\Base\\IO"), FileFilterUtils.or(new PrefixFileFilter("IO"),new SuffixFileFilter(".jpg")), DirectoryFileFilter.INSTANCE);

        for (File file : file2
        ) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
