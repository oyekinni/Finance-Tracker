import java.util.ArrayList;

// Stores user information and manages transactions
public class User {

    private String name;
    private ArrayList<Transaction> transactions;

    // Constructor
    public User(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    // Returns user name
    public String getName() {
        return name;
    }

    // Sets user name
    public void setName(String name) {
        this.name = name;
    }

    // Returns transaction list
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Adds a transaction
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Calculates current balance
    public double getBalance() {
        double balance = 0;

        for (Transaction t : transactions) {

            if (t.getType().equalsIgnoreCase("Income")) {
                balance += t.getAmount();
            }
            else if (t.getType().equalsIgnoreCase("Expense")) {
                balance -= t.getAmount();
            }
        }

        return balance;
    }

    // Displays all transactions
    public void printTransactions() {

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        }
        else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}
