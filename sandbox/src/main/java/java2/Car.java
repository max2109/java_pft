package java2;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Car {
    public static void main(String[] args) {
        int speed = 120;
        int weight;
        String color = "black";
        String make;
        String model;


        Car honda = new Car();
        Car toyota = new Car();
        Car mercedes = new Car();
        Car bently = new Car();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter your car");
        String name = s.nextLine();
        System.out.println("Enter your number");
        int number = s.nextInt();

        //WHILE
        while (number != 10) {
            System.out.println("Enter different number");
            number = s.nextInt();
        }
        System.out.println("Bingo!");

       //DO WHILE
        System.out.println("Rate it please from 1-10 ?");
        number = s.nextInt();
        if (number >= 10) {
            System.out.println("Excellent");
        } else { System.out.println("Why so low? Try one more time");}

        //IF ELSE
        System.out.println("What is your age?");
        number = s.nextInt();
        if (number == 34) {
            System.out.println("Like me");
            number = s.nextInt();
        } else if (number < 34 ) {
            System.out.println("Your are younger");
        } else {
            System.out.println("You are older");
        }

        System.out.println("Rate it please from 1-10 ?");
        number = s.nextInt();

        for (number = 0; number <10 ; number++) {
            if(number <5){
                continue;
            }
            System.out.println("Here is example " + number); }



        System.out.println("My new car is " + speed + " " + color);

        int acceleration = 100;
        while (acceleration <= 120) {
            System.out.println("Car is running " + acceleration + " mph");
            acceleration = acceleration + 1;
        }

        for (int i = 0; i < 100; i++) {
            acceleration = i + speed;
            System.out.println(acceleration);
        }

        int i = 120;
        if (i > speed) {
            System.out.println("Not correct");
        } else if (i < speed) {
            System.out.println("Correct");
        } else {
            System.out.println("How it is possible ? It's equal");
        }
    }

        public void Drive(){ };
        public void Stop(){};

}
