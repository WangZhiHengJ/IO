package io02;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/19 21:41
 * @Description:
 */
public class IOtest01 {
    public static void main(String[] args) {
        //1 、 创建源
        File file = new File("adb.txt");
        //2、选择流
        try {
            InputStream is = new FileInputStream(file);
            //3、操作
            int data1 = is.read();
            int data2 = is.read();
            int data3 = is.read();
            int data4 = is.read();

            System.out.println((char) data1 + "," + data2 + "," + data3 + "," + data4);
            //4、释放资源
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}