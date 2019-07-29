package io02;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/19 21:41
 * @Description:
 */
public class IOtest02 {
    public static void main(String[] args) {
        //1 、 创建源
        File file = new File("adb.txt");
        //2、选择流
        InputStream is =null;
        try {
            is = new FileInputStream(file);
            int temp = is.read();
            while (temp != -1) {
                //这里每次从文件读出来的是  值字节被返回作为int范围0至255
                //方法重载了，read里面的的参数不一致返回的值也不是固定的，如03所示，虽然都是int，
                // 但在那里int表示的是每次读取的长度
                temp = is.read();
                System.out.println((char) temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}