// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IOTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //总共数据数量
        int n = sc.nextInt();
        sc.nextLine();
        jishu jishu = new jishu();
//        StringBuffer spString= new StringBuffer(n*2);
//        String s = sc.nextLine();
        String s=sc.nextLine();
        int size = 0;
        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
////            String temp= sc.next();
//            s = s + " " + sc.nextLine();
////            spString.append(" "+temp);
////            spString.append(" "+sc.nextLine());
//            if (i == n ) {
//                size = jishu.fanhui(map, s);
//            }
////            System.out.println(s);
//        }
//        String temp;
        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            s = s + " " + temp;
//            System.out.println(s);
            if (sc.nextLine().isEmpty()) {
                size = jishu.fanhui(map, s);
                break;
            }
        }
        System.out.println(size);
//        System.out.println(spString);
//        String[] split=s.split(" ");
//        //放进map中，key为userid
//        for(int i=0;i<split.length;i++){
//
//            map.put(split[i],split[j]);
//
//        }
//        Map<String,String> res=new HashMap<>();
//        for(Map.Entry<String, String> entry:map.entrySet()){
//            if(res.containsKey(entry.getValue())){
//                res.put(entry.getValue(),res.get(entry.getValue())+1);
//            }else{
//                res.put(entry.getValue(), String.valueOf(1));
//            }
//        }
////        System.out.println();
////        System.out.println(res.size());
//    }

    }
}

class jishu {
    public int fanhui(Map<String, Integer> map, String s) {
        String[] split = s.split("\\s+");
        System.out.println(split);
        for (int i = 0; i < split.length; i++) {
            int j=i+1;
            map.put(split[i], Integer.valueOf(split[j]));
            i=j;
        }
        Map<Integer, Integer> res = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (res.containsKey(entry.getValue())) {
                res.put(entry.getValue(), res.get(entry.getValue()) + 1);
            } else {
                res.put(entry.getValue(), 1);
            }
        }
//        System.out.println();
        return res.size();
    }

}