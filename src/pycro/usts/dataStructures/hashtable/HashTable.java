package pycro.usts.dataStructures.hashtable;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-21 3:42 PM
 */
public class HashTable {
    private StudentLinkedList[] studentLinkedLists;
    private int size;

    /**
     * 初始化，往数组链表中添加对象
     *
     * @param size
     */
    public HashTable(int size) {
        this.size = size;
        studentLinkedLists = new StudentLinkedList[size];
        for (int i = 0; i < size; i++) {
            studentLinkedLists[i] = new StudentLinkedList();
        }
    }

    public HashTable() {
        this(10);
    }

    /**
     * 哈希函数
     *
     * @param sid
     * @return
     */
    public int hashcode(int sid) {
        return sid % size;
    }

    /**
     * 向哈希表中添加元素
     *
     * @param stu
     */
    public void add(Student stu) {
        int hashVal = hashcode(stu.id);//计算哈希值
        //根据哈希值选择对应的链表添加
        studentLinkedLists[hashVal].add(stu);
    }

    /**
     * 根据id从哈希表中查询元素
     *
     * @param sid
     * @return
     */
    public Student fingById(int sid) {
        //计算哈希值
        int hashVal = hashcode(sid);
        //根据哈希值查找对应的链表
        return studentLinkedLists[hashVal].findById(sid);
    }

    /**
     * 遍历哈希表中的所有元素
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            studentLinkedLists[i].list(i);
        }
    }
}
