package geekbrains_java1.lesson1;

import java.util.Arrays;


public class HomeWorkApp {
    public static void main(String[] args) {

        //1
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        Lesson3.invertBooleanArr(arr1);
        //2
        Lesson3.array1ToN(100);
        //3
        int[] arr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        Lesson3.doubleArrayElementsLessN(arr2, 6);
        //4
        Lesson3.diagonalsSquareArray(10);
        //5
        System.out.println(Arrays.toString(Lesson3.arrayByValues(10, 5)));
        //6
        System.out.println(Lesson3.maxElementArray(arr2));
        System.out.println(Lesson3.minElementArray(arr2));

        //7
        int[] arr3 = {1,1,2,0,4};
        System.out.println(Lesson3.isEqualityOfTwoPartsArray(arr3));
        //8
        int[] arr4 = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(Lesson3.shiftElementsArrayByNPositions1(arr4,-5)));
        int[] arr5 = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(Lesson3.shiftElementsArrayByNPositions2(arr5,-5)));
        int[] arr6 = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(Lesson3.shiftElementsArrayByNPositions3(arr6,-5)));

    }


}
