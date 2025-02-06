import java.util.ArrayList;
import java.util.List;


//Sorting Class
interface Sorting{
    List<Product> sort(List<Product> items, int sortingApproach);
}


//Product Class
class Product{
    private final int ID;
    private String name;
    private double price;

    //constructor for Product
    public Product(int ID, String name, double price){
        this.ID = ID;
        this.name = name;
        this.price = price;

    }

    //get methods for ID, name, and price
    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

}


public class Lab1_1 {
    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Book", 24.99));
        products.add(new Product(2, "Bag", 14.99));
        products.add(new Product(3, "Button", 0.99));

        for (int i = 0; i < products.size(); i++){
            Product product = products.get(i);
            System.out.println("ID: " + product.getID() + " Name: " + product.getName() + " Price: " + product.getPrice());
        }
        
    }
}

/*
// Step 1: Define the Sorting interface
interface Sorting {
    List<Product> sort(List<Product> items, int sortingApproach);
}

// Step 2: Create the Product class
class Product {
    private final int id;
    private final String name;
    private final double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

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

// Step 3: Implement the SortingUtility class with bubbleSort and quickSort
class SortingUtility implements Sorting {
    
    private List<Product> bubbleSort(List<Product> items) {
        List<Product> sortedList = new ArrayList<>(items);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - 1 - i; j++) {
                if (sortedList.get(j).getPrice() > sortedList.get(j + 1).getPrice()) {
                    Product temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }
        return sortedList;
    }

    private List<Product> quickSort(List<Product> items) {
        List<Product> sortedList = new ArrayList<>(items);
        quickSortHelper(sortedList, 0, sortedList.size() - 1);
        return sortedList;
    }

    private void quickSortHelper(List<Product> items, int low, int high) {
        if (low < high) {
            int pi = partition(items, low, high);
            quickSortHelper(items, low, pi - 1);
            quickSortHelper(items, pi + 1, high);
        }
    }

    private int partition(List<Product> items, int low, int high) {
        Product pivot = items.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (items.get(j).getPrice() < pivot.getPrice()) {
                i++;
                Product temp = items.get(i);
                items.set(i, items.get(j));
                items.set(j, temp);
            }
        }
        Product temp = items.get(i + 1);
        items.set(i + 1, items.get(high));
        items.set(high, temp);
        return i + 1;
    }

    @Override
    public List<Product> sort(List<Product> items, int sortingApproach) {
        if (sortingApproach == 1) {
            return bubbleSort(items);
        } else if (sortingApproach == 2) {
            return quickSort(items);
        }
        return items;
    }
}

// Step 4: Create the LoggingDecorator class
class LoggingDecorator implements Sorting {
    private final Sorting sortingUtility;

    public LoggingDecorator(Sorting sortingUtility) {
        this.sortingUtility = sortingUtility;
    }

    @Override
    public List<Product> sort(List<Product> items, int sortingApproach) {
        List<Product> sortedItems = sortingUtility.sort(items, sortingApproach);
        if (sortingApproach == 1) {
            // Bubble sort log format: ID, Name, Price
            sortedItems.forEach(item -> System.out.println(item.getId() + ", " + item.getName() + ", " + item.getPrice()));
        } else if (sortingApproach == 2) {
            // Quick sort log format: Name, ID, Price
            sortedItems.forEach(item -> System.out.println(item.getName() + ", " + item.getId() + ", " + item.getPrice()));
        }
        return sortedItems;
    }
}

// Step 5: Test scenarios
public class Lab1_1 {
    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Book", 12.99));
        products.add(new Product(2, "Bag", 19.99));
        products.add(new Product(3, "Button", 2.49));

        // Create the SortingUtility object
        Sorting sortingUtility = new SortingUtility();

        // Decorate the SortingUtility with logging functionality
        Sorting loggingSortingUtility = new LoggingDecorator(sortingUtility);

        // Scenario 1: QuickSort (sortingApproach = 2)
        System.out.println("QuickSort Sorted Products:");
        loggingSortingUtility.sort(products, 2);

        // Scenario 2: BubbleSort (sortingApproach = 1)
        System.out.println("\nBubbleSort Sorted Products:");
        loggingSortingUtility.sort(products, 1);
    }
}
*/