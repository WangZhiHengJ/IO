package io02;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/19 21:41
 * @Description: 字符writer 写入
 */
public class IOtest07 {
    public static void main(String[] args) {

        File file = new File("aaa.txt");
        //testReader(file);
        File file1 = new File("bbb.txt");
        testWriter(file1);
    }

    /**
     * @author: 王志恒
     * @date: 2019/7/20 15:57
     * @param
     * @return:
     * @Description：
     * 字符流读出
     */
    public static void testReader(File file) {

        //创建流
        Reader reader = null;

        try {
            //操作
            reader = new FileReader(file);
            //缓冲
            char[] flush = new char[4];

             int len = reader.read(flush);
            StringBuilder sb = new StringBuilder();
            while (len != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str +" >>> "+str.hashCode());
                sb.append(str);
                len = reader.read(flush);
            }
            System.out.println(sb);
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
        }

    }

    /**
     * @author: 王志恒
     * @date: 2019/7/20 15:56
     * @param
     * @return:
     * @Description：
     * 字符流写入
     */
    public static void testWriter(File newFile) {

        //创建流
        Writer writer = null;

        try {
            String str = "人有三条命，谁不珍惜谁先死";

            writer = new FileWriter(newFile);
            writer.write(str);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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