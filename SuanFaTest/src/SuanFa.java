import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class SFList{
    public void QuickSort(int[] num,int right,int left){
        if(right>=left){
            return;
        }
        int key=num[left];
        int i=left;
        int j=right;
        while(i<j){
            while (num[j]>=key&&i<j){
                j--;
            }
            while(num[i]<=key&&i<j){
                i++;
            }
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        QuickSort(num,left,i-1);
        QuickSort(num,i+1,right);
        System.out.println(arrayToString(num,"排序"));
    }
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
    public void buildHeap(int[] nums){
        //建立大顶堆
        int len=nums.length;
        int[] a=new int[len+1];
        for(int i=0;i<nums.length;i++){
            a[i+1]=nums[i];
        }
        //下沉建堆
        for(int i=len/2;i>=1;i--){
            sink(a,i,len);
        }
        int k=len;
        //排序
        while(k>1){
            swap(a,1,k--);
            sink(a,1,k);
        }
        for(int i=1;i<len+1;i++){
            nums[i-1]=a[i];
        }

    }
    public void sink(int[] nums,int k,int end){
        //下沉操作
        while(2*k<=end){
            int j=2*k;
            //找出子节点中最大或最小的那个
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            if(nums[j]>nums[k]){
                swap(nums,j,k);
            }else {
                break;
            }
            k=j;
        }
    }
    public void buildMaxHeap(int[] a,int heapSize){
        //手写构建最大堆
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
    private static String arrayToString(int[] arr,String flag) {
        String str = "数组为("+flag+")：";
        for(int a : arr) {
            str += a + "\t";
        }
        return str;
    }
    public static void quick(int[] arr,int start,int end){

        //如果开始位置和结束位置重合，实际上就是一个数字，所以开始位置一定要比结束位置小，而且不能相等
        if(start < end){
            //设定标准数，也就是快速排序的过程中，和谁进行比较，通常用第一个数字即可
            //注意这里用的是arr[start],按说在第一次的时候是0，应该写成arr[start],但是不可以
            //因为快速排序是一个递归的操作，第二次进来的时候，就不是arr[0]了
            int stand = arr[start];
            //开始找开始位置和结束位置
            //我们知道快速排序其实就是有一个开始位置和一个结束位置，当开始位置比选定的标准数字大的时候，就会替换掉
            //结束位置的数字，这个时候结束位置的下表开始向前移动，然后如果结束位置的数字比标准数字，则替换开始位置的数字
            //在循环的过程中如果开始位置/结束位置的数字 不比标准数字大或者小，这个时候开始位置和结束位置就会向后/向前移动
            //开始位置
            int low = start;
            //结束位置
            int high = end;
            while (low<high){
                //这个时候我们已经找定了开始位置和结束位置
                //第一次是要拿高位和低位进行比较,如果高位比标准数字大，则高位则向前移动一位
                while (low < high && arr[high] >=stand){
                    high--;
                }
                //当然了并不是所有高位数字都比低位大，如果比低位要小，则这个数字要覆盖低位的数字
                arr[low] = arr[high];
                //然后这个时候低位开始移动，如果低位比标准数字小，则低位的下标向后移动一位
                while (low < high && arr[low] <=stand){
                    low++;
                }
                //当然了并不是所有时候低位都比标准数字要小，如果比标准数字大的话，这个时候就要替换掉高位的数字
                arr[high] = arr[low];
            }
            //经过上面的一番折腾，这个时候就会出现一个情况，低位和高位相同，那么这个位置就用标准数字去替换
            //这里low和high实际上是相同的数字，所以写哪个都无所谓
            arr[low] = stand;
            //然后第一轮排序完毕，我们就会发现以标准数字为分界线，我们有两个学列了，这个时候，我们就调用递归来
            //分别对两个序列进行排序
            //先出来低位的递归,最后的位置实际上有可能是高位，有可能是低位，既然上面写的是低位，这里就写低位就好了
            quick(arr,start,low-1);
            //然后出来高位的数字
            quick(arr,low+1,end);
        }
    }
    public void QuickSortTest(int[] num, int left, int right){
        if(left<right){

            int key=num[left];
            int low=left;
            int high =right;
            while(low<high ){
                while (low<high&&num[high ]>=key ){
                    high --;
                }
                num[low] = num[high];
                while(low<high&&num[low]<=key ){
                    low++;
                }
                num[high] = num[low];
            }
            num[low]=key;
            QuickSortTest(num,left,low-1);
            QuickSortTest(num,low+1,right);
        }
    }
    public void BubbleSort(int[] nums){
        //简单排序算法：冒泡排序
        //冒泡排序的基本思想是，两两比较相邻记录的关键字，如果是反序则交换，直到没有反序为止。
        // 冒泡一次冒泡会让至少一个元素移动到它应该在的位置，那么如果数组有 n 个元素，重复 n 次后则能完成排序。
        // 根据定义可知那么冒泡排序显然是一种比较类排序。
        //在实现代码上，如果该数据已经有序，我们还要继续判断，那么我们需要在其中插入一个标志位
        //如果没有交换，说明是有序的，直接跳过循环
        //时间复杂度平均O(n^2),最好O(n),最坏O(n^2)
        int len=nums.length;
        boolean flag=true;
        for(int i=0;i<len&&flag;i++){
            //没有发生交换，依旧为false，下次跳出
            flag=false;
            for(int j=i+1;j<len-i-1;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                    //发生交换，下次继续判断
                    flag=true;
                }
            }
        }
    }
    public void easySort(int[] nums){
        //简单排序算法：简单选择排序
        //主要思路就是我们每一趟在 n-i+1 个记录中选取关键字最小的记录作为有序序列的第 i 个记录。
        int len=nums.length;
        int min=0;//存的索引
        for(int i=0;i<len;i++){
            min=i;
            for(int j=i+1;j<len;j++){
                if(nums[min]>nums[j]){
                    min=j;
                }
            }
            if(min!=i){
                swap(nums,i,min);
            }
        }
    }
    public void SIsort(int[] nums){
        //直接插入排序
        int len=nums.length;
        for(int i=1;i<len;i++){
            int temp=nums[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(temp<nums[j]){
                    nums[j+1]=nums[j];
                    continue;
                }
                break;
            }
            nums[j+1]=temp;
        }
    }
    public void ShellSort(int[] nums){
        //希尔排序
        int increment=nums.length;
        while(increment>1){
            increment=increment/2;
            for(int i=1;i<increment;i++){
                for(int j=i+increment;j<nums.length;j+=increment){
                        int temp=nums[j];
                        int k;
                        for(k=j-increment;k>=0;k-=increment){
                            if(temp<nums[k]){
                                nums[k+increment]=nums[k];
                                continue;
                            }
                            break;
                        }
                        nums[k+increment]=temp;
                }
            }
        }
    }
    public void mergeSort(int[] nums){
        //归并排序
        mergesort(nums,0,nums.length-1);
    }
    public void mergesort(int[] nums,int left,int right){
        if(left<right){
            int mid=left+((right-left)>>1);
            mergesort(nums,left,mid);
            mergesort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }
    public void merge(int[] arr,int left,int mid,int right){
        //第一步，定义一个新的临时数组
        int[] temparr = new int[right -left + 1];
        int temp1 = left, temp2 = mid + 1;
        int index = 0;
        //对应第二步，比较每个指针指向的值，小的存入大集合
        while (temp1 <= mid && temp2 <= right) {
            if (arr[temp1] <= arr[temp2]) {
                temparr[index++] = arr[temp1++];
            } else {
                temparr[index++] = arr[temp2++];
            }
        }
        //对应第三步，将某一小集合的剩余元素存到大集合中
        if (temp1 <= mid) {
            System.arraycopy(arr, temp1, temparr, index, mid - temp1 + 1);
        }
        if (temp2 <= right) {

            System.arraycopy(arr, temp2, temparr, index, right -temp2 + 1);
        }
        //将大集合的元素复制回原数组
        System.arraycopy(temparr,0,arr,0+left,right-left+1);
    }
}
public class SuanFa {
    public static void main(String[] args){
    int[] a={3,45,78,64,52,11,64,55,99,11,18};
    SFList test=new SFList();
//        quick(a,0,a.length-1);
   test.QuickSortTest(a,0,a.length-1);
    System.out.println(arrayToString(a,"排序"));
        Queue<Integer> queue=new ArrayDeque<>();
//        queue.add();
//        queue.offer();
    }

    private static String arrayToString(int[] arr,String flag) {
        String str = "数组为("+flag+")：";
        for(int a : arr) {
            str += a + "\t";
        }
        return str;
    }


}
