import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 1024) + " current data：" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2020) + " current data：" + atomicInteger.get());

    }
}