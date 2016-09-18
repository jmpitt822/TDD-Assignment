import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jeremypitt on 9/16/16.
 */
public class InventoryItem {
    public InventoryItem() {
    }

    public static Scanner scanner = new Scanner(System.in);
    static ArrayList<InventoryItem> items = new ArrayList<>();

    private String name;
    private int quantity;
    private String choice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public InventoryItem(String name){
        this.name = name;
        this.quantity = 0;
    }

    public static void chooseAction() {
        System.out.println("What would you like to do? [1. Enter a new Item | 2. Update an item | 3. Remove an item]");
        String choice = scanner.nextLine();

        switch (choice){
            case "1":
                newItem();
                break;
            case "2":
                updateItem();
                break;
            case "3":
                removeItem();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void newItem(){
        System.out.println("Enter the name of the item:");
        String itemName = scanner.nextLine();
        InventoryItem item = new InventoryItem(itemName);
        items.add(item);
    }

    public static void updateItem(){
        System.out.println("Enter the number of the item you wish to update:");
        int itemNum = Integer.valueOf(scanner.nextLine());
        InventoryItem item = items.get(itemNum - 1);
        System.out.println("Enter the quantity of the item:");
        int itemQuantity = Integer.valueOf(scanner.nextLine());
        item.quantity = itemQuantity;
    }

    public static void removeItem(){
        System.out.println("Enter the number of the item you wish to remove:");
        String removeChoice = scanner.nextLine();
        int itemNum = Integer.parseInt(removeChoice);
        items.remove(itemNum - 1);
    }
}
