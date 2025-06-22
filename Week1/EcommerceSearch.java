
class Product {
    int productId;
    String productName;
    String category;

    Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }
}

// Main program class
public class EcommerceSearch {

    public static int linearSearch(Product[] products, String keyName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(keyName)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, String keyName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = keyName.compareToIgnoreCase(products[mid].productName);
            if (compare == 0) return mid;
            else if (compare < 0) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public static void sortByName(Product[] products) {
        java.util.Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Shoes", "Footwear"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "T-shirt", "Clothing"),
            new Product(104, "Laptop", "Electronics"),
        };

        System.out.println("== Linear Search ==");
        int linearResult = linearSearch(products, "Phone");
        System.out.println(linearResult != -1 ? "Found at index " + linearResult : "Not found");

        System.out.println("\n== Binary Search ==");
        sortByName(products);
        int binaryResult = binarySearch(products, "Phone");
        System.out.println(binaryResult != -1 ? "Found at index " + binaryResult : "Not found");
        System.out.println("\n By Meenakshi A J - 6420952");
    }
}
