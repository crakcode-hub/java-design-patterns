package `in`.crakcode.javadesignpatterns.factory.complete.abstractfactory

// Abstract Product: Engine
interface Engine {
    fun createEngine()
}

// Abstract Product: Tire
interface Tire {
    fun createTire()
}

// Concrete Product: BMW Engine
class BMWEngine : Engine {
    override fun createEngine() {
        println("Creating BMW Engine")
    }
}

// Concrete Product: BMW Tire
class BMWTire : Tire {
    override fun createTire() {
        println("Creating BMW Tire")
    }
}

// Concrete Product: Toyota Engine
class ToyotaEngine : Engine {
    override fun createEngine() {
        println("Creating Toyota Engine")
    }
}

// Concrete Product: Toyota Tire
class ToyotaTire : Tire {
    override fun createTire() {
        println("Creating Toyota Tire")
    }
}

// Abstract Factory
interface CarFactory {
    fun createEngine(): Engine
    fun createTire(): Tire
}

// Concrete Factory: BMW
class BMWFactory : CarFactory {
    override fun createEngine(): Engine {
        return BMWEngine()
    }

    override fun createTire(): Tire {
        return BMWTire()
    }
}

// Concrete Factory: Toyota
class ToyotaFactory : CarFactory {
    override fun createEngine(): Engine {
        return ToyotaEngine()
    }

    override fun createTire(): Tire {
        return ToyotaTire()
    }
}

// Client code
class Car(private val factory: CarFactory) {
    private val engine: Engine = factory.createEngine()
    private val tire: Tire = factory.createTire()

    fun assembleCar() {
        engine.createEngine()
        tire.createTire()
    }
}

// Usage
fun main() {
    val carBrand = "BMW" // Can be changed to "Toyota"

    val factory: CarFactory = if (carBrand == "BMW") {
        BMWFactory()
    } else {
        ToyotaFactory()
    }

    val car = Car(factory)
    car.assembleCar()
}
