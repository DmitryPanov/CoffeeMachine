package org.homework;

public class TankMilk {
    private int milk = 0;
    private int volume;

    public TankMilk(int volume) {
        this.volume = volume;
    }

    public void setMilk(int milk) {
        if (milk <= 0) {
            System.out.println("Не хватает ингридиентов, нет возможности приготовить кофе");
            return;
        }
        this.milk = milk;
    }

    public int getMilk() {
        if (milk <= 0) {
            return 0;
        } else if (milk > volume){
            return volume;
        }
        return milk;
    }

}
