package org.homework;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CofeMachine cofeMachine = new CofeMachine(
                new TankCofe(2000),
                new TankMilk(2000),
                new TankWater(2000));
        //water 1000
        //coffee 1000
        //milk 1000
        //latte 200
        //ristretto 30
        //lungo 150
        //water 100
        //espresso 50
        //turn off
        System.out.println("Добавляем воду");
        String water = scanner.nextLine();
        cofeMachine.cooking(water);
        System.out.println("Добавляем кофе");
        String coffee = scanner.nextLine();
        cofeMachine.cooking(coffee);
        System.out.println("Добавляем молоко");
        String milk = scanner.nextLine();
        cofeMachine.cooking(milk);
        do {
            System.out.println("Что готовим?");
            String cofe1 = scanner.nextLine();
            cofeMachine.cooking(cofe1);
            if (cofe1.equals("turn off")){
                cofeMachine.turnOff();
            }
        } while (!cofeMachine.isTurnoff());
    }
}
