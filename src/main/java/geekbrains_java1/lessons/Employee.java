package geekbrains_java1.lessons;

import java.time.LocalDate;

public class Employee {
    private final String name;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private final LocalDate dateBirthday;

    protected Employee (String name, LocalDate dateBirthday) {
        this.name = name;
        this.position = "position";
        this.email = "email";
        this.phone = "phone";
        this.salary = 0.0f;
        this.dateBirthday = dateBirthday;
    }
    protected Employee (String name, LocalDate dateBirthday, String email,
                        String phone) {
        this(name, dateBirthday);
        this.email = email;
        this.phone = phone;
    }

    protected Employee (String name, LocalDate dateBirthday, String email,
                        String phone, String position, float salary) {
        this(name, dateBirthday, email, phone);
        this.position = position;
        this.salary = salary;
    }



    protected String getName() {
        return name;
    }
    protected String getPosition() {
        return position;
    }
    protected String getEmail() {
        return email;
    }
    protected String getPhone() {
        return phone;
    }
    protected float getSalary() {
        return salary;
    }
    protected LocalDate getDateBirthday() {
        return dateBirthday;
    }
    protected int getAge() {
        return LocalDate.now().getDayOfYear() > dateBirthday.getDayOfYear() ?
               LocalDate.now().getYear()-dateBirthday.getYear() :
               LocalDate.now().getYear()-dateBirthday.getYear()-1;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    protected void printEmployee() {
        System.out.println("      ФИО: "+name);
        System.out.println("должность: "+position);
        System.out.println("   e-mail: "+email);
        System.out.println("  телефон: "+phone);
        System.out.println(" зарплата: "+salary);
        System.out.println("  возраст: "+this.getAge() +"\n");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", dateBirthday=" + dateBirthday +
                '}';
    }
}
