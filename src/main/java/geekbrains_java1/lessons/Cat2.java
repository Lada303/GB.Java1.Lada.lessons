package geekbrains_java1.lessons;

public class Cat2 {

    private final String name;
    private int appetite;
    private boolean satiety;

    public Cat2(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate p) {
        satiety = p.decreaseFood(appetite);
        System.out.printf(satiety ? "Cat %s well-fed\n" : "Cat %s did not eat\n", name);
    }

}
