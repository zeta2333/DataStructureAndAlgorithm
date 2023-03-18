package pycro.usts.dataStructures.linkedlist;

/**
 * @Author Pycro
 * @Create 2023-03-07  17:56
 * @Description
 * @Version 1.0
 */
public class Josephu {
    public static void main(String[] args) {
        //测试环形链表的构建与遍历
        CircleSingleLinkedList list = new CircleSingleLinkedList();
//        list.addBoy(25);
        list.showBoy();
//        list.countBoy(7,3,25);
    }
}


//创建一个环形的单向链表
class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first;

    //添加节点（一次性添加完），构建成一个环形链表
    public void addBoy(int nums) {
        //对nums数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确！");
        }
        Boy curBoy = null;//辅助指针，用于构建环形链表
        //使用for循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建Boy节点
            Boy boy = new Boy(i);
            //如果是第一个Boy
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//让curBoy指向第一个Boy
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空！");
            return;
        }
        //因为first不能动，我们仍然使用辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            //遍历结束
            if (curBoy.getNext() == first) return;
            System.out.printf("Boy的编号:%d\n", curBoy.getNo());
            curBoy = curBoy.getNext();//curBoy后移
        }
    }

    //根据用户的输入，计算出小孩出圈的顺序

    /**
     * @param startNo  表示从第几个开始
     * @param countNum 表示数几下
     * @param nums     表示最初的数量
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行检验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        //创建一个helper辅助指针指向最后一个节点，帮助完成小孩出圈
        Boy helper = first;
        while (true) {
            //helper指向最后一个节点
            if (helper.getNext() == first) break;
            helper = helper.getNext();
        }
        //让first和helper前移startNo-1位
        for (int i = 0; i < startNo - 1; i++) {
            helper = helper.getNext();
            first = first.getNext();
        }
        //循环：helper和first移动countNum-1次，然后出圈
        //直至圈中只剩一个节点为止
        while (true) {
            //圈中只有一个节点
            if (helper == first) break;
            //移动countNum-1次
            for (int i = 0; i < countNum - 1; i++) {
                helper = helper.getNext();
                first = first.getNext();
            }
            //此时first指向的节点即为要出圈的节点
            System.out.printf("出圈Boy:%d\n", first.getNo());
            //出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的Boy为：%d\n", first.getNo());
    }
}

//创建一个Boy类，表示一个节点
class Boy {
    private int no;//编号
    private Boy next;//指向下一个节点，默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}