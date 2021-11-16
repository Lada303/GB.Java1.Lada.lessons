package geekbrains_java1.lessons;

public enum Weekdays {
    MONDAY(1, "Понедельник"){void prn() {
        System.out.println("Понедельник - день тяжелый");
    }},
    TUESDAY(2, "Вторник"),
    WEDNESDAY(3, "Среда"),
    THURSDAY(4, "Четверг"),
    FRIDAY(5, "Пятница"){void prn() {
        System.out.println("Наконец-то пятница!");
    }},
    SATURDAY(6, "Субота"),
    SUNDAY(7, "Воскресенье");

    private int dayNumber;
    private String russianTitle;

    Weekdays(int dayNumber, String russianTitle) {
        this.dayNumber = dayNumber;
        this.russianTitle = russianTitle;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public String getRussianTitle() {
        return russianTitle;
    }


}
