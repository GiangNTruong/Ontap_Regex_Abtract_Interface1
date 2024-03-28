package ra.imp;

import ra.entity.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProductImp {
    private static Product[] products = new Product[100];
    private static int productCount = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.println("*****************************************************");
            System.out.print("Vui lòng chọn một chức năng: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                   inputListProduct(scanner);
                    break;
                case 2:
                  displayProduct();
                    break;
                case 3:
                   calculateProfit();
                    break;
                case 4:
                    sortProductByProfit();
                    break;
                case 5:
                    statisticsByPrice(scanner);
                    break;
                case 6:
                    findProductByName(scanner);
                    break;
                case 7:
                    inputProduct(scanner);
                    break;
                case 8:
                  sellProduct(scanner);
                    break;
                case 9:
                    updateProductStatus(scanner);
                    break;
                case 10:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 10);
    }
    public static void inputListProduct(Scanner scanner) {
        System.out.print("Nhập số lượng sản phẩm: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            products[i] = new Product();
            products[i].inputData(scanner, products);
            productCount++;
        }
    }

    public static void displayProduct() {
        for (Product product : products) {
            if (product != null) {
                product.displayData();
            }
        }
    }
    public static void calculateProfit() {
        boolean hasProduct = false;
        for (Product product : products) {
            if (product != null) {
                float profit = product.calProfit();
                System.out.println("Lợi nhuận cho sản phẩm " + product.getProductName() + " là: " + profit);
                hasProduct = true;
            }
        }
        if (!hasProduct) {
            System.out.println("Không có sản phẩm nào trong danh sách.");
        }
    }


    public static void sortProductByProfit() {
        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (p1 == null || p2 == null) {
                    return 0;
                }
                return Float.compare(p2.calProfit(), p1.calProfit());
            }
        });
    }
    public static void statisticsByPrice(Scanner scanner) {
        System.out.print("Nhập giá từ: ");
        float fromPrice = scanner.nextFloat();
        System.out.print("Nhập giá đến: ");
        float toPrice = scanner.nextFloat();
        int count = 0;
        for (Product product : products) {
            if (product != null && product.getExportPrice() >= fromPrice && product.getExportPrice() <= toPrice) {
                count++;
            }
        }
        System.out.println("Số lượng sản phẩm có giá từ " + fromPrice + " đến " + toPrice + " là: " + count);
    }

    public static void findProductByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.next();
        boolean found = false;
        for (Product product : products) {
            if (product != null && product.getProductName().contains(name)) {
                product.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với tên: " + name);
        }
    }

    public static void inputProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm: ");
        String id = scanner.next();
        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = scanner.nextInt();
        boolean found = false;
        for (Product product : products) {
            if (product != null && product.getProductid().equals(id)) {
                product.setQuantity(product.getQuantity() + quantity);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với mã: " + id);
        }
    }

    public static void sellProduct(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.next();
        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = scanner.nextInt();
        boolean found = false;
        for (Product product : products) {
            if (product != null && product.getProductName().equals(name)) {
                product.setQuantity(product.getQuantity() - quantity);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với tên: " + name);
        }
    }

    public static void updateProductStatus(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm: ");
        String id = scanner.next();
        boolean found = false;
        for (Product product : products) {
            if (product != null && product.getProductid().equals(id)) {
                product.setStatus(!product.isStatus());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với mã: " + id);
        }
    }




}
