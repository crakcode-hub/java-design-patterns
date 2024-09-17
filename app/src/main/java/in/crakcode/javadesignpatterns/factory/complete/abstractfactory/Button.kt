package `in`.crakcode.javadesignpatterns.factory.complete.abstractfactory

// Abstract Product: Button
interface Button {
    fun paint()
}

// Abstract Product: Checkbox
interface Checkbox {
    fun paint()
}

// Concrete Product: Windows Button
class WindowsButton : Button {
    override fun paint() {
        println("Rendering Windows Button")
    }
}

// Concrete Product: Windows Checkbox
class WindowsCheckbox : Checkbox {
    override fun paint() {
        println("Rendering Windows Checkbox")
    }
}

// Concrete Product: MacOS Button
class MacOSButton : Button {
    override fun paint() {
        println("Rendering MacOS Button")
    }
}

// Concrete Product: MacOS Checkbox
class MacOSCheckbox : Checkbox {
    override fun paint() {
        println("Rendering MacOS Checkbox")
    }
}

// Abstract Factory
interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}

// Concrete Factory: Windows
class WindowsFactory : GUIFactory {
    override fun createButton(): Button {
        return WindowsButton()
    }

    override fun createCheckbox(): Checkbox {
        return WindowsCheckbox()
    }
}

// Concrete Factory: MacOS
class MacOSFactory : GUIFactory {
    override fun createButton(): Button {
        return MacOSButton()
    }

    override fun createCheckbox(): Checkbox {
        return MacOSCheckbox()
    }
}

// Client code
class Application(private val factory: GUIFactory) {
    private val button: Button = factory.createButton()
    private val checkbox: Checkbox = factory.createCheckbox()

    fun paint() {
        button.paint()
        checkbox.paint()
    }
}

// Usage
fun main() {
    val osType = "Windows" // This can be changed to "MacOS" for the other factory

    val factory: GUIFactory = if (osType == "Windows") {
        WindowsFactory()
    } else {
        MacOSFactory()
    }

    val app = Application(factory)
    app.paint()
}
