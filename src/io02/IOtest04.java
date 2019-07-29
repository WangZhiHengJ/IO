package io02;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/19 21:41
 * @Description:
 */
public class IOtest04 {
    public static void main(String[] args) {
        //1|创建源
        File file = new File("abcd.txt");

        //2 、创建流
        OutputStream os = null;
        try {
            //3、操作
            System.out.println();

            os = new FileOutputStream(file,true);
            String s ="人有三条命：性命生命使命。";
            byte[] bytes = s.getBytes();
            os.write(bytes, 0, bytes.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}