package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author HKj
 * @Date 2021/6/2
 */
public class Heap {

    /**
     * 二叉堆：
     *      （1）必须是完全二叉树
     *      （2）二叉堆中的每一个根节点，都必须大于等于（或小于等于）其子树中每个节点的值。
     *
     * 若是每个根节点大于等于子树中的每个子节点，我们称之为大顶堆，小于等于子树中的每个子节点，我们则称之为小顶堆。
     */
    /**
     * 堆排序：
     *      (1)构建初始堆：
     *              以大顶堆为例，从最后一个非叶节点开始，如果当前节点小于左右子节点，则与最大的子节点进行交换，如此反复，直到所有父节点都比他的左右子节点大。
     *     （2）进行堆排序：
     *              将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。
     *              然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了。
     *
     */
    /**
     * 算法名称	 最好时间复杂度	最坏时间复杂度	平均时间复杂度  空间复杂度	是否稳定
     * 堆排序	 O(n)	        O(nlogn)	      O(nlogn)      O(1)        不稳定
     */

    public static void main(String[] args) {
        int nums[] = {1, 3, 4, 5, 2, 6, 9, 7, 8, 0};
//        sort(nums);
        minHeap(nums);
        System.out.print(Arrays.toString(nums));
    }
    private static void minHeap(int[] nums){
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            heap.offer(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=heap.poll();
        }
    }

    /**
     * 用数组存储完全二叉树，则满足：
     *      (1) 它的左孩子结点是：R[2*i+1];
     *      (2) 它的右孩子结点是：R[2*i+2];
     *      (3) 它的父结点是：R[(i-1)/2];
     */
    private static void sort(int nums[]){
        int len = nums.length;
        int[] a=new int[len+1];

        // 从最后一个根节点开始进行下沉建堆
        for (int i = len/2; i >0 ; i--) {
            sink(a, i, len);
        }

        // 下沉排序
        int l = len;
        while (l > 1){
            swap(a, 1, l--); // 堆顶元素与未排序的堆尾元素互换
            sink(a, 1, l); // 互换后进行下沉操作调整堆
        }
        for(int i=1;i<len+1;i++){
            nums[i-1]=a[i];
        }
    }

    /**
     * 下沉操作
     * @param nums  原数组
     * @param k     当前下标
     * @param end   数组长度
     */
    private static void sink(int nums[], int k, int end){
        while (2*k <= end){
            int j = 2*k; // 左节点
            // 找到左右子节点中较大的那个节点
            if (j+1 <= end && nums[j] < nums[j+1]) {
                j++;
            }
            if (nums[k] < nums[j]) {
                swap(nums, k, j);
            }else {
                break;
            }
            k = j; // 把交换后的下标指向当前下标，继续对nums[k]进行下沉建堆
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
