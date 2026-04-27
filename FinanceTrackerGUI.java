import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// JavaFX GUI for Finance Tracker
public class FinanceTrackerGUI extends Application {

    private User user = new User("Omotayo");
    private TextField typeField;
    private TextField amountField;
    private TextArea outputArea;

    @Override
    public void start(Stage stage) {
        Label title = new Label("Finance Tracker");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        Label typeLabel = new Label("Transaction Type:");
        typeField = new TextField();
        typeField.setPromptText("Income or Expense");

        Label amountLabel = new Label("Amount:");
        amountField = new TextField();
        amountField.setPromptText("Example: 150");

        Button addButton = new Button("Add Transaction");
        Button summaryButton = new Button("Show Summary");
        Button clearButton = new Button("Clear");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);

        // Event 1: Add transaction
        addButton.setOnAction(e -> addTransaction());

        // Event 2: Show summary
        summaryButton.setOnAction(e -> showSummary());

        // Event 3: Clear fields and output
        clearButton.setOnAction(e -> clearFields());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                title,
                typeLabel,
                typeField,
                amountLabel,
                amountField,
                addButton,
                summaryButton,
                clearButton,
                outputArea
        );

        Scene scene = new Scene(layout, 400, 450);
        stage.setTitle("Finance Tracker GUI");
        stage.setScene(scene);
        stage.show();
    }

    private void addTransaction() {
        String type = typeField.getText();
        String amountText = amountField.getText();

        try {
            double amount = Double.parseDouble(amountText);

            if (type.isEmpty()) {
                outputArea.setText("Please enter a transaction type.");
                return;
            }

            Transaction transaction = new Transaction(type, amount);
            user.addTransaction(transaction);

            outputArea.setText("Added transaction:\n" + type + " - $" + amount);

            typeField.clear();
            amountField.clear();

        } catch (NumberFormatException ex) {
            outputArea.setText("Please enter a valid number for amount.");
        }
    }

    private void showSummary() {
        double income = 0;
        double expenses = 0;

        for (Transaction t : user.getTransactions()) {
            if (t.getType().equalsIgnoreCase("Income")) {
                income += t.getAmount();
            } else if (t.getType().equalsIgnoreCase("Expense")) {
                expenses += t.getAmount();
            }
        }

        double balance = income - expenses;

        outputArea.setText(
                "Finance Summary\n" +
                "Total Income: $" + income + "\n" +
                "Total Expenses: $" + expenses + "\n" +
                "Balance: $" + balance
        );
    }

    private void clearFields() {
        typeField.clear();
        amountField.clear();
        outputArea.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
