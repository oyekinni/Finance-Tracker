import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Transaction> transactions;
 // Stores user information and manages transactions

    public User(String name) {
        this.name = name;
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public double getBalance() {
        double total = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("Income")) {
                total += t.getAmount();
            } else {
                total -= t.getAmount();
            }
        }
        return total;
    }

    public void printTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
