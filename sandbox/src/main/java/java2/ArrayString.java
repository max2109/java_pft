package java2;

import com.sun.org.apache.xpath.internal.SourceTree;

public class ArrayString {

    public static void main(String[] args) {



        String [] lines = {"af", "asfd", "asf", "asf", "af", "asf", "asf", "rqw", "cqwr", "qr"};

        String[] line = {"a", "b", "c", "a", "b", "c", "a", "b", "c", "a"};

        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }

        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i]);
        }

        for(String var: lines){
            System.out.println(var);
        }
    }
}