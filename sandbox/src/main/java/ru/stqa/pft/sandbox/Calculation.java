package ru.stqa.pft.sandbox;

/**
 * Created by Alexey on 1/24/2017.
 *
public class Calculation {


 public static double distance() {
 Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
 return(distance);
    public static void main (String[] args) {


        public static double distance (P1, p2)
        Math.sqrt (x)


    }
}
*/
public class Calculation {

    static Point p1 = new Point(1.0, 2.0);
    static Point p2 = new Point(3.0, 4.0);

    static double dx = p1.x - p2.x;
    static double dy = p1.y - p2.y;

    public static double getDistance() {
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        System.out.println("Расстояние между двумя точками " + getDistance());
    }

}