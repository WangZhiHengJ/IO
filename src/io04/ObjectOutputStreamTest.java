package io04;

import java.io.*;

/**
 * @Auther: 王志恒
 * @Date: 2019/7/24 15:21
 * @Description:
 * 序列化与反序列化
 */
public class ObjectOutputStreamTest {

    public static void main(String[] args) {

        //写入数组 读取
        writeByteArray();

        //写入文件读取
        writeFile("resource/serialization");
    }

    public static void writeFile(String filePath) {

        try {
            System.out.println("<<<<<<<<<<        writeByteArray      >>>>>>>>>>>");
            //序列化 到文件
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));
            String str = "此处创建了两个String对象";
            oos.writeUTF(str);
            oos.writeBoolean(false);
            oos.writeInt(123);
            oos.writeObject("str对象");
            Person p = new Person();
            oos.writeObject(p);
            oos.flush();
            oos.close();
            //反序列化 从文件读取
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)));
            System.out.println(ois.readUTF());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readInt());

            Object strTemp = ois.readObject();
            if (strTemp instanceof String) {
                String strObj = (String) strTemp;
                System.out.println(strObj);
            }

            Object personTemp = ois.readObject();
            if (personTemp instanceof Person) {
                Person pObj = (Person)personTemp;
                System.out.println(pObj.getName() + ">>>" + pObj.getMoney());
            }
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeByteArray() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.out.println("<<<<<<<<<<        writeByteArray      >>>>>>>>>>>");

        try {
            //序列化
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
            String str = "此处创建了两个String对象";
            oos.writeUTF(str);
            oos.writeBoolean(false);
            oos.writeInt(123);
            oos.writeObject("str对象");
            Person p = new Person();
            oos.writeObject(p);
            oos.flush();
            oos.close();
            //反序列化
            byte[] datas = baos.toByteArray();
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
            System.out.println(ois.readUTF());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readInt());

            Object strTemp = ois.readObject();
            if (strTemp instanceof String) {
                String strObj = (String) strTemp;
                System.out.println(strObj);
            }

            Object personTemp = ois.readObject();
            if (personTemp instanceof Person) {
                Person pObj = (Person)personTemp;
                System.out.println(pObj.getName() + ">>>" + pObj.getMoney());
            }

            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {

        }


    }
}
class Person implements Serializable{
    private String name = "张三";
    private double money = 200.5;

    public  Person() {
    }

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}

