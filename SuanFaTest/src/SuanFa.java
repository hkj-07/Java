import java.util.Comparator;
import java.util.PriorityQueue;

class SFList{
    public int  binarySearch(int[] source,int target){
        //二分查找(寻找一个数)
        int left=0,right=source.length-1;
        int ans=Integer.MIN_VALUE;
        while(left<=right){
            //为了防止mid溢出。所以采用mid=left+(right+left)/2
            int mid=left+(right-left)/2;
            if(source[mid]==target){
                return mid;
            }else if(source[mid]<right){
                left=mid+1;
            }else if(source[mid]>target){
                right=mid-1;
            }
        }
        return -1;
    }
    public void buildMinHeapByApi(int[] a){
        //通过java自带的优先队列，实现小顶堆
        //默认实现的是小顶堆，同时循环输出的是顺序的
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            minHeap.offer(a[i]);
        }
    }
    public void buildMaxHeapByApi(int[] a){
        //通过比较器排序，实现最大堆
        //可以
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                /**以下是对比较器升序、降序的理解.
                 *(1) 写成return o1.compareTo(o2) 或者 return o1-o2表示升序
                 *(2) 写成return o2.compareTo(o1) 或者return o2-o1表示降序
                 */
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<a.length;i++){
            maxHeap.offer(a[i]);
        }
    }
    public void buildMaxHeap(int[] a,int heapSize){
        //构建最大堆
        for(int i=heapSize/2;i>=0;i--){
            maxHeapify(a,i,heapSize);
        }
    }
    public void maxHeapify(int[] a, int i, int heapSize) {
        int l=i*2+1,r=i*2+2,largest=i;
        if(l<heapSize&&a[l]>a[largest]){
            largest=l;
        }
        if(r<heapSize&&a[r]>a[largest]){
            largest=r;
        }
        if(largest!=i){
            swap(a,i,largest);
            maxHeapify(a,largest,heapSize);
        }
    }
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
public class SuanFa {
    public static void main(String[] args){

    }
}
