package `in`.crakcode.javadesignpatterns.complete.behavioral.chainofresponsibility

// The base interface for all handlers
interface SupportHandler {
    fun setNextHandler(handler: SupportHandler): SupportHandler
    fun handleRequest(issue: String)
}


class BasicSupport : SupportHandler {
    private var nextHandler: SupportHandler? = null

    override fun setNextHandler(handler: SupportHandler): SupportHandler {
        this.nextHandler = handler
        return handler
    }

    override fun handleRequest(issue: String) {
        if (issue == "basic") {
            println("Basic Support: We can handle this issue.")
        } else {
            println("Basic Support: Can't handle, passing to the next handler.")
            nextHandler?.handleRequest(issue)
        }
    }
}


class TechnicalSupport : SupportHandler {
    private var nextHandler: SupportHandler? = null

    override fun setNextHandler(handler: SupportHandler): SupportHandler {
        this.nextHandler = handler
        return handler
    }

    override fun handleRequest(issue: String) {
        if (issue == "technical") {
            println("Technical Support: We can handle this technical issue.")
        } else {
            println("Technical Support: Can't handle, passing to the next handler.")
            nextHandler?.handleRequest(issue)
        }
    }
}


class Manager : SupportHandler {
    private var nextHandler: SupportHandler? = null

    override fun setNextHandler(handler: SupportHandler): SupportHandler {
        this.nextHandler = handler
        return handler
    }

    override fun handleRequest(issue: String) {
        if (issue == "manager") {
            println("Manager: I will handle this escalated issue.")
        } else {
            println("Manager: No one else can handle this issue.")
        }
    }
}

fun main() {
    // Create handlers
    val basicSupport = BasicSupport()
    val technicalSupport = TechnicalSupport()
    val manager = Manager()

    // Set up the chain
    basicSupport.setNextHandler(technicalSupport).setNextHandler(manager)

    // Send requests
    println("Handling a basic issue:")
    basicSupport.handleRequest("basic")

    println("\nHandling a technical issue:")
    basicSupport.handleRequest("technical")

    println("\nHandling a manager-level issue:")
    basicSupport.handleRequest("manager")

    println("\nHandling an unknown issue:")
    basicSupport.handleRequest("unknown")
}
