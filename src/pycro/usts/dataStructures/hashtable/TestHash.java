package pycro.usts.dataStructures.hashtable;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-21 4:01 PM
 */
public class TestHash {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(3);
        Student s1 = new Student(1, "张三");
        Student s2 = new Student(2, "李四");
        Student s3 = new Student(3, "王五");
        Student s4 = new Student(4, "陈六");
        Student s5 = new Student(5, "周七");
        //添加
        hashTable.add(s1);
        hashTable.add(s2);
        hashTable.add(s3);
        hashTable.add(s4);
        hashTable.add(s5);
        //查看
        hashTable.list();
        //查询
        Student student = hashTable.fingById(4);
        System.out.println(student);
    }
}
