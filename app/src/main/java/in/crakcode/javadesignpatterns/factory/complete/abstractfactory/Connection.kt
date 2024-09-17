package `in`.crakcode.javadesignpatterns.factory.complete.abstractfactory

// Abstract Product: Connection
interface Connection {
    fun connect()
}

// Abstract Product: Command
interface Command {
    fun executeCommand()
}

// Concrete Product: MySQL Connection
class MySQLConnection : Connection {
    override fun connect() {
        println("Connecting to MySQL")
    }
}

// Concrete Product: MySQL Command
class MySQLCommand : Command {
    override fun executeCommand() {
        println("Executing MySQL command")
    }
}

// Concrete Product: PostgreSQL Connection
class NoSQLConnection : Connection {
    override fun connect() {
        println("Connecting to PostgreSQL")
    }
}

// Concrete Product: PostgreSQL Command
class NoSQLCommand : Command {
    override fun executeCommand() {
        println("Executing PostgreSQL command")
    }
}

// Abstract Factory
interface DatabaseFactory {
    fun createConnection(): Connection
    fun createCommand(): Command
}

// Concrete Factory: MySQL
class MySQLFactory : DatabaseFactory {
    override fun createConnection(): Connection {
        return MySQLConnection()
    }

    override fun createCommand(): Command {
        return MySQLCommand()
    }
}

// Concrete Factory: PostgreSQL
class PostgreSQLFactory : DatabaseFactory {
    override fun createConnection(): Connection {
        return NoSQLConnection()
    }

    override fun createCommand(): Command {
        return NoSQLCommand()
    }
}

// Client code
class DatabaseApplication(private val factory: DatabaseFactory) {
    private val connection: Connection = factory.createConnection()
    private val command: Command = factory.createCommand()

    fun run() {
        connection.connect()
        command.executeCommand()
    }
}

// Usage
fun main() {
    val dbType = "MySQL" // Can be changed to "PostgreSQL"

    val factory: DatabaseFactory = if (dbType == "MySQL") {
        MySQLFactory()
    } else {
        PostgreSQLFactory()
    }

    val app = DatabaseApplication(factory)
    app.run()
}
