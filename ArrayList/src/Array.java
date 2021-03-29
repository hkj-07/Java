import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Array {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
//        System.out.println(list);
//        list.add(2,3);
        list.add(3);
        System.out.println(list);
        list.add(2,4);
        System.out.println(list);
//        list.get()
        int[] data = {4, 5, 3, 6, 2, 5, 1};
        List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());
        System.out.println(list1);
        for (int i:list
             ) {

        }
        double a=6;
        System.out.println(a/20000);
        //右边不能提供类型
        ArrayList[] tmpList = new ArrayList[10];
        ArrayList<String>[] lists = tmpList;
        ArrayList<String> listInt = new ArrayList<>();
        listInt.add("AAA");
        lists[0] = listInt;
        System.out.println(lists[0].get(0));



    }
}
class Animal<T> {
    private T[] array;

    public Animal(Class<T> clz, int length) {
//        array = (T[]) Array.newInstance(clz, length);
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index) {
        return array[index];
    }
}
