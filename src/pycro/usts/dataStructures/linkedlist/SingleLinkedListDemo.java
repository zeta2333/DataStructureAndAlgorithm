package pycro.usts.dataStructures.linkedlist;

import org.junit.Test;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "公孙胜", "入云龙***");
        HeroNode2 hero5 = new HeroNode2(5, "关胜", "大刀");
        HeroNode2 hero6 = new HeroNode2(6, "林冲", "豹子头");

        //创建单链表
        SingleLinkedList heroList = new SingleLinkedList();
        //加入
//        heroList.add(hero2);
//        heroList.add(hero4);
//        heroList.add(hero3);
//        heroList.add(hero1);
        //按序添加
        heroList.insert(hero2);
        heroList.insert(hero4);
        heroList.insert(hero6);
        heroList.insert(hero3);
        heroList.insert(hero5);
        heroList.insert(hero1);
        heroList.insert(hero1);

        //显示
        heroList.list();

        //测试修改节点的代码
        HeroNode2 hero2_update = new HeroNode2(2, "小卢", "玉麒麟~~");
        heroList.update(hero2_update);

        //显示
        System.out.println("修改后的链表情况:");
        heroList.list();

        //删除指定节点
        int removeNo = 6;
        heroList.remove(removeNo);
//        heroList.list();
//        removeNo = 2;
//        heroList.remove(removeNo);
//        heroList.list();
//        removeNo = 3;
//        heroList.remove(removeNo);
//        heroList.list();
//        removeNo = 1;
//        heroList.remove(removeNo);

        //显示
//        System.out.println("删除后的链表情况:");
//        heroList.list();

        //输出链表长度
        int length = getLength(heroList.getHead());
        System.out.println(length);

        //获取倒数第2个节点
        HeroNode2 node = getNode(heroList.getHead(), 1);
        System.out.println(node);

        //反转单链表
        reverse(heroList.getHead());
        System.out.println("反转后的单链表为：");
        heroList.list();

        //逆序打印单链表
        System.out.println("逆序输出单链表：");
        reversePrint(heroList.getHead());


    }

    @Test
    public void testMerge() {
        //创建两个有序单链表
        SingleLinkedList orderedList1 = new SingleLinkedList();
        orderedList1.insert(new HeroNode2(3, "", ""));
        orderedList1.insert(new HeroNode2(1, "", ""));
        orderedList1.insert(new HeroNode2(4, "", ""));
        orderedList1.insert(new HeroNode2(5, "", ""));

        SingleLinkedList orderedList2 = new SingleLinkedList();
        orderedList2.insert(new HeroNode2(9, "", ""));
        orderedList2.insert(new HeroNode2(2, "", ""));
        orderedList2.insert(new HeroNode2(6, "", ""));


        //输出两个链表
        System.out.println("有序链表1:");
//        orderedList1.list();
        System.out.println("有序链表2:");
//        orderedList2.list();

        //合并
        SingleLinkedList mergeList = mergeOrderedLists(orderedList1.getHead(), orderedList2.getHead());
        //输出合并后的链表
        System.out.println("合并后的链表：");
        mergeList.list();
    }

    //合并两个有序链表，合并后依然有序
    /*
    pre = pre.next 只是修改了变量pre的内存指向
    pre.next = temp1 则是真正修该了内存中pre指向的节点的next属性，即后面跟着的一连串节点
     */
    public static SingleLinkedList mergeOrderedLists(HeroNode2 head1, HeroNode2 head2) {
        SingleLinkedList mergeList = new SingleLinkedList();
        HeroNode2 temp1 = head1.next;
        HeroNode2 temp2 = head2.next;
        //方式1：单独节点add
//        HeroNode cur;
//        while (temp1 != null && temp2 != null) {
//            if (temp1.no < temp2.no) {
//                cur = temp1;
//                temp1 = temp1.next;
//            } else {
//                cur = temp2;
//                temp2 = temp2.next;
//            }
//            cur.next = null;
//            mergeList.add(cur);
//        }
//        mergeList.add(temp1 == null ? temp2 : temp1);
        //方式2：pre尾结点更新
        HeroNode2 pre = mergeList.getHead();
        while (temp1 != null && temp2 != null) {
            if (temp1.no < temp2.no) {
                pre.next = temp1;
                temp1 = temp1.next;
            } else {
                pre.next = temp2;
                temp2 = temp2.next;
            }
            pre = pre.next;
        }
        pre.next = temp1 != null ? temp1 : temp2;

        return mergeList;
    }

    //逆序打印单链表
    /*
    思路1：反转+遍历，（会更改链表的内容，不推荐）
    思路2：将单链表的节点依次压入栈中，利用栈的FILO特性，实现逆序打印。
     */
    //使用思路2实现逆序打印

    /**
     * @param head 头结点
     */
    public static void reversePrint(HeroNode2 head) {
        //创建栈保存单链表的节点
        Stack<HeroNode2> stack = new Stack<>();
        HeroNode2 temp = head.next;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }


    //单链表反转
    /*
    1.先定义一个节点reverseHead作为反转后单链表的头结点
    2.遍历原来的链表，每遍历一个节点，就将其插入头结点之后
     */

    /**
     * @param head 头结点
     */
    public static void reverse(HeroNode2 head) {
        HeroNode2 reverseHead = new HeroNode2(0, "", "");
        //方法一
//        HeroNode temp = head.next;
//        HeroNode cur;//循环中的当前变量
//        while (temp != null) {
//            cur = temp;
//            //使temp沿着原单链表遍历
//            temp = temp.next;
//            //将cur加入新单链表的头结点后
//            cur.next = reverseHead.next;
//            reverseHead.next = cur;
//        }
        //方法二
        HeroNode2 cur = head.next;
        HeroNode2 next;//表示cur的下一个节点
        while (cur != null) {
            next = cur.next;//保存原单链表中cur的下一个节点
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        //重新赋值
        head.next = reverseHead.next;
    }

    //查找单链表中倒数第k个节点
    /*
    1.编写方法，接收head节点和index，index表示倒数第index个节点
    2.先把链表从头到尾遍历，得到链表的长度size（ getLength方法）
    3.得到size后，再次对链表从头开始遍历（size-index）个
    4.如果找到了，则返回该节点否则返回null
     */

    /**
     * @param head  头结点
     * @param index 索引
     * @return 倒数第index个节点
     */
    public static HeroNode2 getNode(HeroNode2 head, int index) {
        //链表为空，返回null
        if (head.next == null) return null;
        //计算链表长度
        int size = getLength(head);
        //判断index合法性
        if (index <= 0 || index > size) return null;
        HeroNode2 temp = head.next;
        for (int i = 0; i < (size - index); i++)
            temp = temp.next;
        return temp;
    }


    //获取单链表节点的个数（带头结点的链表，不统计头结点）

    /**
     * @param head 头结点
     * @return 有效节点个数
     */
    public static int getLength(HeroNode2 head) {
        int size = 0;
        HeroNode2 temp = head.next;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}

//定义SingleLinkedList，管理Hero
class SingleLinkedList {
    //先初始化一个头结点标记单链表起始位置，不能动
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //添加节点到单链表
    //思路：当不考虑顺序时
    //1.找到当前链表的最后节点
    //2.将最后节点的next指向新的节点

    /**
     * 此时添加的节点node是一个next为null的单独节点，不会出现连锁添加的问题
     *
     * @param node
     */
    public void add(HeroNode2 node) {
        //head节点不能动，我们需要一个辅助变量temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (temp.next != null) {
            //找到链表的最后
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp指向链表最后
        //将最后节点的next指向新的节点
        temp.next = node;
    }

    //第二种添加方式，根据排名插入到指定位置
    //如果存在这个排名，则添加失败，并给出提示
    public void insert(HeroNode2 node) {
        //因为头结点不可变，仍然通过辅助变量temp来找到添加的位置
        //因为是单链表，所以temp需要是添加位置的前一个节点
        HeroNode2 temp = head;
        boolean flag = false;//标志添加的编号是否存在,默认为false
        while (true) {
            if (temp.next == null || temp.next.no > node.no) //说明temp在链表的最后 或者 位置找到了，在temp后面添加
                break;
            else if (temp.next.no == node.no) {//说明编号已存在
                flag = true;//编号存在
                break;
            }
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {//不能添加，说明flag已存在
            System.out.printf("准备插入的英雄的编号%d已经存在,不能加入\n", node.no);
        } else {//可以插入
            node.next = temp.next;
            temp.next = node;
        }
    }

    //根据编号修改节点的信息，编号不能修改
    public void update(HeroNode2 node) {
        //找到需要修改的节点
        //定义辅助变量temp
        HeroNode2 temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;//到链表的最后，已经遍历完链表
            }
            if (temp.no == node.no) {//找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到目标节点
        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.printf("没有找到编号为%d的节点，不能修改\n", node.no);
        }
    }

    //根据编号删除节点
    public void remove(int removeNo) {
        //辅助变量temp
        HeroNode2 temp = head;
        boolean flag = false;//表示是否找到目标节点
        while (true) {
            //遍历完了
            if (temp.next == null)
                break;
            //找到了，此时temp为目标节点的前一个节点
            if (temp.next.no == removeNo) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //可以删除了
        if (flag) {
            temp.next = temp.next.next;
            System.out.printf("成功删除编号为%d的节点\n", removeNo);
        } else {//未找到
            System.out.printf("没有找到编号为%d的节点，不能删除\n", removeNo);
        }
    }

    //显示链表（遍历）
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空!");
            return;
        }
        //因为头结点不可变，需要一个辅助变量temp
        HeroNode2 temp = head.next;
        while (temp != null) {//判断是否到最后
            //输出节点信息
            System.out.println(temp);
            //将next后移
            temp = temp.next;
        }
    }
}

//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}