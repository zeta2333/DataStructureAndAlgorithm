package pycro.usts.dataStructures.hashtable;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-21 3:16 PM
 */
public class StudentLinkedList {
    private Student head;//头结点

    /**
     * 添加节点
     *
     * @param newStu
     */
    public void add(Student newStu) {
        //如果头结点为空，则直接赋值
        if (head == null) {
            head = newStu;
            return;
        }
        //头结点不为空的情况下，找到链表的最后一个节点，在其后面添加
        //临时节点，从头结点开始
        Student temp = head;
        //循环，找到当前链表的尾结点
        while (temp.next != null) temp = temp.next;
        //追加新的节点
        temp.next = newStu;
    }

    /**
     * 查看数据
     *
     * @param no
     */
    public void list(int no) {
        if (head == null) {
            System.out.printf("第%d个链表为空...\n", no);
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.printf("id = %d, name = %s\t", temp.id, temp.name);
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 根据id查询节点
     *
     * @param id
     * @return
     */
    public Student findById(int id) {
        if (head == null) {
            System.out.println("空链表...");
            return null;
        }
        //遍历
        Student temp = head;
        while (temp != null) {
            if (temp.id == id) break;
            temp = temp.next;
        }
        return temp;
    }
}
