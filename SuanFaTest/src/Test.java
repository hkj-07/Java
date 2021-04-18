import java.util.*;

class Test {
    public boolean isValid(String s) {
        Deque<Character> stack=new LinkedList<Character>();
        Map<Character,Character> map=new HashMap<Character, Character>(){{
            put('}','{');
            put(']','[');
            put(')','(');

        }};
        int len=s.length();
        System.out.println(len);
        String string=s;
        if(len%2!=0){
            return false;
        }
        for(int i=0;i<len/2;i++){
            stack.push(string.charAt(i));
        }
        System.out.println(stack);
        for(int i=len/2;i<len;i++){
            if(stack.peek().equals(map.get(s.charAt( i)))){
                System.out.println(stack.peek());
                System.out.println(map.get(s.charAt(i)));
                System.out.println(stack.pop());
                System.out.println("下一轮"+i);
                // stack.pop();
//                 continue;
                return false;
            }
        }
        return true;
    }

public boolean swap(char a,char b){
//        if(a==("{")){
//            if(b=="}"){
//                return true;
//            }
//        }

        switch (a){
            case '{':
                if(b=='}'){
                    return true;
                };
            case '[':
                if(b==']'){
                    return true;
                };
            case '(':
                if(b==')'){
                    return true;
                };
            default:
                return false;
        }
    }

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
        String a="23";
//        System.out.println(test.letterCombinations(a));
        ListNode listNode=new ListNode();
        ListNode node=new ListNode(0,listNode);
        ListNode arr=node.next;
//        System.out.println(node);
//        System.out.println(arr);
        Stack<Character>stack=new Stack<>();
        String s="()[]{}";
//        stack.peek();
//        int len=s.length();
//        s.charAt(0);
        test.isValid(s);
        System.out.println(test.isValid(s));

        }
    }


