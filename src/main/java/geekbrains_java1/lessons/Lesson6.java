package geekbrains_java1.lessons;

public class Lesson6 {

    static void lesson6 () {

        Animal[] animals= new Animal[10];
        animals[0] = new Cat("Murzik", "black", 1);
        System.out.println(animals[0]);

        animals[1] = new Cat("white");
        System.out.println(animals[1]);
        animals[1].setAge(4);
        animals[1].setName("Zina");
        animals[1].printAnimal();
        Cat cat3 = new Cat ("Murley", "random", 2);
        animals[2] = cat3;

        Animal dog1 = new Dog("collie","red");
        dog1.setAge(1);
        animals[3] = dog1;
        System.out.println(dog1);
        animals[4] = new Dog("undefined","Bobby", "black", 3);
        animals[5] = new Dog("undefined","Brown");
        animals[6] = new Dog("shepherd","Wolf", "grey", 5);
        animals[6].printAnimal();

        animals[0].run(50);
        animals[1].run(250);
        animals[1].swim(10);
        animals[1].voice();
        cat3.climbTrees();
        animals[2].sleep();

        animals[3].run(600);
        animals[4].run(100);
        animals[5].swim(20);
        animals[6].swim(200);
        animals[6].voice();

        System.out.println("Total animals: "+Animal.getCounter());
        System.out.println("Total cat: "+Cat.getCounter());
        System.out.println("Total dog: "+Dog.getCounter());

        for (Animal animal : animals) {
            if (animal instanceof Cat cat) {
                cat.climbTrees();
            }
        }

    }


}
