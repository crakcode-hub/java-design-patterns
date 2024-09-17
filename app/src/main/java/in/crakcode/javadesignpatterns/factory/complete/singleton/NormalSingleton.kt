package `in`.crakcode.javadesignpatterns.factory.complete.singleton

// Singleton with Single Locking
class SingleLockingSingleton private constructor() {

    companion object {
        @Volatile
        private var instance: SingleLockingSingleton? = null

        // Synchronized method for single locking
        @Synchronized
        fun getInstance(): SingleLockingSingleton {
            if (instance == null) {
                instance = SingleLockingSingleton()
            }
            return instance!!
        }
    }

    fun showMessage() {
        println("Single Locking Singleton")
    }
}

// Usage
fun main() {
    val singleton = SingleLockingSingleton.getInstance()
    singleton.showMessage()
}
