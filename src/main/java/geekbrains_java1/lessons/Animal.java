package geekbrains_java1.lessons;

public abstract class Animal {

    private static int counterAnimal=0;

    private final String typeAnimal;
    private String name;
    private final String color;
    private int age;

    protected Animal(String typeAnimal, String color){
        this.typeAnimal = typeAnimal;
        this.name = "Name";
        this.color = color;
        this.age = 0;
        counterAnimal++;
    }
    protected Animal(String typeAnimal, String name, String color, int age){
        this.typeAnimal = typeAnimal;
        this.name = name;
        this.color = color;
        this.age = age;
        counterAnimal++;
    }
    protected final void sleep () {
        System.out.printf("%s %s sleeping\n", typeAnimal, name);
    }

    protected void run(int meters) {
        System.out.printf("%s %s ran %d meters\n", typeAnimal, name, meters);
    }

    protected void swim(int meters) {
        System.out.printf("%s %s swam %d meters\n", typeAnimal, name, meters);
    }

    protected abstract void voice();

    static int getCounter() {
        return counterAnimal;
    }

    protected String getTypeAnimal() {
        return typeAnimal;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getColor() {
        return color;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected void printAnimal() {
        System.out.println("animal: "+typeAnimal);
        System.out.println("  name: "+name);
        System.out.println(" color: "+color);
        System.out.println("   age: "+age);
    }

    @Override
    public String toString() {
        return "Animal{" + typeAnimal +
                ", " + name +
                ", " + color +
                ", " + age +
                '}';
    }

}
