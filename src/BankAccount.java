/**
 * Created with IntelliJ IDEA.
 * User: Nick
 * Date: 25/02/13
 * Time: 18:53
 * To change this template use File | Settings | File Templates.
 */

public class BankAccount {
    private int balance = 0;
    public int getBalance() {
        return balance;
    }
    public void deposit(int money) {
        synchronized (this) {
            balance = balance + money;
        }
    }
    public int retrieve(int money) {
        synchronized (this)  {
            int result = 0;
            if (balance > money) {
                result = money;
            } else {
                result = balance;
            }
            balance = balance - result;
            return result;
        }
    }
}
