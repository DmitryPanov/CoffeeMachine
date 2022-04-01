package org.homework;

public class TankWater {
    private int water = 0;
    private int volume;

    public TankWater(int volume) {
        this.volume = volume;
    }

    public void setWater(int water) {
        if (water <= 0) {
            System.out.println("Не хватает ингридиентов, нет возможности приготовить кофе");
            return;
        }
        this.water = water;
    }

    public int getWater() {
        if (water <= 0) {
            return 0;
        } else if (water>volume){
            return volume;
        }
        return water;
    }

}
