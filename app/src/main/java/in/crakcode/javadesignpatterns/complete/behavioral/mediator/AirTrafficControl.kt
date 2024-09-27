package `in`.crakcode.javadesignpatterns.complete.behavioral.mediator

// Mediator Interface
interface AirTrafficControl {
    fun registerFlight(airplane: Airplane)
    fun notifyAboutStatus(airplane: Airplane, status: String)
}

// Concrete Mediator
class TrafficTower : AirTrafficControl {
    private val airplanes = mutableListOf<Airplane>()

    override fun registerFlight(airplane: Airplane) {
        airplanes.add(airplane)
    }

    override fun notifyAboutStatus(airplane: Airplane, status: String) {
        airplanes.filter { it != airplane }
            .forEach { it.receiveStatusUpdate(status) }
    }
}

// Colleague class
abstract class Airplane(protected val trafficControl: AirTrafficControl, val flightNumber: String) {
    abstract fun sendStatusUpdate(status: String)
    abstract fun receiveStatusUpdate(status: String)
}

// Concrete Colleague
class PassengerPlane(trafficControl: AirTrafficControl, flightNumber: String) : Airplane(trafficControl, flightNumber) {
    override fun sendStatusUpdate(status: String) {
        println("$flightNumber: Sending status -> $status")
        trafficControl.notifyAboutStatus(this, status)
    }

    override fun receiveStatusUpdate(status: String) {
        println("$flightNumber: Received status update -> $status")
    }
}

// Usage
fun main() {
    val trafficTower = TrafficTower()

    val plane1 = PassengerPlane(trafficTower, "Flight 101")
    val plane2 = PassengerPlane(trafficTower, "Flight 202")
    val plane3 = PassengerPlane(trafficTower, "Flight 303")

    trafficTower.registerFlight(plane1)
    trafficTower.registerFlight(plane2)
    trafficTower.registerFlight(plane3)

    plane1.sendStatusUpdate("Landing in 10 minutes")
    plane2.sendStatusUpdate("Departing now")
}
