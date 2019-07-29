package io03;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/20 22:34
 * @Description:
 */
public class FIleUtils03 {

    public static void main(String[] args) {

        //文件到文件
        try {
            InputStream is = new FileInputStream("aaa.txt");
            OutputStream os = new FileOutputStream("newAAA.text");
            copy(is, os);


        byte[] datas = null;
        //文件字节数组 D:\ideaProjects\Base\IO\testIO.jpg
            InputStream byteIs = new FileInputStream("testIO.jpg");
            ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
            copy(byteIs, byteOs);
            datas = byteOs.toByteArray();
            System.out.println(datas.length);

        //字节数组到文件
            InputStream is3 = new ByteArrayInputStream(datas);
            OutputStream os3 = new FileOutputStream("newTEST.jpg");
            copy(is3, os3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param is
     * @param os
     * @author: 王志恒
     * @date: 2019/7/21 17:24
     * @return:
     * @Description： 对接输入输出流
     */
    public static void copy(InputStream is, OutputStream os) {

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
        } finally {
            close(is, os);
        }

    }


    public static void close(Closeable... ios) {
        for (Closeable io : ios
        ) {
            if (io != null) {
                try {
                    io.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}