package sort;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {

    }
    public int[] SeSort(int[] nums){
        int increament=nums.length;
        while(increament>1){
            increament=increament/2;
            //根据增量分组
            for(int i=0;i<increament;i++){
                //类似直接插入排序
                for(int j=i+increament;j<nums.length;j=j+increament){
                    int temp=nums[j];
                    int k;
                    for(k=j-increament;k>=0;k-=increament){
                        if(temp<nums[k]){
                            nums[k+increament]=nums[k];
                            continue;
                        }
                        break;
                    }
                    nums[k+increament]=temp;
                }
            }
        }
        return nums;
    }
}
