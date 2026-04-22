public class Transaction {
    private String type;
    private double amount;
      // Represents a single financial transaction
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + ": $" + amount;
    }
}
