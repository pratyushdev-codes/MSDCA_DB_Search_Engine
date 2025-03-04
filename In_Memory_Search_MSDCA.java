// Index Maintenance: Indexes speed up reads but slow down writes. Use them judiciously.

// Parameterized Queries: Prevent SQL injection and ensure the database uses indexes.

// Data Types: Store dates in sortable formats (e.g., TIMESTAMP).

// Scalability: For large datasets, databases with indexes are more efficient than in-memory structures.


// PAYMENT SEARCH TREE - TreeMap

public class In_Memory_Search_MSDCA {
     public static void main(String[] args) {
        TreeMap<String, String> usernameMap = new TreeMap<>();
        TreeMap<String, String> paymentIdMap = new TreeMap<>();
        TreeMap<String, String> dateMap = new TreeMap<>();

        // Simulating data storage
        usernameMap.put("Alice", "PAY1001");
        usernameMap.put("Bob", "PAY1002");
        paymentIdMap.put("PAY1001", "Alice");
        dateMap.put("2024-03-01", "PAY1001");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter search type (username, payment_id, date): ");
        String searchType = scanner.nextLine();

        System.out.println("Enter search value: ");
        String searchValue = scanner.nextLine();

        if (searchType.equals("username") && usernameMap.containsKey(searchValue)) {
            System.out.println("Payment ID: " + usernameMap.get(searchValue));
        } else if (searchType.equals("payment_id") && paymentIdMap.containsKey(searchValue)) {
            System.out.println("Username: " + paymentIdMap.get(searchValue));
        } else if (searchType.equals("date") && dateMap.containsKey(searchValue)) {
            System.out.println("Payment ID: " + dateMap.get(searchValue));
        } else {
            System.out.println("Not found.");
        }
    }
}
