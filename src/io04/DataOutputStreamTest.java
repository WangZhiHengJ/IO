package io04;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/24 15:21
 * @Description:
 * 数据流，特征就是可以将数据转换成java的基本数据类型
 * 先写后读，顺序要一致
 */
public class DataOutputStreamTest {

    public static void main(String[] args) {

        test();

    }

    public static void test() {

        try (DataOutputStream bos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("resource/aaa.txt")))
        ) {

            bos.writeChar('A');
            bos.writeBoolean(false);
            String str = "谁知盘中餐";
            bos.writeBytes(str);
            bos.writeInt(123);
            bos.writeDouble(123.432);

            bos.flush();
            DataInputStream bis = new DataInputStream(new BufferedInputStream(new FileInputStream("resource/aaa.txt")));
            char c = bis.readChar();
            boolean b = bis.readBoolean();
            System.out.println(c+"   "+b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}