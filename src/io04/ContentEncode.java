package io04;

import java.io.UnsupportedEncodingException;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/18 22:03
 * @Description:
 * 编码，将字符按照指定编码转化为字节数组
 */
public class ContentEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "性命生命使命a";
        //编码：字节数组
        byte[] datas = msg.getBytes();

        System.out.println(datas.length);

        //编码其他字符集
        datas = msg.getBytes("UTF-16");

        //解码
        msg = new String(datas, 0, datas.length, "UTF-16");
        System.out.println(msg);

    }
}