package io04;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 *
 * @Auther: 王志恒
 * @Date: 2019/7/19 21:41
 * @Description: 字节 字符缓冲流
 */
public class BufferedTest01 {
    public static void main(String[] args) {
        //创建源 D:\ideaProjects\Base\IO\   testVideoFile.mp4
        File byteSource = new File("resource/testVideoFile.mp4");
        File byteDestination = new File("resource/newTestVideoFile.mp4");
        bufferedInputCopy(byteSource, byteDestination);
        File source = new File("resource/aaa.txt");
        File destination = new File("resource/newAAA2.txt");

        bufferedReaderAndWriterCopy("http://www.baidu.com", "baidu.html");
    }


    //字节缓冲流 copy
    public static void bufferedInputCopy(File source, File destination) {
        try (InputStream is = new FileInputStream(source);
             BufferedInputStream bi = new BufferedInputStream(is, 8192 * 100);
             OutputStream os = new FileOutputStream(destination);
             BufferedOutputStream bo = new BufferedOutputStream(os, 8192 * 100)) {

            byte[] flush = new byte[8192 * 100];
            int len = bi.read(flush);
            while (len != -1) {
                bo.write(flush, 0, len);
                len = bi.read();
            }
            bo.flush();
        } catch (IOException e) {
            System.out.println("文件找不到");
            e.printStackTrace();
        }


    }

    //字符缓冲流 Copy
    public static void bufferedReaderAndWriterCopy(String source, String destination) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(source).openStream(), "UTF-8"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination), "UTF-8"))) {

            String len = br.readLine();
            while (len != null) {
                bw.write(len);
                bw.newLine();
                len = br.readLine();
            }
            bw.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}