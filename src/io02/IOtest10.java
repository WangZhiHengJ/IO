package io02;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/19 21:41
 * @Description: 字节数组输出流
 */
public class IOtest10 {
    public static void main(String[] args) {
       //D:\ideaProjects\Base\IO\testIO.jpg
//        File file = new File("aaa.txt");

        byte[] datas = fileToByteArray("testIO.jpg");
        System.out.println(datas.length);

        byteArrayToFile(datas, "newTestIO.jpg");


    }

    /**
     * @author: 王志恒
     * @date: 2019/7/20 20:57
     * @param
     * @return:
     * @Description：
     * 图片读取到字节数组
     */
    public static byte[] fileToByteArray(String path) {

        File file = new File(path);
        InputStream is = null;

        byte[] datas = null;
        try {
            byte[] flush = new byte[1024];
            is = new FileInputStream(path);
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int len = is.read(flush);
            while (len != -1) {
               // String str = new String(flush, 0, len);
//                System.out.println(str);

                bo.write(flush,0,len);
                len = is.read(flush);


            }
            bo.flush();
            datas = bo.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return datas;
    }


    /**
     * @param
     * @author: 王志恒
     * @date: 2019/7/20 20:57
     * @return:
     * @Description： 字节数组写出到图片
     */
    public static void byteArrayToFile(byte[] bytes, String path) {

        //1、创建源
        File file = new File(path);
        //2、创建流
        InputStream is = null;
        OutputStream os = null;

            is = new ByteArrayInputStream(bytes);
        try {
            byte[] flush = new byte[1024];
            os = new FileOutputStream(file, true);
            int len = is.read(flush);
            while (len != -1) {
                os.write(flush, 0, len);
                len = is.read(flush);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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