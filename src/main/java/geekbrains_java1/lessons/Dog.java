package geekbrains_java1.lessons;

public class Dog extends Animal{

    private static int counterDog =0;
    private static final int MAX_RUNNING_DISTANCE = 500;
    private static final int MAX_SWIMMING_DISTANCE = 100;

    private final String breed;

    Dog (String breed, String colorDog) {
        super("Dog", colorDog);
        this.breed = breed;
        counterDog++;
    }
    Dog (String breedDog, String nameDog, String colorDog, int ageDog) {
        super("Dog", nameDog, colorDog, ageDog);
        this.breed=breedDog;
        counterDog++;
    }

    protected void run(int meters) {
        if (meters < MAX_RUNNING_DISTANCE) {
            super.run(meters);
        } else {
            System.out.printf("Dog %s did not cover the distance\n", getName());
        }
    }

    protected void swim (int meters) {
        if (meters < MAX_SWIMMING_DISTANCE) {
            super.swim(meters);
        } else {
            System.out.printf("Dog %s did not cover the distance\n", getName());
        }
    }

    @Override
    protected void voice() {
        System.out.printf("Dog %s %s\n", getName(), "gav");
    }

    static int getCounter() {
        return counterDog;
    }

    public String getBreed() {
        return breed;
    }

    protected void printAnimal() {
        super.printAnimal();
        System.out.println(" breed: "+breed);
        System.out.println(" --------------");
    }

    @Override
    public String toString() {
        return "Animal{" + getTypeAnimal() +
                ", " + getName() +
                ", " + getColor() +
                ", " + getAge() +
                ", " + getBreed() +
                '}';
    }
}
