import java.lang.*;
import java.util.*;

/**
 * ClassName:MyArrayList
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/12/26 9:31
 * @Author:DangWei
 */
public class MyArrayList<E> {
    private static final int MAXSIZE=10;
    private Object[] arr;
    private int size;
    public MyArrayList(){
        this.arr=new Object[MAXSIZE];
        this.size=0;
    }
    //扩容
    private void grow(int len){
        if(len>arr.length){
            arr=Arrays.copyOf(arr,Math.max(arr.length+arr.length>>1,len));
        }
    }
    //尾插
    public boolean add(E e){
        grow(size+1);
        arr[size++]=e;
        return true;
    }
    //任意位置插入
    public void addIndex(int index,E e){
        if(index<0||index>size){
            return ;
        }
        grow(size+1);
        System.arraycopy(arr,index,arr,index+1,size-index);
        arr[index]=e;
        size++;
    }
    //删除任意位置的元素
    public E remove(int index){
        if(index<0||index>=size){
            return null;
        }
        E value=(E)arr[index];
        if(size-index-1>0){
            System.arraycopy(arr,index+1,arr,index,size-index-1);
        }
        size--;
        return value;
    }
    //获取指定位置的元素
    public E get(int index){
        if(index<0||index>=size){
            return null;
        }
        return (E)arr[index];
    }
    //修改任意位置的元素
    public boolean set(int index,E e){
        if(index<0||index>=size){
            return false;
        }
        arr[index]=e;
        return true;
    }
    //查找指定元素的下标
    public int indexOf(E e){
        for(int i=0;i<size;i++){
            if(arr[i]==e){
                return i;
            }
        }
        return -1;
    }
    //判断是否包含指定元素
    public boolean contains(E e){
        return indexOf(e)>=0;
    }
    //获取长度
    public int size(){
        return size;
    }
    //打印
    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //清空
    public void clear(){
        size=0;
    }
}
class TestD{
    public static void main(String[] args) {
        MyArrayList<Integer> array=new MyArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(1);
        array.add(2);
        array.add(3);
        array.addIndex(2,6);
        array.addIndex(1,8);
        array.addIndex(0,9);
        array.addIndex(6,9);
        array.addIndex(3,7);
        array.addIndex(3,0);
        array.addIndex(1,8);
        array.addIndex(0,9);
        array.addIndex(6,9);
        array.print();
        System.out.println("长度为：");
        System.out.println(array.size());
        System.out.println(array.remove(0));
        System.out.println(array.remove(0));
        System.out.println(array.remove(array.size()-1));
        System.out.println(array.remove(array.size()));
        array.print();
        System.out.println("长度为：");
        System.out.println(array.size());
        System.out.println("下标为三的元素是：");
        System.out.println(array.get(3));
        System.out.println("设置下标为3的元素：");
        array.set(3,100);
        array.print();

        MyArrayList<String> s=new MyArrayList<>();
        s.add("h");
        s.add("a");
        s.add("q");
        s.add("w");
        s.add("e");
        s.add("t");
        s.add("j");
        s.add("k");
        s.add("f");
        s.add("d");
        s.add("l");
        s.add("m");
        s.print();
        System.out.println(s.size());
    }
}
