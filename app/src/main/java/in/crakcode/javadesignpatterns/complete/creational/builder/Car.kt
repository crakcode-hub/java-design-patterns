package `in`.crakcode.javadesignpatterns.complete.creational.builder

// The Product Class
class Car private constructor(
    val color: String,
    val engineType: String,
    val hasSunroof: Boolean,
    val hasGPS: Boolean
) {

    // A Builder Class for constructing the Car object
    data class Builder(
        var color: String = "White",
        var engineType: String = "Petrol",
        var hasSunroof: Boolean = false,
        var hasGPS: Boolean = false
    ) {

        fun color(color: String) = apply { this.color = color }
        fun engineType(engineType: String) = apply { this.engineType = engineType }
        fun sunroof(hasSunroof: Boolean) = apply { this.hasSunroof = hasSunroof }
        fun gps(hasGPS: Boolean) = apply { this.hasGPS = hasGPS }

        // The final step to build the Car object
        fun build() = Car(color, engineType, hasSunroof, hasGPS)
    }

    override fun toString(): String {
        return "Car(color='$color', engineType='$engineType', hasSunroof=$hasSunroof, hasGPS=$hasGPS)"
    }
}

// Usage
fun main() {
    // Using the Builder to create a Car object
    val car = Car.Builder()
        .color("Red")
        .engineType("Electric")
        .sunroof(true)
        .gps(true)
        .build()

    println(car)
}
