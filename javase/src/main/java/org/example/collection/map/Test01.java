package org.example.collection.map;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuliangqi
 * @date 2023/3/17 14:57
 */
public class Test01 {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // 几种浅拷贝
    ArrayList<Person> srcList = new ArrayList<>();
    srcList.add(new Person("1", "1"));
    srcList.add(new Person("2", "2"));
    List<Person> destList = new ArrayList<Person>(srcList.size());
    for (Person p : srcList) {
      destList.add(p);
    }
    System.out.println(destList);

    // 2、使用List实现类的构造方法
    List<Person> destList1 = new ArrayList<Person>(srcList);
    System.out.println(destList1);

    // 3、使用list.addAll()方法
    List<Person> destList2 = new ArrayList<Person>();
    destList2.addAll(srcList);
    System.out.println(destList2);

    // 4、使用System.arraycopy()方法
    Person[] srcPersons = srcList.toArray(new Person[0]);
    Person[] destPersons = new Person[srcPersons.length];
    System.arraycopy(srcPersons, 0, destPersons, 0, srcPersons.length);
    System.out.println(destPersons);
    System.out.println(srcPersons);

    // 几种深拷贝
    // 1.使用序列化方法
    List<Person> destList3 = deepCopy(srcList); // 调用该方法
    System.out.println(destList3);


  }

  public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(byteOut);
    out.writeObject(src);

    ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
    ObjectInputStream in = new ObjectInputStream(byteIn);
    @SuppressWarnings("unchecked")
    List<T> dest = (List<T>) in.readObject();
    return dest;
  }


}
