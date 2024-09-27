package `in`.crakcode.javadesignpatterns.complete.behavioral.strategy

// Strategy interface
interface SharingStrategy {
    fun shareInfo(): String
}

//No Sharing
class NoSharing : SharingStrategy {
    override fun shareInfo(): String {
        return "Sorry, I can't share this information."
    }
}

//Partial Sharing
class PartialSharing : SharingStrategy {
    override fun shareInfo(): String {
        return "I can share some details, but not everything."
    }
}

//  Full Sharing
class FullSharing : SharingStrategy {
    override fun shareInfo(): String {
        return "Sure, here's all the information you asked for!"
    }
}

// Context: A person deciding how much info to share
class InformationRequester(private var sharingStrategy: SharingStrategy) {
    fun setSharingStrategy(strategy: SharingStrategy) {
        sharingStrategy = strategy
    }

    fun askForInfo(): String {
        return sharingStrategy.shareInfo()
    }
}

// Usage
fun main() {
    val requester = InformationRequester(NoSharing())

    // Initial strategy: No Sharing
    println(requester.askForInfo())  // Output: Sorry, I can't share this information.

    // Change strategy to Partial Sharing
    requester.setSharingStrategy(PartialSharing())
    println(requester.askForInfo())  // Output: I can share some details, but not everything.

    // Change strategy to Full Sharing
    requester.setSharingStrategy(FullSharing())
    println(requester.askForInfo())  // Output: Sure, here's all the information you asked for!
}
