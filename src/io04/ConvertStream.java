
package io04;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/23 09:34
 * @Description: 转换流
 * 1、以字符流的形式操作字节流(纯文本)
 * 2、指定字符集
 */


public class ConvertStream {
    public static void main(String[] args) {
        //操作System.in和System.out
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(System.out));

        convert01();

    }

    public static void convert01() {

        try (BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
             OutputStream os1 = new FileOutputStream("resource/textStream.txt",true);
             BufferedWriter os=new BufferedWriter(new OutputStreamWriter(os1))) {
            String data = is.readLine();
            while (!data.equals("exit")) {
                os.write(data);
                os.newLine();
                data = is.readLine();
            }
            os.newLine();
            os.append("读取完成");
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}