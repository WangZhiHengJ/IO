
package io04;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/23 09:34
 * @Description: 转换流
 * 操作网络流，指定字符集
 * 1、以字符流的形式操作字节流(纯文本)
 * 2、指定字符集
 */


public class ConvertStream02 {
    public static void main(String[] args) {
        String baidu = "http://www.baidu.com";
        String bilibili = "http://www.bilibili.com";
       // convert01(baidu);
//        convert02(baidu);
        convert03(baidu);
    }


    public static void convert01(String url) {


        //操作网络流 爬取百度源代码
        try (InputStream is = new URL(url).openStream()
        ) {
            int len = is.read();
            while (len != -1) {
                System.out.print((char) len);
                len = is.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convert02(String url) {


        //操作网络流 爬取百度源代码
        try (InputStreamReader is = new InputStreamReader(new URL(url).openStream(),"UTF8")
        ) {

            String encoding = is.getEncoding();
            System.out.println(encoding);
            int len = is.read();
            while (len != -1) {
                System.out.print((char) len);
                len = is.read();
            }
            System.out.println("02结束");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convert03(String url) {

        //增加缓冲
        //1、创建缓冲缓流，转换流继承了Reader对象 2、创建转换流，转换流继承了Reader对象，构造方法重载方法参数是InputStream
        // 3、打开网络流，网络流返回InputStream
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("resource/baidu.html"), "UTF-8"))) {

            String len;
            while ((len = br.readLine()) != null) {
                bw.write(len);
                bw.newLine();
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

