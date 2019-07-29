package file;

import java.io.File;
import java.io.IOException;

public class File02 {

  /**
   *
   * @author: wy
   * @date: 2019/7/18 20:56
   * @param args
   * @return: void
   */
    public static void main(String[] args) {

        String path = "D:\\ideaProjects\\Base\\IO\\src\\file\\testIO.jpg";

        //绝对路径
        File file = new File(path);
        System.out.println("file:"+file.getAbsolutePath());
        //是否是文件
        System.out.println(file.isFile());
        //相对路径
        File file1 = new File("D:\\ideaProjects\\");
        System.out.println("file1:"+file1.getAbsolutePath());
        //是否存在文件或者文件夹
        System.out.println(file1.exists());
        //父路径
        System.out.println(file1.getParent());
        //文件或者文件夹长度。如果是文件夹系统默认上传4096字节数
        System.out.println(file1.length());
        System.out.println(file.length());

        File file2 = new File("D:\\ideaProjects\\Base\\IO\\src\\file\\test.text");
        try {
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //删除已经存在的文件
        file2.delete();
    }

 
   
   
   

    /**
     * @author: 王志恒
     * @date: 2019/7/18 21:20
     * @param a
     * @param b
     * @return: int
     */
    public int s(int a, int b) {
        return  1;
    }
}
