package org.homework;


import java.util.Locale;


public class CofeMachine {
    private boolean turnoff = false;

    private TankCofe tankCofe;
    private TankMilk tankMilk;
    private TankWater tankWater;

    public CofeMachine(TankCofe tankCofe, TankMilk tankMilk, TankWater tankWater) {
        this.tankCofe = tankCofe;
        this.tankMilk = tankMilk;
        this.tankWater = tankWater;
    }

    public void turnOff() {
        turnoff = true;
    }

    public boolean isTurnoff() {
        return turnoff;
    }

    public void cooking(String whatCooking) {
        String[] str = whatCooking.toLowerCase(Locale.ROOT).split(" ");
        switch (str[0]) {
            case "turn":
                turnOff();
                break;
            case "water":
                tankWater.setWater(Integer.parseInt(str[1]) + tankWater.getWater());
                break;
            case "milk":
                tankMilk.setMilk(Integer.parseInt(str[1]) + tankMilk.getMilk());
                break;
            case "coffee":
                tankCofe.setCofe(Integer.parseInt(str[1]) + tankCofe.getCofe());
                break;
            case "latte":
                latte(Integer.parseInt(str[1]));
                break;
            case "ristretto":
                ristretto(Integer.parseInt(str[1]));
                break;
            case "cappuccino":
                cappuccino(Integer.parseInt(str[1]));
                break;
            case "lungo":
                lungo(Integer.parseInt(str[1]));
                break;
            case "espresso":
                espresso(Integer.parseInt(str[1]));
                break;
            default:
                System.out.println("Кофе не выбран");
        }
    }

    public void latte(int doCoffee) {
        if (!canCookLatte(doCoffee) | doCoffee <= 10) {
            return;
        }
        System.out.printf("%d %d %d \n", tankCofe.getCofe(), tankWater.getWater(), tankMilk.getMilk());
    }

    public void ristretto(int doCoffee) {
        if (!canCookRistretto(doCoffee) | doCoffee <= 10) {
            return;
        }
        System.out.printf("%d %d %d \n", tankCofe.getCofe(), tankWater.getWater(), tankMilk.getMilk());
    }

    public void cappuccino(int doCoffee) {
        if (!canCookCappuccino(doCoffee) | doCoffee <= 10) {
            return;
        }
        System.out.printf("%d %d %d \n", tankCofe.getCofe(), tankWater.getWater(), tankMilk.getMilk());
    }

    public void lungo(int doCoffee) {
        if (!canCookLungo(doCoffee) | doCoffee <= 10) {
            return;
        }
        System.out.printf("%d %d %d \n", tankCofe.getCofe(), tankWater.getWater(), tankMilk.getMilk());
    }

    public void espresso(int doCoffee) {
        if (!canCookEspresso(doCoffee) | doCoffee <= 10) {
            return;
        }
        System.out.printf("%d %d %d \n", tankCofe.getCofe(), tankWater.getWater(), tankMilk.getMilk());
    }


    //            Эспрессо: 30% кофе, 70% воды.
    private boolean canCookEspresso(int tryCook) {
        int cofe = (int) (tankCofe.getCofe() - (tryCook * 0.30));
        int water = (int) (tankWater.getWater() - (tryCook * 0.70));
        if (cofe < 0 || water < 0) {
            System.out.printf("Нет возможности приготовить Espresso в количестве: " + tryCook + "\n");
            return false;
        }
        tankCofe.setCofe(cofe);
        tankWater.setWater(water);
        return true;
    }

    //            Лунго: 15% кофе, 85% воды.
    private boolean canCookLungo(int tryCook) {
        int cofe = (int) (tankCofe.getCofe() - (tryCook * 0.15));
        int water = (int) (tankWater.getWater() - (tryCook * 0.85));
        if (cofe < 0 || water < 0) {
            System.out.printf("Нет возможности приготовить Лунго в количестве: " + tryCook + "\n");
            return false;
        }
        tankCofe.setCofe(cofe);
        tankWater.setWater(water);
        return true;
    }

    //            Латте: 10% кофе, 30% воды, 60% молока.
    private boolean canCookLatte(int tryCook) {
        int cofe = (int) (tankCofe.getCofe() - (tryCook * 0.1));
        int water = (int) (tankWater.getWater() - (tryCook * 0.3));
        int milk = (int) (tankMilk.getMilk() - (tryCook * 0.6));
        if (cofe < 0 || water < 0 || milk < 0) {
            System.out.printf("Нет возможности приготовить Латте в количестве: " + tryCook + "\n");
            return false;
        }
        tankCofe.setCofe(cofe);
        tankWater.setWater(water);
        tankMilk.setMilk(milk);
        return true;
    }

    //            Ристретто: 50% кофе, 50% воды.
    private boolean canCookRistretto(int tryCook) {
        int cofe = (int) (tankCofe.getCofe() - (tryCook * 0.5));
        int water = (int) (tankWater.getWater() - (tryCook * 0.5));
        if (cofe < 0 || water < 0) {
            System.out.printf("Нет возможности приготовить Ристретто в количестве: " + tryCook + "\n");
            return false;
        }
        tankCofe.setCofe(cofe);
        tankWater.setWater(water);
        return true;
    }

    //            Капучино: 15% кофе, 40% воды, 45% молока.
    private boolean canCookCappuccino(int tryCook) {
        int cofe = (int) (tankCofe.getCofe() - (tryCook * 0.15));
        int water = (int) (tankWater.getWater() - (tryCook * 0.4));
        int milk = (int) (tankMilk.getMilk() - (tryCook * 0.45));
        if (cofe < 0 || water < 0 || milk < 0) {
            System.out.printf("Нет возможности приготовить Капучино в количестве: " + tryCook + "\n");
            return false;
        }
        tankCofe.setCofe(cofe);
        tankWater.setWater(water);
        tankMilk.setMilk(milk);
        return true;
    }
}
