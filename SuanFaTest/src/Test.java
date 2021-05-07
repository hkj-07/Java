
import java.util.*;

class Test {
    public int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        int[] ans={-1,-1};
        Set<Integer> lastans1=new HashSet<>();
        List<Integer> lastans=new ArrayList<>();
        // int[] lastans;
        if(len==0){
            return ans;
        }
        int l=0,r=len-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                if(nums[mid+1]==target){
                    lastans1.add(mid+1);
                }
                if(nums[mid-1]==target){
                    lastans1.add(mid-1);
                }
                lastans.add(mid);
            }
            if(target<=nums[mid]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        Collections.sort(lastans);
        if(lastans.size()==1){
            lastans.add(-1);
        }else if(lastans.size()>2){
            List<Integer> ans2=new ArrayList<>();
            ans2.add(lastans.get(0));
            ans2.add(lastans.get(-1));
            lastans=ans2;
        }else if(lastans.size()==0){
            List<Integer> ans3=new ArrayList<>();
            ans3.add(-1);
            ans3.add(-1);
            lastans=ans3;
        }
        int[] intArr = lastans.stream().mapToInt(Integer::intValue).toArray();
        return intArr;
    }
    public int search(int[] nums, int target) {
        int n=nums.length;
        if(n==0){
            return -1;
        }
        if(n==1&&nums[0]==target){
            return 0;
        }else if(n==1&&nums[0]!=target){
            return -1;
        }
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[0]<=nums[mid]){
                if(nums[0]<=target&&target<nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }else {
                if(nums[mid]<target&&target<=nums[r]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return -1;


    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> test=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<Character> stack=new Stack<>();
        stack.peek();
        String s="()()";
//        stack.push()
        test.add(root);
        stack.clear();
        while(test!=null ){
            List<Integer> tmp=new ArrayList<>();

            for(int i=test.size();i>0;i--){
                TreeNode a=test.poll();
                tmp.add(a.val);
                if(a.left!=null){
                    test.add(a.left);
                }
                if(a.right!=null){
                    test.add(a.right);
                }
            }

            if(ans.size()%2!=0){
                Collections.reverse(tmp);
            }

            ans.add(tmp);
        }

        return ans;
    }
        public void nextPermutation(int[] nums){
            int i=nums.length-2;
            while (i>=0&&nums[i]>nums[i+1]){
                i--;
            }
            if(i>=0){
                int j=nums.length-1;
                while (j>=0&&nums[i]>=nums[j]){
                    j--;
                }
                swap(nums,i,j);
            }
            resver(nums,i+1);
        }
        public  void compare(List<Integer> ans){
//            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<ans.size();i++){
                for(int j=i+1;j<ans.size();j++){
                    if(ans.get(i) .equals(ans.get(j))){
                        ans.remove(j);
                    }
                }
            }

        }
    public void resver(int[] nums,int start){
        int i=start,j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp=0;
        temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public ListNode hebing(ListNode l1,ListNode l2){
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode dump=new ListNode(0);
        ListNode cur=dump,a=l1,b=l2;
        while (a!=null&&b!=null){
            if(a.val<b.val){
                cur.next=a;
                a=a.next;
            }else{
                cur.next=b;
                b=b.next;
            }
            cur=cur.next;
        }
        if(a==null){
            cur.next=b;
        }else{
            cur.next=a;
        }
        return dump.next;
    }

}
class TreeNode{
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution{

    public  static  void main(String[] args){
        Test test=new Test();
//        ListNode a=new ListNode();
////        test.mergeKLists(a);
//        int[] as={1,2,2,3,3,5};
//        int[] com={1,2,2,3,5,3};
//        int[] aa=com;
//        Arrays.sort(com);
//        if(Arrays.equals(com,as)){
//            System.out.println("一样");
//        }else {
//            System.out.println("不一样");
//        }
//        List<Integer> list= new ArrayList<>();
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(3);
//        list.add(6);
//        list.add(3);
//
//        test.compare(list);
////        System.out.printf(list);
//        for (int a:list
//             ) {
//            System.out.printf(String.valueOf(a));
//
//        }
        String s=")()())";
//        int a=test.longestValidParentheses(s);
        int[] a={5,7,7,8,8,10};

//        Arrays.sort(new List[]{lastans});
        System.out.println(test.searchRange(a,8));


    }
}


