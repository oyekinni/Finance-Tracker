import java.util.ArrayList;

// Stores user information and manages transactions
public class User {

    private String name;
    private ArrayList<Transaction> transactions;

    public User(String name) {
        this.name = name;
        transactions = new ArrayList<>();
    }

    // Returns the list of transactions
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Adds a new transaction
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    // Calculates total balance
    public double getBalance() {
        double total = 0;

        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase("Income")) {
                total += t.getAmount();
            } else {
                total -= t.getAmount();
            }
        }

        return total;
    }

    // Prints all transactions
    public void printTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
