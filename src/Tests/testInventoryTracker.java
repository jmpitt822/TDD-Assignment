import org.junit.Test;


import java.util.Scanner;

import static org.junit.Assert.assertTrue;

/**
 * Created by jeremypitt on 9/16/16.
 */
public class testInventoryTracker {
    public static Scanner scanner = new Scanner(System.in);
    public static InventoryItem item = new InventoryItem();



    @Test
    public void choiceNewItem(){
        String itemName = "name";
        InventoryItem item = new InventoryItem(itemName);
        InventoryItem.items.add(item);

    }

    @Test
    public void choiceUpdateItem(){
        int itemQuantity = Integer.valueOf(scanner.nextLine());
        item.setQuantity(itemQuantity);

    }
    @Test
    public void choiceRemoveItem(){
        String choice = "3";

        assertTrue(choice.equals("3"));
        InventoryItem.removeItem();

    }


}
