package geekbrains_java1.lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords(){
        System.out.println("Orange\n" + "Banana\n" + "Apple");
    }

    public static  int randomN(int n){
        return (int) Math.round(Math.random() * n);
    }

    public static void checkSumSign(){
        int a = randomN(100);
        int b =-randomN(100);
        System.out.println("a="+a+" b="+b);
        if (a+b >= 0 ) {
            System.out.println("Сумма положительная");
        }
        if (a+b < 0 ) {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(){
        int value = randomN(200)-randomN(200);
        System.out.println("value="+value);
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value>0 && value <=100){
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(){
        int a = randomN(100);
        int b = randomN(100);
        System.out.println("a="+a+" b="+b);
        if (a>=b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

}
