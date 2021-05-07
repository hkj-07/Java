/**
 *手写一个arrayqueue
 */

public class MyQueue {
    private Object[] queue;
    private int head;
    private int tail;
    private int size;
    private final static int MAX_CAPACITY=1<<30;
    //数组长度
    private int capacity;
    //最大下标
    private int maxIndex;
    public MyQueue(int initialCapacity){
        if (initialCapacity > MAX_CAPACITY)
        {throw new OutOfMemoryError("initialCapacity too large");}
        if (initialCapacity <= 0)
        {throw new IndexOutOfBoundsException("initialCapacity must be more than zero");}
        queue = new Object[initialCapacity];
        capacity = initialCapacity;
        maxIndex = initialCapacity - 1;
        head = tail = -1;
        size = 0;
    }
    public MyQueue(){
        queue=new Object[16];
        capacity=16;
        head=tail=-1;
        size=0;
        maxIndex=15;
    }
    //往队列尾部中添加数据
    public void offer(Object object){
        if(size>capacity){
            System.out.println("queue's size more than or equal to array's capacity");
            return;
        }
        if(++tail>maxIndex){
            tail=0;
        }
        queue[tail]=object;
        size++;
    }
    //往队头部拉出数据
    public Object poll(){
        if(size<0){
            System.out.println("the queue is null");
            return null;
        }
        if(++head>maxIndex){
             head=0;
        }
        size--;
        Object old=queue[head];
        queue[head]=null;
        return old;
    }
}
