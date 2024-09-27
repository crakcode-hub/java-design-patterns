package `in`.crakcode.javadesignpatterns.complete.behavioral.command

interface Command {
    fun execute()
}


class TV {
    fun turnOn() {
        println("The TV is ON")
    }

    fun turnOff() {
        println("The TV is OFF")
    }
}

class TVOnCommand(private val tv: TV) : Command {
    override fun execute() {
        tv.turnOn()
    }
}

class TVOffCommand(private val tv: TV) : Command {
    override fun execute() {
        tv.turnOff()
    }
}

class RemoteControl {
    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun pressButton() {
        command?.execute()
    }
}

fun main() {
    val tv = TV()

    val tvOnCommand = TVOnCommand(tv)
    val tvOffCommand = TVOffCommand(tv)

    val remote = RemoteControl()

    // Turn the TV on
    remote.setCommand(tvOnCommand)
    remote.pressButton()  // Output: The TV is ON

    // Turn the TV off
    remote.setCommand(tvOffCommand)
    remote.pressButton()  // Output: The TV is OFF
}
