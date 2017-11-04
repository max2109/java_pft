package ru.stqa.pft.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
//        String[] langs = new String[4];
//        langs[0] = "Java";
//        langs[1] = "C#";
//        langs[2] = "Python";
//        langs[3] = "PHP";
//    } так строятся массивы
    String [] langs = {"Java", "C#", "Python", "PHP"};
  //  for ( int i=0; i < langs.length; i++){                один вариант

        List<String> languages = new ArrayList<String>(); //при создании равен нулю, можно удалять и добавлять элементы
           languages.add("Java");
           languages.add("C#");
         //List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP")   ;
           //for (String l : languages)

            for (String l : langs) {                      //второй вариант, где l это ссылка на элемент массива
                                                            // которая последовательно указывает на элементы массива
        System.out.println("I want to leanr " + l);   /*langs[i]*/
        }

    }

}




//        public static void main(String[] args) {
//            String[] langs = {"Java", "C#", "Python", "PHP"};
//
//            List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");
//
//            for (String l : languages) {
//                System.out.println("Я хочу выучить " + l);
//            }
//        }
//    }

