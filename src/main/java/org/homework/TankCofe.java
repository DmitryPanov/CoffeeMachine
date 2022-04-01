package org.homework;

public class TankCofe {
    private int cofe = 0;
    private int volume;

    public TankCofe(int volume) {
        this.volume = volume;
    }

    public void setCofe(int cofe) {
        if (cofe <= 0) {
            System.out.println("Не хватает ингридиентов, нет возможности приготовить кофе");
            return;
        }
        this.cofe = cofe;
    }

    public int getCofe() {
        if (cofe <= 0) {
            return 0;
        } else if (cofe > volume) {
            return volume;
        }
        return cofe;
    }

}
