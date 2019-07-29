package io02;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/19 21:41
 * @Description: 字节数组输入流，跟前面的区别是
 * 前面都是读取硬盘上的数据，这个是读取内存里面的数据。
 * 应用就是，服务器，网络中没有落地的数据。
 */
public class IOtest08 {
    public static void main(String[] args) {

        outputByteArray();

    }

    /**
     * @author: 王志恒
     * @date: 2019/7/20 20:44
     * @param
     * @return:
     * @Description：
     * 需要注意的是将
     * 源：是内部维护
     * 流：不关联源
     * 操作：写出内容
     * 不用释放资源
     *
     * 最后要记得获取数据：toByteArray()
     */


    public static void  outputByteArray() {
        //创建源
        byte[] dest = null;

        //2、选择流

        ByteArrayOutputStream bo = null;

        bo = new ByteArrayOutputStream();

        //3、操作： 写出
        String msg = "多敲代码少放屁";

        byte[] datas = msg.getBytes(); //字符串转数组


        bo.write(datas, 0, datas.length);


        dest = bo.toByteArray();
        String str = new String(dest, 0, dest.length);
        System.out.println(str);

    }


    }