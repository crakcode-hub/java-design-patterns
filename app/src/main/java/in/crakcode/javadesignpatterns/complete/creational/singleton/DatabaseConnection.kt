package `in`.crakcode.javadesignpatterns.complete.creational.singleton

// Singleton class that manages a database connection
class DatabaseConnection private constructor() {

    init {
        println("DatabaseConnection initialized")
    }

    companion object {
        // Lazy initialization and thread-safe singleton instance
        val instance: DatabaseConnection by lazy {
            DatabaseConnection()
        }
    }

    fun query(sql: String) {
        // Simulate querying the database
        println("Executing query: $sql")
    }
}

// Usage
fun main() {
    val connection1 = DatabaseConnection.instance
    connection1.query("SELECT * FROM users")

    val connection2 = DatabaseConnection.instance
    connection2.query("SELECT * FROM orders")

    // Both connection1 and connection2 are the same instance
    println(connection1 === connection2)  // Output: true
}
