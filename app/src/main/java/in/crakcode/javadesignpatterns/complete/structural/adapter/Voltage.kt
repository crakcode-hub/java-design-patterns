package `in`.crakcode.javadesignpatterns.complete.structural.adapter

interface Voltage {
    fun getVoltage(): Int
}


class Voltage220V {
    fun get220Voltage(): Int {
        return 220
    }
}


class VoltageAdapter(private val voltage220V: Voltage220V) : Voltage {
    override fun getVoltage(): Int {
        return voltage220V.get220Voltage() / 2
    }
}


fun main() {
    val voltage220 = Voltage220V()
    val voltageAdapter = VoltageAdapter(voltage220)
    println(voltageAdapter.getVoltage())  // Output: 110

}