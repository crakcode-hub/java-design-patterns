package `in`.crakcode.javadesignpatterns.complete.creational.factory

// Logger interface
internal interface Logger {
    fun log(message: String?)
}


class DevelopmentLogger : Logger {
    override fun log(message: String?) {
        println("Development log: $message")
    }
}


// Concrete Logger for production environment
class ProductionLogger : Logger {
    override fun log(message: String?) {
        println("Production log: $message")
    }
}


// Logger Factory
internal object LoggerFactory {
    fun getLogger(environment: String): Logger {
        return if (environment.equals("development", ignoreCase = true)) {
            DevelopmentLogger()
        } else if (environment.equals("production", ignoreCase = true)) {
            ProductionLogger()
        } else {
            throw IllegalArgumentException("Unknown environment: $environment")
        }
    }
}


// Usage
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val logger = LoggerFactory.getLogger("development")
        logger.log("This is a test message.")
        val prodLogger = LoggerFactory.getLogger("production")
        prodLogger.log("This is a production log message.")
    }
}

