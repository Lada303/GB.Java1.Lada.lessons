package geekbrains_java1.lessons;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    public static int sizeX=3;
    public static int sizeY=3;
    public static int dotsToWin=3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static int countStep;
    public static int humanX;
    public static int humanY;
    public static int aiX;
    public static int aiY;
    public static int humanScore=0;
    public static int aiScore=0;
    public static int nScore=0;

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void gameXO() {
        helloInstruction();
        while(true) {
            selectMap();
            dotsToWin = selectDotsToWin();
            playRound();
            printScore();
            System.out.println("Продолжить игру? Y/N >>>");
            if (!sc.next().toLowerCase(Locale.ROOT).equals("y")) {
                System.out.println("Пока..");
                break;
            }
        }
        sc.close();
    }

    public static void helloInstruction() {
        System.out.println("Поиграем в крестики-нолики!");
        System.out.println("Вы вводите координаты в формате X Y через Пробел или Enter.");
        System.out.println("Если хотите прекратить игру - введите q вместо координат.\n");
    }

    public static void selectMap() {
        try {
            do {
                System.out.println("Введите размер поля X  Y через пробел или enter. ");
                System.out.println("X =  от 3 до 8, а Y = от 3 до 5 (все включительно). ");
                System.out.println("При этом X должен быть >= Y >>> ");
                sizeX = sc.nextInt();
                sizeY = sc.nextInt();
            } while (isSizeNotValid(sizeX,3,8) || isSizeNotValid(sizeY, 3,5) || sizeX<sizeY);
        }
        catch (InputMismatchException e) {
            System.out.println("Карта по умолчанию - 3*3");
            sizeX=sizeY=3;
            sc.nextLine();
        }
    }

    public static int selectDotsToWin() {
        int dots;
        if (Math.min(sizeX,sizeY)<=4) {
            dots=Math.min(sizeX,sizeY);
            System.out.println("Количество фишек для победы = " +dots+"\n");
        }
        else {
            try {
                do {
                    System.out.println("Введите количество фишек, необходимых для победы 4 или 5");
                    dots = sc.nextInt();
                } while (isSizeNotValid(dots, 4, 5)) ;
            } catch (InputMismatchException e) {
                dots=Math.min(sizeX,sizeY);
                System.out.println("Количество фишек для победы = " +dots+"\n");
                sc.nextLine();
            }
        }
        return dots;
    }

    public static boolean isSizeNotValid(int size, int min, int max) {
        if (size >= min && size <= max) {
            return false;
        }
        System.out.println("Неверное значение");
        return true;
    }

    public static void printScore() {
        System.out.println("Счет:   Ваш   ai   Ничья");
        System.out.printf("        %d     %d    %d\n", humanScore, aiScore, nScore);
        System.out.println();
    }

    public static void playRound() {
        countStep = -1;
        initMap();
        printMap();
        while (true) {
            humanTurn();
            if (humanX==-1) break;
            printMap();
            if (isWin(DOT_X)) break;
            if (isDraw()) break;

            if (countStep >= dotsToWin*2-1  && lookingWinStep()) aiTurnXY();
            else if (lookingStopStep()) aiTurnXY();
            else aiTurnRandom();
            printMap();
            if (isWin(DOT_O)) break;
            if (isDraw()) break;
        }
    }

    public static void initMap() {
        map = new char[sizeY][sizeX];
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printHorizontalLine() {
        for (int i = 0; i <= sizeX; i++) {
            System.out.print("----");
        }
        System.out.println();
    }

    public static void printMap() {
        System.out.print("  | ");
        for (int i = 1; i <= sizeX; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();
        printHorizontalLine();
        for (int i = 0; i < sizeY; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < sizeX; j++) {
                System.out.print(map[i][j] + " | ");
            }
            System.out.println();
            printHorizontalLine();
        }
        countStep++;
    }

    public static void humanTurn() {
        try {
            do {
                System.out.println("Введите координаты в формате X Y >>>");
                humanX = sc.nextInt() - 1;
                humanY = sc.nextInt() - 1;
            } while (!isCellValid(humanX, humanY));
        }
        catch (InputMismatchException e) {
            System.out.println("Вы прервали раунд!");
            humanX = -1;
            sc.nextLine();
            return;
        }
        map[humanY][humanX] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= sizeX || y < 0 || y >= sizeY) {
            System.out.println("Неверные координаты");
            return false;
        }
        if (map[y][x] == DOT_EMPTY) return true;
        System.out.println("Ячейка занята");
        return false;
    }

    public static boolean isWin(char symbol) {
        if (countStep >= dotsToWin*2-1) {
            if (symbol == DOT_X && checkWin(symbol, humanX, humanY)){
                System.out.println("Вы победили!\n");
                humanScore++;
                return true;
            }
            if (symbol == DOT_O && checkWin(symbol, aiX, aiY)) {
                System.out.println("Победил компьютер...\n");
                aiScore++;
                return true;
            }
        }
        return false;
    }

    public static boolean checkWin(char symbol, int x, int y) {
        int count_row = countNonInterruptElementRow(y, symbol);
        if (count_row==dotsToWin) return true;
        int count_column = countNonInterruptElementColumn(x, symbol);
        if (count_column==dotsToWin) return true;
        int count_d1 = 0;
        if (isD1(x,y)) count_d1 = countNonInterruptElementD1(symbol,x,y);
        if (count_d1==dotsToWin) return true;
        int count_d2 = 0;
        if (isD2(x,y)) count_d2=countNonInterruptElementD2(symbol,x,y);
        return count_d2 == dotsToWin;
    }

    public static boolean isDraw() {
        if (countStep >= sizeX * sizeY) {
            System.out.println("Ничья\n");
            nScore++;
            return true;
        }
        return false;
    }

    public static void aiTurnRandom() {
        int x, y;
        do {
            x = rand.nextInt(sizeX);
            y = rand.nextInt(sizeY);
        } while (map[y][x] != DOT_EMPTY);
        map[y][x] = DOT_O;
        System.out.println("Компьютер походил " + (x+1) + " " + (y+1));
    }

    public static void aiTurnXY() {
        map[aiY][aiX] = DOT_O;
        System.out.println("Компьютер походил " + (aiX+1) + " " + (aiY+1));
    }

    //выбирает шаг, для победы
    public static boolean lookingWinStep() {
        int count_row = countElementRow(aiY, DOT_O);
        if (count_row == dotsToWin-1 && isEmptyElementRow(aiY)) return true;
        int count_column = countElementColumn(aiX, DOT_O);
        if (count_column == dotsToWin-1 && isEmptyElementColumn(aiX)) return true;
        int count_d1 = 0;
        if (isD1(aiX,aiY)) count_d1 = countElementD1(DOT_O,aiX,aiY);
        if (count_d1 ==dotsToWin-1 && isEmptyElementD1(aiX,aiY)) return true;
        int count_d2 = 0;
        if (isD2(aiX,aiY)) count_d2=countElementD2(DOT_O,aiX,aiY);
        return count_d2 == dotsToWin - 1 && isEmptyElementD2(aiX, aiY);
    }

    //выбирает шаг, чтобы помешать игроку
    public static boolean lookingStopStep() {
        int count_row = countElementRow(humanY, DOT_X);
        int count_column = countElementColumn(humanX, DOT_X);
        int count_d1=0;
        if (isD1(humanX,humanY)) count_d1 = countElementD1(DOT_X,humanX,humanY);
        int count_d2 =0;
        if (isD2(humanX,humanY)) count_d2=countElementD2(DOT_X,humanX,humanY);

        int max = Math.max(Math.max(count_column,count_row),Math.max(count_d1,count_d2));
        while (max > 0) {
            if (sizeX>sizeY && count_row == max)
                if(isEmptyElementRow(humanY)) return true;
                else count_row=0;
            if (count_d1 ==max)
                if(isEmptyElementD1(humanX,humanY)) return true;
                else count_d1=0;
            if (count_d2 == max)
                if(isEmptyElementD2(humanX,humanY)) return true;
                else count_d2=0;
            if (count_column == max)
                if(isEmptyElementColumn(humanX)) return true;
                else count_column=0;
            if (count_row == max)
                if(isEmptyElementRow(humanY)) return true;
                else count_row=0;
            max = Math.max(Math.max(count_column,count_row),Math.max(count_d1,count_d2));
        }
        return false;
    }

    // принадлежит ли точка диагонали
    public static boolean isD1(int x, int y) {
        return (y-(sizeY-dotsToWin) <=x && x<=sizeX-dotsToWin+y);
    }

    public static boolean isD2(int x, int y) {
        return (dotsToWin-1-y <=x && x<=sizeX-1-y+(sizeY-dotsToWin));
    }

    //Всего элементов  - для определения пути противодействия игроку
    public static int countElementRow(int y, char symbol) {
        int counter=0;
        for (int i = 0; i < sizeX; i++) {
            if (map[y][i] == symbol) counter++;
        }
        return counter;
    }

    public static int countElementColumn(int x, char symbol) {
        int counter=0;
        for (int i = 0; i < sizeY; i++) {
            if (map[i][x] == symbol) counter++;
        }
        return counter;
    }

    public static int countElementD1(char symbol, int x, int y) {
        int counter=0;
        for (int i = 0; i < sizeY; i++) {
            try {
                if (map[i][i+(x-y)] == symbol) counter++;
            }
            catch (ArrayIndexOutOfBoundsException e) {}
        }
        return counter;
    }

    public static int countElementD2(char symbol, int x, int y) {
        int counter=0;
        for (int i = 0; i < sizeY; i++) {
            try {
                if (map[i][x+y-i] == symbol) counter++;
            }
            catch (ArrayIndexOutOfBoundsException e) {}
        }
        return counter;
    }

    // неприрывающаяся последовательность симоволов - для определения победителя
    public static int countNonInterruptElementRow(int y, char symbol) {
        int counter=0;
        for (int i = 0; i < sizeX; i++) {
            counter = (map[y][i] == symbol ? counter+1 : 0);
            if (counter==dotsToWin) return counter;
        }
        return counter;
    }

    public static int countNonInterruptElementColumn(int x, char symbol) {
        int counter=0;
        for (int i = 0; i <sizeY; i++) {
            counter =  (map[i][x] == symbol ? counter+1 : 0);
            if (counter==dotsToWin) return counter;
        }
        return counter;
    }

    public static int countNonInterruptElementD1(char symbol, int x, int y) {
        int counter=0;
        for (int i = 0; i < sizeY; i++) {
            try {
                counter= (map[i][i+(x-y)] == symbol ? counter+1 : 0);
                if (counter==dotsToWin) return counter;
            }
            catch (ArrayIndexOutOfBoundsException e) {}
        }
        return counter;
    }

    public static int countNonInterruptElementD2(char symbol, int x, int y) {
        int counter=0;
        for (int i = 0; i < sizeY; i++) {
            try {
                counter= (map[i][x+y-i] == symbol ? counter+1 : 0);
                if (counter==dotsToWin) return counter;
            }
            catch (ArrayIndexOutOfBoundsException e) {}
        }
        return counter;
    }

    // находит пустые ячиеки и сразу устанавливает их координаты
    public static boolean isEmptyElementRow(int y) {
        for (int i = 0; i < sizeX; i++) {
            if (map[y][i] == DOT_EMPTY) {
                aiY = y;
                aiX = i;
                return true;
            }
        }
        return false;
    }

    public static boolean isEmptyElementColumn(int x) {
        for (int i = 0; i < sizeY; i++) {
            if (map[i][x] == DOT_EMPTY) {
                aiY = i;
                aiX = x;
                return true;
            }
        }
        return false;
    }

    public static boolean isEmptyElementD1(int x, int y) {
        for (int i = 0; i < sizeY; i++) {
            try {
                if (map[i][i + (x - y)] == DOT_EMPTY) {
                    aiY = i;
                    aiX = i + (x - y);
                    return true;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {}
        }
        return false;
    }

    public static boolean isEmptyElementD2(int x, int y) {
        for (int i = 0; i < sizeY; i++) {
            try {
                if (map[i][x+y-i] == DOT_EMPTY) {
                    aiY = i;
                    aiX = x+y-i;
                    return true;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {}
        }
        return false;
    }

}
