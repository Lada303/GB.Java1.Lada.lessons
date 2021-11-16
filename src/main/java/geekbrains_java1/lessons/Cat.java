package geekbrains_java1.lessons;

public class Cat extends Animal{

    private static int counterCat =0;
    private static final int MAX_RUNNING_DISTANCE = 200;


    Cat (String colorCat) {
        super("Cat", colorCat);
        counterCat++;
    }
    Cat (String nameCat, String colorCat, int ageCat) {
        super("Cat", nameCat, colorCat, ageCat);
        counterCat++;
    }

    protected void run(int meters) {
        if (meters < MAX_RUNNING_DISTANCE) {
            super.run(meters);
        } else {
            System.out.printf("Cat %s did not cover the distance\n", getName());
        }
    }

    protected void swim(int meters) {
        System.out.println("Cat cannot swim!");
    }

    void climbTrees() {
        System.out.printf("Cat %s climbed a tree\n", getName());
    }

    @Override
    protected void voice() {
        System.out.printf("Cat %s %s\n", getName(), "meow");
    }

     static int getCounter() {
        return counterCat;
    }

    protected void printAnimal() {
        super.printAnimal();
        System.out.println(" --------------");
    }

}
