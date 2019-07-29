package CommonsIO;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/27 15:46
 * @Description:
 * 写出内容
 */
public class CIOTest04 {
    public static void main(String[] args) {


        try {
            //写出文件
            FileUtils.write(new File("resource/vvv.txt"), "学习是一件伟大的事情\n", "utf8");
            FileUtils.writeStringToFile(new File("resource/vvv.txt"), "学习是一件辛苦的事业\n", "utf8", true);
            FileUtils.writeByteArrayToFile(new File("resource/vvv.txt"), "学习是一件幸福的事业\n".getBytes("utf8"), true);

            //写出列表
            List<String> list = new ArrayList<>();
            list.add("张三");
            list.add("李四");
            list.add("王五");
            FileUtils.writeLines(new File("resource/mm.txt"), list, ">>>", true);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}