package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = exportPrice - importPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    public void inputData(Scanner scanner, Product[] arrProduct) {
        this.productId = getInputProductId(scanner,arrProduct);
        this.productName = getInputProductName(scanner,arrProduct);
        this.importPrice = getImportPriceInput(scanner);
        this.exportPrice = getExportPriceInput(scanner);
        this.quantity = getQuantityInput(scanner);
        this.descriptions = inputDescription(scanner);
        this.status = inputProductStatus(scanner);
    }

    public void displayData() {
        System.out.println("Product ID: " + this.productId);
        System.out.println("Product Name: " + this.productName);
        System.out.println("Import Price: " + this.importPrice);
        System.out.println("Export Price: " + this.exportPrice);
        System.out.println("Profit: " + calProfit());
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Descriptions: " + this.descriptions);
        System.out.println("Status: " + (this.status ? "Đang bán" : "Không bán"));
        System.out.println("--------------------");
    }

    private String getInputProductId(Scanner scanner , Product[] arrProduct){
        final String regex = "^E\\w{3}$";
        System.out.println("Nhập vào mã sản phẩm");
        do {
            String productIdInput = scanner.nextLine();
            if (productIdInput.matches(regex)){
                // đúng định nghĩa kiểm tra trùng
                boolean isExist = false;
                for (int i = 0; i < arrProduct.length; i++) {
                    if (arrProduct[i] != null && arrProduct[i].getProductid() != null && arrProduct[i].getProductid().equals(productIdInput)){
                        isExist=true;
                        break;
                    }
                }
                if (isExist){
                    System.err.println("Mã sản phẩm dã tồn tại ,  Nập lại : ");
                }else {
                    return productIdInput;
                }

            }
            else System.err.println("Ma phải bắt đầu là E và độ dài 4 ,Nhập lại : ");
        }while (true);

    }

    private String getInputProductName(Scanner scanner, Product[] arrProduct) {
        final String regex = "^.{6,50}$";
        System.out.println("Nhập vào tên sản phẩm");
        do {
            String productNameInput = scanner.nextLine();
            if (productNameInput.matches(regex)) {
                // đúng định nghĩa kiểm tra trùng
                boolean isExist = false;
                for (int i = 0; i < arrProduct.length; i++) {
                    if (arrProduct[i] != null && arrProduct[i].getProductName() != null && arrProduct[i].getProductName().equals(productNameInput)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên sản phẩm đã tồn tại, Nhập lại: ");
                } else {
                    return productNameInput;
                }
            } else {
                System.err.println("Tên sản phẩm phải có từ 6-50 ký tự, Nhập lại: ");
            }
        } while (true);
    }

    private float getImportPriceInput(Scanner scanner) {
        System.out.println("Nhập vào giá nhập");
        while (true) {
            try {
                float importPriceInput = Float.parseFloat(scanner.nextLine());
                if (importPriceInput > 0) {
                    return importPriceInput;
                } else {
                    System.err.println("Giá nhập phải lớn hơn 0, Nhập lại: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Giá nhập phải là số, Nhập lại: ");
            }
        }
    }

    private float getExportPriceInput(Scanner scanner) {
        System.out.println("Nhập vào giá xuất");
        while (true) {
            try {
                float exportPriceInput = Float.parseFloat(scanner.nextLine());
                if (exportPriceInput > this.importPrice * 1.2) {
                    return exportPriceInput;
                } else {
                    System.err.println("Giá xuất phải lớn hơn giá nhập ít nhất 20%, Nhập lại: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Giá xuất phải là số, Nhập lại: ");
            }
        }
    }

    private int getQuantityInput(Scanner scanner) {
        System.out.println("Nhập vào số lượng sản phẩm");
        while (true) {
            try {
                int quantityInput = Integer.parseInt(scanner.nextLine());
                if (quantityInput > 0) {
                    return quantityInput;
                } else {
                    System.err.println("Số lượng sản phẩm phải lớn hơn 0, Nhập lại: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Số lượng sản phẩm phải là số nguyên, Nhập lại: ");
            }
        }
    }

    private String inputDescription(Scanner scanner) {
        System.out.println("Nhập vào mô tả sản phẩm");
        return scanner.nextLine();
    }

    private boolean inputProductStatus(Scanner scanner) {
        System.out.println("Nhập vào trạng thái sản phẩm (true/false)");
        while (true) {
            String statusInput = scanner.nextLine();
            if ("true".equalsIgnoreCase(statusInput)) {
                return true;
            } else if ("false".equalsIgnoreCase(statusInput)) {
                return false;
            } else {
                System.err.println("Trạng thái sản phẩm phải là true hoặc false, Nhập lại: ");
            }
        }
    }

    public float calProfit() {
        this.profit = this.exportPrice - this.importPrice;
        return profit;
    }

    // Các phương thức get/set
    public String getProductid() {
        return productId;
    }

    public void setProductid(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
