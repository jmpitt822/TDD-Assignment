public class InventoryMain {

    public static InventoryItem item = new InventoryItem();

    public static void main(String[] args) {
        while (true){
            int i = 1;
            System.out.println("Item List:");
            for (InventoryItem item : InventoryItem.items) {
                System.out.println(i + ". " + item.getName() + ", " + item.getQuantity());
                i++;
            }
            System.out.println("---");
            InventoryItem.chooseAction();
        }



    }

}
