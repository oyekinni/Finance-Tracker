public class FinanceTrackerTest {
    public static void main(String[] args) {
        User user = new User("Omotayo");

        user.addTransaction(new Transaction("Income", 800));
        user.addTransaction(new Transaction("Expense", 150));

        FinanceTracker app = new FinanceTracker(user);
        app.showSummary();
    }
}
