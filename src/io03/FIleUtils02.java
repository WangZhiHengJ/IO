package io03;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/20 22:34
 * @Description:
 */
public class FIleUtils02 {

    public static void main(String[] args) {

        //文件到文件
        try {
            InputStream is = new FileInputStream("aaa.txt");
            OutputStream os = new FileOutputStream("newAaa.txt");
            copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //文件字节数组 D:\ideaProjects\Base\IO\testIO.jpg
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("testIO.jpg");

            ByteArrayOutputStream bo = new ByteArrayOutputStream();

            copy(is, bo);
            datas = bo.toByteArray();
            System.out.println(datas.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //字节数组到文件
        try {

            InputStream is = new ByteArrayInputStream(datas);

            OutputStream bo = new FileOutputStream("mmm.jpg");
            copy(is, bo);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * @author: 王志恒
     * @date: 2019/7/20 22:43
     * @param is
     * @param os
     * @return:
     * @Description：
     * 对接输入输出流
     */
    public static void copy(InputStream is, OutputStream os) {

        //缓冲
        byte[] flush = new byte[1024];
        try {
            int len = is.read(flush);
            while (len != -1) {
                os.write(flush, 0, len);
                len = is.read(flush);
            }

            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close(is, os);

        }
    }

    /**
     * @author: 王志恒
     * @date: 2019/7/21 16:58
     * @param ios
     * @return:
     * @Description：
     * Closeable... 是可变参数，跟数组的性质是一样的
     */
    public static void close(Closeable... ios) {
        for (Closeable io : ios) {
            try {
                if (io != null) {
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}