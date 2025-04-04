import java.util.*;

// Base User class
class User {
    String id;
    String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

// Farmer class
class Farmer extends User {
    String collectionPoint;
    List<MilkCollectionRequest> requests = new ArrayList<>();
    List<Transaction> transactions = new ArrayList<>();

    public Farmer(String id, String name, String collectionPoint) {
        super(id, name);
        this.collectionPoint = collectionPoint;
    }

    public void requestCollection(double quantity) {
        MilkCollectionRequest request = new MilkCollectionRequest(this, collectionPoint, quantity);
        requests.add(request);
        System.out.println(name + " requested collection of " + quantity + " liters at " + collectionPoint);
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History for " + name + ":");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}

// Collector class
class Collector extends User {
    List<MilkCollectionRequest> assignedRequests = new ArrayList<>();

    public Collector(String id, String name) {
        super(id, name);
    }

    public void assignRequest(MilkCollectionRequest request) {
        assignedRequests.add(request);
        System.out.println("Collector " + name + " assigned to collect from " + request.farmer.name);
    }

    public void collectMilk(MilkCollectionRequest request) {
        request.setCollected(true);
        Transaction transaction = new Transaction(request.farmer, this, request.quantity);
        request.farmer.transactions.add(transaction);
        System.out.println("Collector " + name + " collected " + request.quantity + " liters from " + request.farmer.name);
    }
}

// Group (Cooperative)
class Group extends User {
    List<Collector> collectors = new ArrayList<>();
    List<Transaction> groupTransactions = new ArrayList<>();

    public Group(String id, String name) {
        super(id, name);
    }

    public void addCollector(Collector collector) {
        collectors.add(collector);
    }

    public void verifyAndAddTransaction(Transaction transaction) {
        groupTransactions.add(transaction);
        System.out.println("Group " + name + " verified transaction: " + transaction);
    }

    public void generateReport() {
        System.out.println("Report for Group " + name + ":");
        for (Transaction t : groupTransactions) {
            System.out.println(t);
        }
    }
}

// Processor
class Processor extends User {
    List<Transaction> receivedTransactions = new ArrayList<>();

    public Processor(String id, String name) {
        super(id, name);
    }

    public void receiveMilk(Transaction transaction) {
        receivedTransactions.add(transaction);
        System.out.println("Processor " + name + " received " + transaction.quantity + " liters from group.");
    }

    public void forecastMilkCollection() {
        double total = 0;
        for (Transaction t : receivedTransactions) {
            total += t.quantity;
        }
        System.out.println("Forecast based on received milk: " + total + " liters");
    }
}

// Collection Request
class MilkCollectionRequest {
    Farmer farmer;
    String collectionPoint;
    double quantity;
    boolean collected = false;

    public MilkCollectionRequest(Farmer farmer, String collectionPoint, double quantity) {
        this.farmer = farmer;
        this.collectionPoint = collectionPoint;
        this.quantity = quantity;
    }

    public void setCollected(boolean status) {
        this.collected = status;
    }
}

// Transaction
class Transaction {
    Farmer farmer;
    Collector collector;
    double quantity;
    Date date;

    public Transaction(Farmer farmer, Collector collector, double quantity) {
        this.farmer = farmer;
        this.collector = collector;
        this.quantity = quantity;
        this.date = new Date();
    }

    public String toString() {
        return date + ": " + quantity + " liters collected from " + farmer.name + " by " + collector.name;
    }
}

// Main System
public class MilkCollectionSystem {
    public static void main(String[] args) {
        // Sample data
        Farmer farmer1 = new Farmer("F001", "Alice", "Point A");
        Collector collector1 = new Collector("C001", "Bob");
        Group group1 = new Group("G001", "Milk Group A");
        Processor processor1 = new Processor("P001", "Dairy Corp");

        // Registration
        group1.addCollector(collector1);

        // Farmer requests collection
        farmer1.requestCollection(15.5);

        // Assign collector
        MilkCollectionRequest request = farmer1.requests.get(0);
        collector1.assignRequest(request);

        // Collect milk
        collector1.collectMilk(request);

        // Group verifies transaction
        Transaction tx = farmer1.transactions.get(0);
        group1.verifyAndAddTransaction(tx);

        // Processor receives milk
        processor1.receiveMilk(tx);

        // Reports
        farmer1.viewTransactionHistory();
        group1.generateReport();
        processor1.forecastMilkCollection();
    }
}
