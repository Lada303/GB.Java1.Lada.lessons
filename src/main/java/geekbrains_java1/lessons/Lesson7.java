package geekbrains_java1.lessons;

public class Lesson7 {

    public static void lesson7() {
        Cat2[] cats = new Cat2[5];
        cats[0]  = new Cat2("Barsik", 5);
        cats[1]  = new Cat2("Darsik", 10);
        cats[2]  = new Cat2("Larsik", 15);
        cats[3]  = new Cat2("Marsik", 15);
        cats[4]  = new Cat2("Warsik", 10);

        Plate plate = new Plate(50,10);
        plate.info();
        plate.increaseFood(20);
        plate.increaseFood(100);

        for (int i = 0; i < 5; i++) {
            cats[i].eat(plate);
        }
        plate.info();
    }
}
