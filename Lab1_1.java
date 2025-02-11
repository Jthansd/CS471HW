import java.util.ArrayList;
import java.util.List;

public class Lab1_1 {

    /* Product Class
    id = id # of the product
    name = name of the product
    price = price of the product
    */
    public static class Product {
        private final int id;
        private final String name;
        private final double price;

        //Product constructor
        public Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
        //"get" functions to fetch the id, name, and price of the products
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

    }

    /*SortingUtility class
    contains instructions on how to sort the list of products
    */
    public static class SortingUtility {

        //Allows bubbleSort OR quickSort to be picked depending on the value of "sortingApproach"
        public List<Product> sort(List<Product> products, int sortingApproach) {
            //bubbleSort
            if (sortingApproach == 1) {
                return bubbleSort(products);
            }
            //QuickSort 
            else if (sortingApproach == 2) {
                return quickSort(products);
            }
            //if an invalid "sortingApproach" value is given, the function returns the original product list
            return products;
        }

        //logic for the quickSort function
        private List<Product> quickSort(List<Product> products) {
            quickSortHelper(products, 0, products.size() - 1);
            return products;
        }

        /*QuickSortHelper
        Recursively sorts through the list of products by repeatedly partitioning half of the list at a time
        products = list of products to be sorted
        low = lowest product index number of the product list segment being sorted
        high = highest product index number of the product list segment being sorted
        */
        private void quickSortHelper(List<Product> products, int low, int high) {
            if (low < high) {
                //partiotions the current segment of the product list
                int p = partition(products, low, high);
                //sorts the left half of the product list segment
                quickSortHelper(products, low, p - 1);
                //sorts the right hald of the product list segment
                quickSortHelper(products, p + 1, high); 
            }
        }

        /* Partition is used to separate the list of product into halves for sorting
        products = list of products to be sorted
        low = lowest product index number of the product list segment being sorted
        high = highest product index number of the product list segment being sorted
        */
        private int partition(List<Product> products, int low, int high) {
            //Pivot is set as the last element in the list. It is swapped if the name of the product comes before the product at "i" alphabetically
            Product pivot = products.get(high);
            int i = low - 1;

            for (int j = low; j <= high - 1; j++) {
                //compares the names of the pivot product and the product at index "j" alphabetically
                if (products.get(j).getName().compareTo(pivot.getName()) < 0) {
                    i++;
                    //swaps if the current product name comes first alphabetically compared to the pivot name
                    swap(products, i, j); 
                }
            }
            //swaps the pivot into the correct position
            swap(products, i + 1, high);
            //returns the index of the partition
            return i + 1;
        }

        /*logic for swapping two elements in the list
        products = list to be sorted
        i = element 1 to be swapped
        j = element 2 to be swapped
        */
        private void swap(List<Product> products, int i, int j) {
            Product temp = products.get(i);
            products.set(i, products.get(j));
            products.set(j, temp);
        }

        //Logic for bubbleSort function
        private List<Product> bubbleSort(List<Product> products) {
            int n = products.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    //Compares product IDs and swaps accordingly
                    if (products.get(j).getPrice() > products.get(j + 1).getPrice()) {
                        swap(products, j, j + 1);
                    }
                }
            }
            return products;
        }
    }

    public static void main(String[] args) {
        //new product list
        List<Product> products = new ArrayList<>();
        products.add(new Product(3, "Shampoo", 5.99));
        products.add(new Product(10, "Laptop", 899.99));
        products.add(new Product(8, "Toothpaste", 2.49));
        products.add(new Product(7, "T-shirt", 12.99));
        products.add(new Product(5, "Blender", 39.99));
        products.add(new Product(6, "Headphones", 59.99));
        products.add(new Product(9, "Soda", 1.49));
        products.add(new Product(1, "Microwave", 79.99));
        products.add(new Product(11, "Coffee Maker", 24.99));
        products.add(new Product(2, "Vacuum Cleaner", 129.99));
        products.add(new Product(14, "Dish Soap", 3.49));
        products.add(new Product(12, "Sweater", 19.99));
        products.add(new Product(15, "Cell Phone", 499.99));
        products.add(new Product(13, "Cereal", 3.99));
        products.add(new Product(4, "Table Lamp", 14.99));


        SortingUtility sortingUtility = new SortingUtility();

        //QuckSort Test Case
        System.out.println("Using QuickSort:");
        List<Product> sortedProductsQuickSort = sortingUtility.sort(products, 2);
        for (Product product : sortedProductsQuickSort) {
            System.out.println("Product{Id=" + product.getId() + ", Name=" + product.getName() + ", Price=" + product.getPrice() + "}");
        }

        //BubbleSort Test Case
        System.out.println("\nUsing BubbleSort:");
        List<Product> sortedProductsBubbleSort = sortingUtility.sort(products, 1);
        for (Product product : sortedProductsBubbleSort) {
            System.out.println("Product{Id=" + product.getId() + ", Name=" + product.getName() + ", Price=" + product.getPrice() + "}");
        }
    }
}
