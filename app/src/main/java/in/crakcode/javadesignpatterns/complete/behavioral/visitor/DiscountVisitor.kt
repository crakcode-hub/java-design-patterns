package `in`.crakcode.javadesignpatterns.complete.behavioral.visitor

// Visitor Interface
interface DiscountVisitor {
    fun visit(electronicItem: ElectronicItem)
    fun visit(groceryItem: GroceryItem)

}

// Element Interface
interface Product {
    fun accept(visitor: DiscountVisitor)
    fun getPrice(): Double
}

// Concrete Element 1: Electronic Item
class ElectronicItem(private val price: Double, private val warranty: Int) : Product {
    override fun accept(visitor: DiscountVisitor) {
        visitor.visit(this)
    }

    override fun getPrice() = price

    fun getWarranty() = warranty
}

// Concrete Element 2: Grocery Item
class GroceryItem(private val price: Double, private val expiryDays: Int) : Product {
    override fun accept(visitor: DiscountVisitor) {
        visitor.visit(this)
    }

    override fun getPrice() = price

    fun getExpiryDays() = expiryDays
}

// Concrete Visitor: Applying Discount
class DiscountCalculatorVisitor : DiscountVisitor {
    private var totalDiscount: Double = 0.0

    override fun visit(electronicItem: ElectronicItem) {
        val discount = if (electronicItem.getWarranty() > 2) {
            electronicItem.getPrice() * 0.10 // 10% discount for warranty > 2 years
        } else {
            electronicItem.getPrice() * 0.05 // 5% discount otherwise
        }
        totalDiscount += discount
        println("Discount on electronic item: $discount")
    }

    override fun visit(groceryItem: GroceryItem) {
        val discount = if (groceryItem.getExpiryDays() < 7) {
            groceryItem.getPrice() * 0.20 // 20% discount if expiry is within a week
        } else {
            groceryItem.getPrice() * 0.05 // 5% discount otherwise
        }
        totalDiscount += discount
        println("Discount on grocery item: $discount")
    }

    fun getTotalDiscount(): Double {
        return totalDiscount
    }
}

// Usage
fun main() {
    val products: List<Product> = listOf(
        ElectronicItem(1000.0, 3), // $1000 price, 3-year warranty
        GroceryItem(100.0, 5), // $100 price, 5 days until expiry
        ElectronicItem(500.0, 1), // $500 price, 1-year warranty
        GroceryItem(50.0, 10) // $50 price, 10 days until expiry
    )

    val discountCalculator = DiscountCalculatorVisitor()

    // Apply visitor to all products
    products.forEach { it.accept(discountCalculator) }

    println("Total discount: ${discountCalculator.getTotalDiscount()}")
}
