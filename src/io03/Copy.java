package io03;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/19 21:41
 * @Description: 文件拷贝
 */
public class Copy {
    public static void main(String[] args) {
        //1、创建源 D:\ideaProjects\Base\IO\testIO.jpg

        File file = new File("testIO.jpg");
        File newFile = new File("newTestIO.jpg");
        //2、创建流

        //3、操作
        //缓冲
        byte[] flush = new byte[1024 * 2];

        try (InputStream is = new FileInputStream(file);
             OutputStream os = new FileOutputStream(newFile)) {

            int len = is.read(flush);
            while (len != -1) {
                os.write(flush, 0, len);
                len = is.read(flush);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}