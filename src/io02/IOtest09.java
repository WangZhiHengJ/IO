package io02;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/19 21:41
 * @Description: 字节数组输出流
 */
public class IOtest09 {
    public static void main(String[] args) {

        File file = new File("aaa.txt");

        inputByteArray();
    }

    public static void  inputByteArray() {

        InputStream is = null;
        String str = "废话少说，多敲代码。";
        byte[] bytes = str.getBytes();

        byte[] flush = new byte[9];
        is = new ByteArrayInputStream(bytes);

        try {
            int len =  is.read(flush);
            while (len != -1) {
                str = new String(flush, 0, len);
                System.out.println(str);
                len =  is.read(flush);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    }