package io02;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/19 21:41
 * @Description:
 */
public class IOtest05 {
    public static void main(String[] args) {

        //1 、创建源
        File file = new File("abb.text");

        //2 、 创建流
        OutputStream os = null;

        String str = "人有三条命。";

        try {
            //3 、 操作
            os = new FileOutputStream(file,true);
            byte[] bytes = str.getBytes();
            os.write(bytes);

            os.flush();
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