import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = first+1;
            int target = -nums[first];
            // 枚举 b
            for (int second = n-1; second >first; second--) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (first < third&&third<second && nums[second] + nums[third] > target) {
                    third++;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

public  class HttpServer{
    public static void main(String[] args) {
        int[] a={-1,0,1,2,-1,-4};
//        a={-1,0,1,2,-1,-4};

        Solution solution=new Solution();
        solution.threeSum(a);
//        System.out.println(solution.threeSum(a));
//        return true;
        String num="3";
        Map<String,String> map=new HashMap<>();
//        List<String> stringList=new ArrayList<>();
//        String
//        stringList.add("ad");
//        stringList.add("bd");
//        stringList.add("cd");
        map.put("2","abc");
//        List<String> stringList2=new ArrayList<>();
//        stringList2.add("ad");
//        stringList2.add("bd");
//        stringList2.add("cde");
//        map.put("2",stringList);
        map.put("3","wxyz");
//        System.out.println(map);
//        System.out.println(map.get(num));map.get(2);
        List<String> res=new ArrayList<>();
//        System.out.println(stringList.get(0));
//        String temp=stringList.get(0) + stringList2.get(0);
//        stringList.get(0) + stringList2.get(0);

        res.add(map.get("3") + map.get("2"));
//        stringList2=map.get("2");
//        System.out.println(stringList2);
        System.out.println(res);
        }
}


