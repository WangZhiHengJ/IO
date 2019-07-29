package file;

import java.io.File;

public class File01 {

   /**
    * 
    *       
    * @author: wy
    * @date: 2019/7/19 22:32
    * @param args
   * @return: 
   */
    public static void main(String[] args) {

        String path = "D:\\ideaProjects\\Base\\IO\\src\\file\\testIO.jpg";

        //绝对路径
        File file = new File(path);
        System.out.println("file:"+file.getAbsolutePath());
        //相对路径
        File file1 = new File("../file/testIO.jpg");
        System.out.println("file1:"+file1.getAbsolutePath());


    }
}
