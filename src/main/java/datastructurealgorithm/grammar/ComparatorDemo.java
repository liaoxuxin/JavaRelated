package datastructurealgorithm.grammar;

import java.util.Arrays;
import java.util.Comparator;

class Data {
    int a;
    int b;
    int c;
    public Data (int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public String toString() {
        return "Data{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
//根据多个属性依次排序
public class ComparatorDemo {
    public static void main(String[] args) {
        Data[] arr = new Data[5];
        arr[0] = new Data(1,2,4);
        arr[1] = new Data(1,1,4);
        arr[2] = new Data(1,2,3);
        arr[3] = new Data(4,2,4);
        arr[4] = new Data(2,2,4);
        Arrays.sort(arr, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.a == o2.a) {
                    if (o1.b == o2.b) {
                        return o1.c - o2.c;
                    } else {
                        return o1.b - o2.b;
                    }
                } else {
                    return o1.a - o2.a;
                }
            }
        });
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
    }
}
