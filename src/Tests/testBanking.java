import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by jeremypitt on 9/16/16.
 */
public class testBanking {
    HashMap<String, Double> accountInfo = new HashMap<>();
    Scanner scanner = new Scanner(System.in);


    @Test
    public void testCheckBal(){
        User user = new User("Jeremy", 100);
        User.checkBalance();
        assertTrue(User.getBalance() > 0);
    }

    @Test
    public void testWithdraw(){
        User user = new User("Jeremy", 100);
        User.withdraw();
        assertTrue(User.getNewBal() > 0);
    }

    @Test
    public void testDeleteAccount(){
        User user = new User("Jeremy", 100);
        User.deleteAccount();
        assertFalse(accountInfo.containsKey(user.getName()));
    }
}
