package io02;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/19 21:41
 * @Description:
 * 文件拷贝
 */
public class IOtest06 {
    public static void main(String[] args) {
        //1、创建源 D:\ideaProjects\Base\IO\testIO.jpg

        File file = new File("aaa.text");
        File newFile = new File("newReaderFile.text");
        //2、 创建流
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(file);
            writer = new FileWriter(newFile,true);
            //3 、操作
            char[] flush = new char[1024];
            int len = reader.read(flush);

            while (len != -1) {
                String str = new String(flush, 0, len);
                writer.write(str);
                len = reader.read(flush);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}