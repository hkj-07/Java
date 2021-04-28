// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IOTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //总共数据数量
        int n = sc.nextInt();
//        sc.nextLine();
//        System.out.println(sc.nextLine());
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        while (index++ < n) {
            String temp = sc.nextLine();
            Integer value = Integer.parseInt(temp.split(" ")[1]);
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        int total = 0;
        for (Integer count : map.values()) {
            if (count > 1) {
                total += count;
            }
        }
        System.out.printf("总数：%d", total);

    }
}
