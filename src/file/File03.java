package file;

import java.io.File;

public class File03 {

    public static void main(String[] args) {

        String path = "D:\\ideaProjects\\Base\\IO\\src\\file";

        File file = new File(path+"/test");
        //创建目录 mkdirs 如果上级目录不存在会创建失败
        boolean flag  = file.mkdir();
        System.out.println(flag);
        File file2 = new File(path+"/test/01/02/03");
        //如果上级目录不存，会创建上级目录
        flag = file2.mkdirs();
        System.out.println(flag);

        //下级名称 list
        File file3 = new File(path);
        String[] names = file3.list();
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("----------------===");
        //下级文件对象
        File[] files = file3.listFiles();
        for (File temp : files) {
            System.out.println(temp);
        }

        System.out.println("----------------===");
        //所有盘符
        File[] roots = file3.listRoots();
        for (File temp: roots) {
            System.out.println(temp);
        }
    }
}
