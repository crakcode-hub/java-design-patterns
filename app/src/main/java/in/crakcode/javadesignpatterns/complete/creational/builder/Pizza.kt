package `in`.crakcode.javadesignpatterns.complete.creational.builder

// The Product Class
class Pizza private constructor(
    val size: String,
    val cheese: Boolean,
    val pepperoni: Boolean,
    val mushrooms: Boolean
) {

    // A Builder Class for constructing the Pizza object
    data class Builder(
        var size: String = "Medium",
        var cheese: Boolean = false,
        var pepperoni: Boolean = false,
        var mushrooms: Boolean = false
    ) {

        fun size(size: String) = apply { this.size = size }
        fun cheese(cheese: Boolean) = apply { this.cheese = cheese }
        fun pepperoni(pepperoni: Boolean) = apply { this.pepperoni = pepperoni }
        fun mushrooms(mushrooms: Boolean) = apply { this.mushrooms = mushrooms }

        // The final step to build the Pizza object
        fun build() = Pizza(size, cheese, pepperoni, mushrooms)
    }

    override fun toString(): String {
        return "Pizza(size='$size', cheese=$cheese, pepperoni=$pepperoni, mushrooms=$mushrooms)"
    }
}

// Usage
fun main() {
    // Using the Builder to create a Pizza object
    val pizza = Pizza.Builder()
        .size("Large")
        .build()

    println(pizza)
}
