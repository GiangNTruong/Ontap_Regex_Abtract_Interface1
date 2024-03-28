package ra.ra.presentation;

import ra.businessImp.Employee;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class EmployeeManagement {

      private static   Employee[] arremployee = new Employee[100];
        private static int employeeCount = 0 ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("********************MENU*********************\n" +
                    "1. Nhập thông tin cho n nhân viên\n" +
                    "2. Hiển thị thông tin nhân viên\n" +
                    "3. Tính lương cho các nhân viên\n" +
                    "4. Tìm kiếm nhân viên theo tên nhân viên\n" +
                    "5. Cập nhật thông tin nhân viên\n" +
                    "6. Xóa nhân viên theo mã nhân viên\n" +
                    "7. Sắp xếp nhân viên theo lương tăng dần (Comparable)\n" +
                    "8. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)\n" +
                    "9. Sắp xếp nhân vên theo năm sinh tăng dần (Comparator)\n" +
                    "10. Thoát");
            System.out.println("Chọn chức năng ba muôn :");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputListEmployee(scanner);
                    break;
                case 2:
                 displayListEmployee();
                    break;
                case 3:
                 calculateSalaries();
                    break;
                case 4:
                  findEmployeeByName(scanner);
                    break;
                case 5:
                    updateEmployee(scanner);
                    break;
                case 6:
                    deleteEmployee(scanner);
                    break;
                case 7:
                    Arrays.sort(arremployee,0,employeeCount);
                    System.out.println("da sap xep nhan vien theo lương tăng dần");
                    break;
                case 8:
                    Arrays.sort(arremployee, 0, employeeCount, new NameDescendingComparator());
                    System.out.println("Đã sắp xếp nhân viên theo tên giảm dần.");
                    break;
                case 9:
                    Arrays.sort(arremployee, 0, employeeCount, new YearAscendingComparator());
                    System.out.println("Đã sắp xếp nhân viên theo năm sinh tăng dần.");
                    break;
                case 10:
                    // Thoát
                    System.exit(0);
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
    public static void inputListEmployee(Scanner scanner){
        System.out.println("Nhập số lượng nhn viên :");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arremployee[i] = new Employee();
            arremployee[i].inputData(scanner);

            employeeCount++;
        }
    }
    public static void displayListEmployee(){
        for (int i = 0; i < employeeCount; i++) {
            arremployee[i].displayData();
        }
    }
    public static void calculateSalaries() {
        for (int i = 0; i < employeeCount; i++) {
            arremployee[i].calSalary();
            System.out.println("Tên nhân viên: " + arremployee[i].getName());
            System.out.println("Lương: " + arremployee[i].calSalary());
        }
    }
    public static void findEmployeeByName(Scanner scanner){
        System.out.println("Nhập tên nhân viên câ tìm : ");
        String nameEmployee = scanner.nextLine();
        for (int i = 0; i < employeeCount; i++) {
            if (arremployee[i].getName().contains(nameEmployee)){
                arremployee[i].displayData();
            }
        }
    }
    public static void updateEmployee(Scanner scanner){
        System.out.println("Nhập mã nhân viên muon sua ");
        String idEdit = scanner.nextLine();
        for (int i = 0; i < employeeCount; i++) {
            if (arremployee[i].getId().equals(idEdit)){
                System.out.println("Nhâ thông tin mới cho nhân viên");
                arremployee[i].inputData(scanner);
                System.out.println("Tooong tin nhan vien da dc cap nhat");
                return;
            }
        }
        System.err.println("Khong tim thấy nhan vien với mã đã nhap");
    }
    public static void deleteEmployee(Scanner scanner) {
        System.out.println("Nhập mã nhân viên cần xóa:");
        String id = scanner.nextLine();
        for (int i = 0; i < employeeCount; i++) {
            if (arremployee[i].getId().equals(id)) {
                for (int j = i; j < employeeCount - 1; j++) {
                    arremployee[j] = arremployee[j + 1];
                }
                employeeCount--;
                System.out.println("Nhân viên đã được xóa.");
                return;
            }
        }
        System.err.println("Không tìm thấy nhân viên với mã đã nhập.");
    }
    public static class NameDescendingComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e2.getName().compareTo(e1.getName());
        }
    }

    public static class YearAscendingComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            return Integer.compare(e1.getYear(), e2.getYear());
        }
    }

}
