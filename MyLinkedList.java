import java.util.LinkedList;
/**
 * ClassName:MyLinkedList
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/12/26 14:53
 * @Author:DangWei
 */
class Node<E>{
    public E val;
    public Node<E> pre;
    public Node<E> next;
    public Node(Node<E> pre,E e,Node<E> next){
        this.val=e;
        this.pre=pre;
        this.next=next;
    }
}
public class MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyLinkedList(){

    }
    //头插
    public void addFirst(E e){
        Node<E> f=first;
        Node<E> node=new Node<>(null,e,f);
        first=node;
        if(f==null){
            last=node;
        }else{
            f.pre=first;
        }
        size++;
    }
    //尾插
    public void addLast(E e){
        Node<E> l=last;
        Node<E> node=new Node<>(l,e,null);
        last=node;
        if(l==null){
            first=node;
        }else{
            l.next=last;
        }
        size++;
    }
    //在suc结点前插入一个新结点
    public void addBefore(E e,Node<E> suc){
        Node<E> pre=suc.pre;
        Node<E> node=new Node<>(pre,e,suc);
        if(pre==null){
            first=node;
        }else{
            pre.next=node;
        }
        size++;
    }
    //删除头结点
    public E removeFirst(){
        E element=first.val;
        Node<E> next=first.next;
        first.val=null;
        first.next=null;
        first=next;
        if(next==null){
            last=null;
        }else{
            next.pre=null;
        }
        size--;
        return element;
    }
    //删除尾结点
    public E removeLast(){
        E element=last.val;
        Node<E> pre=last.pre;
        last.val=null;
        last.pre=null;
        last=pre;
        if(pre==null){
            first=null;
        }else{
            pre.next=null;
        }
        size--;
        return element;
    }
    //删除指定结点
    public E remove(Node<E> node){
        E element=node.val;
        Node<E> pre=node.pre;
        Node<E> next=node.next;
        node.val=null;
        node.pre=null;
        node.next=null;
        if(pre==null){
            first=next;
        }else{
            pre.next=next;
        }

        if(next==null){
            last=pre;
        }else{
            last.pre=pre;
        }
        size--;
        return element;
    }
    //删除指定元素
    public boolean remove(E e){
        Node<E> cur=first;
        if(e==null){
            while(cur!=null){
                if(cur.val==null){
                    remove(cur);
                    return true;
                }
                cur=cur.next;
            }
        }else{
            while(cur!=null){
                if(e.equals(cur.val)){
                    remove(cur);
                    return true;
                }
                cur=cur.next;
            }
        }
        return false;
    }
    //获取指定位置元素
    public E get(int index){
        if(index<0||index>=size){
            return null;
        }
        Node<E> cur=first;
        while(index!=0){
            cur=cur.next;
            index--;
        }
        return cur.val;
    }
    //将元素放在指定位置
    public boolean setIndex(int index,E e){
        if(index<0||index>=size){
            return false;
        }
        Node<E> cur=first;
        while(index!=0){
            cur=cur.next;
            index--;
        }
        cur.val=e;
        return true;
    }
    //获取长度
    public int size(){
        return size;
    }
    @Override
    public String toString(){
        StringBuffer sb=new StringBuffer();
        Node<E> cur=first;
        while(cur!=null){
            sb.append(cur.val).append(" ");
            cur=cur.next;
        }
        return new String(sb);
    }
}
class Test{
    public static void main(String[] args) {
        MyLinkedList<Integer> l=new MyLinkedList<>();
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);
        l.addLast(4);
        l.addLast(5);
        l.addLast(6);
        System.out.println(l);
        System.out.println("长度为：");
        System.out.println(l.size());
        l.removeFirst();
        l.removeLast();
        System.out.println(l);
        System.out.println("长度为：");
        System.out.println(l.size());
    }
}
