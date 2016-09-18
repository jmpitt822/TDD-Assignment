import java.util.Scanner;

/**
 * Created by jeremypitt on 9/16/16.
 */
public class BankingMain {
    public static Scanner scanner = new Scanner(System.in);
    public static User user = new User();

    public static void main(String[] args) throws Exception {


        boolean b = true;

        while (b) {
            user.chooseUser();

            boolean d = true;
            while (d) {
                d = user.chooseAction();
            }
        }

    }

}
