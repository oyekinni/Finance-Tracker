public class FinanceTracker {
    private User user;

    public FinanceTracker(User user) {
        this.user = user;
    }

    public void showSummary() {
        user.printTransactions();
        System.out.println("Total Balance: $" + user.getBalance());
    }
}
