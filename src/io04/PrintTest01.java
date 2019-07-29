package io04;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/25 18:45
 * @Description:
 * 打印流 printStream
 */
public class PrintTest01 {
    public static void main(String[] args) {
        PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);

        try {
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("resource/aaa.txt")),true);
            ps.println("打印流");
            ps.println(true);
            //重定向输出端
            System.setOut(ps);
            System.out.println("重定向输出端");
            //重定向到控制台
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out),true));
            System.out.println("我回来了");
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}