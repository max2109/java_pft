package ru.stqa.sandbox;

/**
 * Created by alexe on 1/20/2017.
 */
public class Function  {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Dany");
    hello("mama ");

    double l = 5;
    System.out.println("Площадь квадрата со стороной " + l + "=" + area(l));

    double a=4;
    double b=6;
    System.out.println("Площадь крадрата со стороной" + a + " и " +b+ "=" + area(a,b));
  }

  public static void hello(String somebody) {
    System.out.println("Hello," + somebody + "!");
  }

  public static double area(double len ) {
    return len * len;

  }

  public static double area(double a, double b){
    return a+b;

  }

  }
