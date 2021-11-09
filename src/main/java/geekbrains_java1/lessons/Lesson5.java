package geekbrains_java1.lessons;

import java.time.LocalDate;

public class Lesson5 {

    protected static void lesson5() {

        Employee[] staff = new Employee[5];
        staff[0] = new Employee("Иванов Иван Иванович",
                LocalDate.of(1970,11,11),
                "ivanov@mail.ru",
                "+7-999-555-33-11",
                "директор",
                100000);
        staff[1] = new Employee("Петров Петр Петрович",
                LocalDate.of(1975,11,2),
                "petrov@mail.ru",
                "+7-999-555-33-22",
                "инженер",
                90000);
        staff[2] = new Employee("Сидоров Сидор Сидорович",
                LocalDate.of(1980,3,3),
                "sidorov@mail.ru",
                "+7-999-555-33-33",
                "бухгалтер", 90000);
        staff[3] = new Employee("Максимов Максим Максимович",
                LocalDate.of(1985,4,4),
                "maksimov@mail.ru",
                "+7-999-555-33-44",
                "водитель",
                50000);
        staff[4] = new Employee("Денисов Денис Денисович",
                LocalDate.of(1990,5,5),
                "denisov@mail.ru",
                "+7-999-555-33-55",
                "рабочий",
                50000);

        for (int i = 0; i < 5; i++) {
            if (staff[i].getAge() >=40) {
                staff[i].printEmployee();
            }

        }
    }

}
