package `in`.crakcode.javadesignpatterns.complete.structural.adapter

interface Temperature {
    fun getTemperature(): Double
}

class CelsiusTemperature(private val tempInCelsius: Double) {
    fun getCelsius(): Double {
        return tempInCelsius
    }
}

class CelsiusToFahrenheitAdapter(private val celsiusTemperature: CelsiusTemperature) : Temperature {
    override fun getTemperature(): Double {
        return celsiusTemperature.getCelsius() * 9/5 + 32
    }
}


fun main() {
    val celsiusTemp = CelsiusTemperature(25.0)
    val tempAdapter = CelsiusToFahrenheitAdapter(celsiusTemp)
    println(tempAdapter.getTemperature())  // Output: 77.0 (in Fahrenheit)
}

