package JUC.CAS;

import java.util.concurrent.atomic.LongAdder;

public class test {
    public static void main(String[] args) {
        LongAdder a = new LongAdder();
        int x = 2147483640;
        int y = 15;
        System.out.println(x+y);
    }
}
