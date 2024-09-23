package `in`.crakcode.javadesignpatterns.complete.creational.singleton

// Singleton with Double-Checked Locking
class DoubleCheckedLockingSingleton private constructor() {

    companion object {
        @Volatile
        private var instance: DoubleCheckedLockingSingleton? = null

        fun getInstance(): DoubleCheckedLockingSingleton {
            if (instance == null) { // First check (without locking)
                synchronized(this) {
                    if (instance == null) { // Second check (with locking)
                        instance = DoubleCheckedLockingSingleton()
                    }
                }
            }
            return instance!!
        }
    }

    fun showMessage() {
        println("Double-Checked Locking Singleton")
    }
}

// Usage
fun main() {
    val singleton = DoubleCheckedLockingSingleton.getInstance()
    singleton.showMessage()
}
