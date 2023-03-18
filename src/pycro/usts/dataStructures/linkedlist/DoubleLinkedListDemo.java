package pycro.usts.dataStructures.linkedlist;

@SuppressWarnings("all")
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试");
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "公孙胜","入云龙");
        HeroNode2 hero5 = new HeroNode2(5, "关胜", "大刀");
        HeroNode2 hero6 = new HeroNode2(6, "林冲", "豹子头");
        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.insert(hero3);
        doubleLinkedList.insert(hero1);
        doubleLinkedList.insert(hero2);
        doubleLinkedList.insert(hero6);
        doubleLinkedList.insert(hero5);
        doubleLinkedList.insert(hero4);

        //输出
        doubleLinkedList.list();

        //修改
        HeroNode2 newHero = new HeroNode2(6, "零充", "豹子头");
        doubleLinkedList.update(newHero);
        System.out.println("修改后:");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.remove(3);
        System.out.println("删除后:");
        doubleLinkedList.list();

    }
}

//创建一个双向链表类
class DoubleLinkedList {
    //初始化一个头结点
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头结点
    public HeroNode2 getHead() {
        return head;
    }

    //双向链表删除节点
    //找待删除节点自身，找到后自我删除即可
    public void remove(int removeNo) {
        //辅助变量temp,直接从第一个节点开始
        HeroNode2 temp = head.next;
        boolean flag = false;//表示是否找到目标节点
        while (true) {
            //遍历完了
            if (temp == null)
                break;
            //找到了，此时temp为目标节点的前一个节点
            if (temp.no == removeNo) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //TodO 变量在左边为指针，在右边为节点
        //可以删除了
        if (flag) {
            //前节点next指向后节点
            temp.pre.next = temp.next;
            //后节点next指向前节点
            //需要判断temp是否为最后一个节点
            if (temp.next != null) temp.next.pre = temp.pre;
            System.out.printf("成功删除编号为%d的节点\n", removeNo);
        } else {//未找到
            System.out.printf("没有找到编号为%d的节点，不能删除\n", removeNo);
        }
    }

    //按序添加（插入）
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
            node.pre = temp;
            //判断当temp不是尾结点时，进行的连接操作
            if(temp.next!=null){
                node.next = temp.next;
                temp.next.pre = node;
            }
            temp.next = node;
        }
    }

    //修改，双向链表的修改和单链表几乎一样，只是节点的类型不同
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

    //添加到末尾add
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
        //将新节点的pre指向当前的最后节点
        temp.next = node;
        node.pre = temp;
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

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;//指向后一个节点，默认为null
    public HeroNode2 pre;//指向前一个节点，默认为null


    //构造器
    public HeroNode2(int no, String name, String nickName) {
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