package aufgaben.auf00_generics_sv01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>();
        p1.setValue0("String");
        p1.setValue1(42);

        System.out.println(p1.toString());

        Pair<Integer, Double> p2 = Pair.of(23, 32.0);
        System.out.println(p2);

        Pair<Integer, Integer> p3 = Pair.of(34,54);
        Object[] arr = new Object[2];
        arr = p3.toArray(p3.getValue0(), p3.getValue1());
        System.out.println(Arrays.toString(arr));

    }
}
