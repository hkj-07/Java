package sort;

public class QuickSort {

    public static void main(String[] args) {

    }
        /*
         * p[]为待查找数组，L,R分别为数组下标，k表示第k大数
         * TopK-快速排序法
         * 时间复杂度O(n)
         * */
        public int findKth(int[] p,int L,int R,int k){
            if(L > R || k < 1) {
                //检查输入参数是否合法
                return -1;
            }
            if(L == R) {
                //如果L等于R说明已找到，直接返回
                return p[R];
            }
            int temp = quickSort(p,L,R);//进行一次快排，返回下标
            if(k+L == temp+1) {
                //如果k+L等于返回的下标加１（L不一定从０开始）
                return p[temp];//则直接返回
            }
            if(k+L < temp+1) {
                //如果k+L小于返回的下标加１
                return findKth(p,L,temp-1,k);//在temp的左边查找第k大数
            } else {

                return findKth(p,temp+1,R,k-(temp-L+1));
            }
        }
       /*
        * 一次快速排序
        ＊以p[L]为比较对象，比p[L]大或等于的在其左边，否则在其右边
        */
        public int quickSort(int[] p ,int L,int R){
            if(L >= R) {
                return -1;
            }
            int i = L;
            int j = R;
            int temp = p[L];
            while(i < j){
                while(i < j && p[j] < temp) {
                    j--;
                }
                if(i < j){
                    p[i] = p[j];
                    i++;
                }
                while(i < j && p[i] > temp) {
                    i++;
                }
                if(i < j){
                    p[j] = p[i];
                    j--;
                }
            }
            p[i] = temp;
            //去掉以下两句注释，再将return注释掉，并且将返回值改为void，
            //就是一个完整的快速排序
            //quickSort(p ,L,i-1);
            //quickSort(p ,i+1,R);
            return i;
        }
}
