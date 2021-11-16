package geekbrains_java1.lessons;

public class Plate {

    private final int foodLimit;
    private int foodCurrent;

    public Plate(int foodLimit, int foodCurrent) {
        this.foodLimit = foodLimit;
        this.foodCurrent = foodCurrent;
    }

    public void increaseFood(int n) {
        if (n <= foodLimit-foodCurrent) {
            foodCurrent += n;
            System.out.printf("%d food on the plate out of %d possible \n", foodCurrent, foodLimit);
        } else {
            foodCurrent = foodLimit;
            System.out.printf("The plate is full - %d\n", foodLimit);
        }
    }

    public boolean decreaseFood(int n) {
        if (foodCurrent >= n) {
            foodCurrent -= n;
            System.out.printf("%d food left in the plate\n", foodCurrent);
            return true;
        } else {
            System.out.println("There is not enough food in the plate");
        }
        return false;
    }

    public void info() {
        System.out.println("Plate: limit - " + foodLimit + ", current - " + foodCurrent);
    }
}
