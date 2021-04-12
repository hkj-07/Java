import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {

        ArrayList c = new ArrayList();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");

        //对集合中的元素遍历（迭代）
        Iterator it = c.iterator();      //获取迭代器
        int index=0;
        while(it.hasNext()) {
            if(c.get(index)=="c"){
                c.remove(0);
            }
            index++;
//            c.remove(0);
//            it.remove();
        }
//        while(it.hasNext()){
//            Object object=it.next();
//            if(needDelete(object)){
//                c.remove(index);
//            }
//            index++;
//        }
        System.out.println(c);
    }

}
