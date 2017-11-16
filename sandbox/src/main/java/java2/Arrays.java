package java2;

import com.sun.xml.internal.org.jvnet.fastinfoset.RestrictedAlphabet;

public class Arrays {
    public static void main(String[] args) {
        int x = 10;

        int[] numbers = new int[20];

        String lines [] = new String[10];

        String[] line = {"a", "b", "c"};

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 13;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println(line[0]);
    }
}