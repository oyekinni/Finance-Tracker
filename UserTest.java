public class UserTest {
    public static void main(String[] args) {
        User user = new User("Omotayo");

        user.addTransaction(new Transaction("Income", 1000));
        user.addTransaction(new Transaction("Expense", 200));

        user.printTransactions();
        System.out.println("Balance: $" + user.getBalance());
    }
}
