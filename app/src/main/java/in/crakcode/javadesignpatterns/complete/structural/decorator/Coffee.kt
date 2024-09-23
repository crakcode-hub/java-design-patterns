package `in`.crakcode.javadesignpatterns.complete.structural.decorator

interface Coffee {
    fun cost(): Double
    fun description(): String
}


class SimpleCoffee : Coffee {
    override fun cost(): Double {
        return 2.0 // Base price for simple coffee
    }

    override fun description(): String {
        return "Simple coffee"
    }
}


abstract class CoffeeDecorator(protected val coffee: Coffee) : Coffee {
    override fun cost(): Double {
        return coffee.cost()
    }

    override fun description(): String {
        return coffee.description()
    }
}


class MilkDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Double {
        return super.cost() + 0.5 // Adding cost of milk
    }

    override fun description(): String {
        return super.description() + ", with milk"
    }
}

class SugarDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Double {
        return super.cost() + 0.2 // Adding cost of sugar
    }

    override fun description(): String {
        return super.description() + ", with sugar"
    }
}

class WhippedCreamDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Double {
        return super.cost() + 0.7 // Adding cost of whipped cream
    }

    override fun description(): String {
        return super.description() + ", with whipped cream"
    }
}




fun main() {
    fun main() {
        // Basic simple coffee
        var myCoffee: Coffee = SimpleCoffee()
        println("${myCoffee.description()} costs \$${myCoffee.cost()}")

        // Add milk
        myCoffee = MilkDecorator(myCoffee)
        println("${myCoffee.description()} costs \$${myCoffee.cost()}")

        // Add sugar
        myCoffee = SugarDecorator(myCoffee)
        println("${myCoffee.description()} costs \$${myCoffee.cost()}")

        // Add whipped cream
        myCoffee = WhippedCreamDecorator(myCoffee)
        println("${myCoffee.description()} costs \$${myCoffee.cost()}")

        // Output:
        // Simple coffee costs $2.0
        // Simple coffee, with milk costs $2.5
        // Simple coffee, with milk, with sugar costs $2.7
        // Simple coffee, with milk, with sugar, with whipped cream costs $3.4
    }

}
