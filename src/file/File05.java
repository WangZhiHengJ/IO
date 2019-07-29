package file;

import java.io.File;

public class File05 {

   
    public static void main(String[] args) {

        String path = "D:\\ideaProjects\\Base";
        printName(new File(path),0);

    }

    /**
     * @author: 王志恒
     * @date: 2019/7/18 21:39
     * @param file
     * @return: void
     * @Description：打印当前目录下的所有目录及文件
     */
    public static void printName(File file,int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(">");
        }
        System.out.println(file.getName());
        if (file == null || !file.exists()) {
            return;
        } else if (file.isDirectory()) { //目录
            for (File f : file.listFiles()) {
                printName(f,n+1);
            }
        }
    }
}
