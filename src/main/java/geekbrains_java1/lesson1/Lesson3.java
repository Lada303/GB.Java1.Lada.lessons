package geekbrains_java1.lesson1;

import java.util.Arrays;

public class Lesson3 {

    public static void printTwoDimensionalArray(int[][] arr) {
        for (int[] row : arr) {
            Arrays.stream(row).forEach(System.out::print);
            System.out.println();
        }
    }

//1
    public static void invertBooleanArr(int[] arr) {
        System.out.println("Input array: "+ Arrays.toString(arr));
        for (int i=0; i<arr.length; i++) {
            arr[i] = 1-arr[i];
        }
        System.out.println("Inver array: "+Arrays.toString(arr));
    }

//2
    public static void array1ToN(int n) {
        int[] arr = new int[n];
        for (int i=0; i<arr.length; i++) {
            arr[i]=i+1;
        }
        System.out.println(Arrays.toString(arr));
    }

//3
    public static void doubleArrayElementsLessN(int[] arr, int n) {
        System.out.println("Input array: "+ Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i]<n ? arr[i]*2 : arr[i]);
        }
        System.out.println("New array: "+Arrays.toString(arr));
    }

//4
    public static void diagonalsSquareArray(int size) {
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
            arr[i][size-1-i]=1;
        }
        printTwoDimensionalArray(arr);

    }

//5
    public static int[] arrayByValues(int length, int initialValue) {
        int[] arr = new int[length];
        for (int i=0; i<length; i++) {
            arr[i]=initialValue;
        }
        return arr;
    }

//6*
    public static int maxElementArray (int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }

    public static int minElementArray (int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

//7**
    public static boolean isEqualityOfTwoPartsArray(int[] arr) {
        if (arr.length<=1) return false;

        int sumElements=0;
        for (int elem: arr) {
            sumElements +=elem;
        }

        if (sumElements%2==0) {
            int sumPartElements=0;
            for (int elem: arr) {
                sumPartElements +=elem;
                if (sumPartElements == sumElements/2) {
                    return true;
                } else if (sumPartElements > sumElements/2){
                    break;
                }
            }
        }
        return false;
    }

//8** вар1 - доп массив и System.arraycopy()
    public static int[] shiftElementsArrayByNPositions1(int[] arr, int n) {
        if (arr.length<=1 || n%arr.length==0) return arr;

        n = (Math.abs(n)>arr.length ? n%arr.length : n);
        n = (n<0 ? n+arr.length : n);

        int[] bufferArr = new int[n];
        System.arraycopy(arr, arr.length-n, bufferArr, 0, n);
        System.arraycopy(arr, 0, arr, n, arr.length - n);
        System.arraycopy(bufferArr, 0, arr, 0, n);
        return arr;
    }

//8** вар2 без создания доп массива - n раз сдвиг на 1 позицию всего массива
    public static int[] shiftElementsArrayByNPositions2(int[] arr, int n) {
        if (arr.length<=1 || n%arr.length==0) return arr;

        n = (Math.abs(n)>arr.length ? n%arr.length : n);
        n = (n<0 ? n+arr.length : n);

        int buffer;
        for (int i=1; i<=n; i++) {
            buffer=arr[arr.length-1];
            System.arraycopy(arr, 0, arr, 1, arr.length - 1);
            arr[0]=buffer;
        }
        return arr;
    }

//8** вар3 без System.arraycopy()-поэлементное перемещение сразу на нужное место внутри массива
    public static int[] shiftElementsArrayByNPositions3(int[] arr, int n) {
        if (arr.length<=1 || n%arr.length==0) return arr;

        n = (Math.abs(n)>arr.length ? n%arr.length : n);
        n = (n<0 ? n+arr.length : n);

        int start_ind = n-1, corr_ind, next_ind, buffer;
        int counter=0;
        while (counter!=arr.length) {
            corr_ind=start_ind;
            buffer=arr[corr_ind];
            for (int i = 1; i <= arr.length; i++) {
                next_ind = (corr_ind - n >= 0 ? corr_ind - n : arr.length + (corr_ind - n));
                if (next_ind == start_ind) break;
                arr[corr_ind] = arr[next_ind];
                counter++;
                corr_ind = next_ind;
            }
            arr[corr_ind] = buffer;
            counter++;
            start_ind--;
        }
        return arr;
    }

}
