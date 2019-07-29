package io02;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/19 21:41
 * @Description:
 */
public class IOtest03 {
    public static void main(String[] args) {
        //1|创建源
        File file = new File("adb.txt");

        //2 、创建流
        InputStream is = null ;
        try {
            //3、读取操作
            is = new FileInputStream(file);
            byte[] bytes = new byte[20];
            int len = is .read(bytes);

            while (len != -1) {
                String str = new String(bytes, 0, len);
                System.out.println(len);
                System.out.println(str);
                len = is .read(bytes);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}