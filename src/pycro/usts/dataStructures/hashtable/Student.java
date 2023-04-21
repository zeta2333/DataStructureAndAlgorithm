package pycro.usts.dataStructures.hashtable;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-21 3:10 PM
 */
//学生节点类
public class Student {
    public int id;
    public String name;
    public Student next;//指向下一个学生节点

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

