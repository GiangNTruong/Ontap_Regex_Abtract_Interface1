package ra.businessImp;

import ra.business.IEmployee;

import java.util.Scanner;
import java.util.Comparator;

public class Employee implements IEmployee,Comparable<Employee> {
    private String id;
    private String name;
    private int year;
    private float rate;
    private float commission;
    private float salary;
    private boolean status;

    public Employee() {
    }

    public Employee(String id, String name, int year, float rate, float commission, float salary, boolean status) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rate = rate;
        this.commission = commission;
        this.salary = salary;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập mã naan vien");
        this.id = scanner.nextLine();
        System.out.println("Nhập tên nhan viên");
        this.name = scanner.nextLine();
        System.out.println("Nhập năm sinh ");
        this.year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập he số lương");
        this.rate = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập hoa hồng");
        this.commission = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập status true : Đang làm , false :Nghi viec");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", rate=" + rate +
                ", commission=" + commission +
                ", salary=" + calSalary() +
                ", status=" + (status?"Đang làm":"Nghỉ làm") +
                '}';
    }

    @Override
    public void displayData() {
        System.out.println(this);
    }
    public double calSalary() {
        return this.rate * BASIC_SALARY + this.commission;
    }


    //Lương tăng dần
    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.calSalary(),o.calSalary());
    }
    //
}
