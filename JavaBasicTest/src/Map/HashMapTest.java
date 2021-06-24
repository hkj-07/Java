package Map;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args){
        HashMap<String,String> map=new HashMap<>();
        HashMap<Integer,Integer> map1=new HashMap<>();
        map1.put(1,2);
//        map1.get(1)=map1.get(1)+1;
        map1.values();
        map1.get(1);
        map.put("san", "张三");
        map.put("si", "李四");
        map.put("wu", "王五");
        map.put("wang", "老王");
        map.put("wang", "老王2");// 老王被覆盖
        map.put("lao", "老王");
        System.out.println(map1.get(1));
        System.out.println(map);
        //获取所有的key
        System.out.println("获取map中所有的key");
        Set<String> keys=map.keySet();
        for (String key:keys
             ) {
            System.out.print(key+" ");

        }

        //获取map中所有的值
        System.out.println("--------------------");
        System.out.println("获取map中所有的value值");
        Collection<String> values=map.values();
        for (String value:values
             ) {
            System.out.print(value+" ");
        }
        //既要获取value也要获取key
        System.out.println("--------------------");
        System.out.println("既要获取value也要获取key");
        Set<Map.Entry<String,String>> entries=map.entrySet();
        for (Map.Entry<String,String> entry:entries
             ) {
            System.out.print(entry.getKey()+":"+entry.getValue()+"--");
        }
        Vector<String> vector=new Vector<>();
//        Set<Integer> set= new HashSet<Integer>(){{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}};
        Set<Integer> set= new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13));
        System.out.println(set);
    }


}
