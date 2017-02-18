package ru.stqa.pft.sandbox;

/**
 * Created by alexe on 1/20/2017.
 */
public class Function  {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Dany");
    hello("mama ");

    int a = 5;
    System.out.println( area (a));

    int b = 10;
    System.out.println( area(a,b));

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь крадрата со стороной " + r.a + " и " + r.b + " = " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hello," + somebody + "!");
  }

  public static int area(int a) {
    return a*a;
  }
  public static int area (int a, int b){
    return a + b;
  }

  }
