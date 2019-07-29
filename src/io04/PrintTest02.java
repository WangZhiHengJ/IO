package io04;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/25 18:45
 * @Description:
 * 打印流 printStream
 */
public class PrintTest02 {
    public static void main(String[] args) {

        try {
            PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("resource/bbb.txt",true)),true);
            pw.write("测试字符串是否导入成功\n");
            pw.println("测试print方法是否打印到文件");
            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}