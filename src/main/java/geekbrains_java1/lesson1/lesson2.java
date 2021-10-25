package geekbrains_java1.lesson1;

public class lesson2 {

    public static boolean sumFrom10To20 (int a, int b){
        return a+b>=10 && a+b<=20;
    }

    public static void positiveOrNegative (int n){
        System.out.println(n>=0 ? "положительное" : "отрицательное");
    }

    public static boolean isNegative (int n){
        return n<0;
    }

    public static void nTimesPrintString (String str, int n){
        for (int i=0; i<n; i++){
            System.out.println(str);
        }
    }

    public static boolean isLeapYear (int y) {
        return y%4==0 && y%100!=0 || y%400==0;
    }

}
