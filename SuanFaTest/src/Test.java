import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String Test(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() < 2) {
            return s;
        }
        int maxlength = 1;//初始的长度应该为1，减少一次循环
        // char[] result;
        List<Character> result = new ArrayList<>();
        int leftindex = 0;
        int rightindex = 0;
        char[] str = s.toCharArray();//转换数组
        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (validTest(str,i,j) && maxlength < j - i + 1) {
                    maxlength = j - i + 1;
                    leftindex = i;
                }
            }
        }
        return s.substring(leftindex, maxlength+leftindex);
    }

    private static boolean validTest(char[] charArray, int left, int right){
        while(left<right){
            if(charArray[left]!=charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args){
        String s="aacabdkacaa";
        System.out.println(Test(s));;
    }
}