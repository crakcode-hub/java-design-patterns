package `in`.crakcode.javadesignpatterns.complete.structural.composit

interface UIElement {
    fun render()
}

class Button(private val label: String) : UIElement {
    override fun render() {
        println("Rendering Button: $label")
    }
}

class TextView(private val text: String) : UIElement {
    override fun render() {
        println("Rendering TextView: $text")
    }
}


class ViewGroup(private val name: String) : UIElement {
    private val elements = mutableListOf<UIElement>()

    fun addElement(element: UIElement) {
        elements.add(element)
    }

    override fun render() {
        println("Rendering ViewGroup: $name")
        elements.forEach { it.render() }
    }
}


fun main() {
        // Create individual views
        val button = Button("Submit")
        val textView = TextView("Welcome to the app")

        // Create a ViewGroup and add elements
        val mainLayout = ViewGroup("Main Layout")
        mainLayout.addElement(button)
        mainLayout.addElement(textView)

        // Create a nested ViewGroup
        val subLayout = ViewGroup("Sub Layout")
        subLayout.addElement(Button("Cancel"))
        subLayout.addElement(TextView("Enter your details"))

        // Add the sub layout to the main layout
        mainLayout.addElement(subLayout)

        // Render the entire layout
        mainLayout.render()

        // Output:
        // Rendering ViewGroup: Main Layout
        // Rendering Button: Submit
        // Rendering TextView: Welcome to the app
        // Rendering ViewGroup: Sub Layout
        // Rendering Button: Cancel
        // Rendering TextView: Enter your details

}