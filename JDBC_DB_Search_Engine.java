// 1. Database Indexing
// First, ensure your database has indexes on the columns you want to search. Indexes (usually B-trees) allow the database to find data in O(log N) time.

CREATE INDEX idx_username ON users (username);
CREATE INDEX idx_payment_id ON payments (payment_id);
CREATE INDEX idx_date ON transactions (transaction_date);

// Use parameterized queries in Java to leverage these indexes. Avoid operations that invalidate index usage (e.g., applying functions to indexed columns).

public class JDBC_DB_Search_Engine {
    public static void searchByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            // Process results...
        }
    }

    public static void searchByPaymentId(String paymentId) throws SQLException {
        String sql = "SELECT * FROM payments WHERE payment_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paymentId);
            ResultSet rs = stmt.executeQuery();
            // Process results...
        }
    }

    public static void searchByDate(Date date) throws SQLException {
        String sql = "SELECT * FROM transactions WHERE transaction_date = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, date);
            ResultSet rs = stmt.executeQuery();
            // Process results...
        }
    }
}

// 3. Handle Range Queries (Dates)
// For date ranges, ensure the column is stored in a sortable format (e.g., TIMESTAMP), and use indexed range queries:

public static void searchByDateRange(Date start, Date end) throws SQLException {
    String sql = "SELECT * FROM transactions WHERE transaction_date BETWEEN ? AND ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setDate(1, start);
        stmt.setDate(2, end);
        ResultSet rs = stmt.executeQuery();
        // Process results...
    }
}