package `in`.crakcode.javadesignpatterns.complete.structural.decorator

interface Text {
    fun render(): String
}

class PlainText(private val content: String) : Text {
    override fun render(): String {
        return content
    }
}

abstract class TextDecorator(protected val text: Text) : Text {
    override fun render(): String {
        return text.render()
    }
}


class BoldTextDecorator(text: Text) : TextDecorator(text) {
    override fun render(): String {
        return "<b>${super.render()}</b>"  // Simulate bold HTML tag
    }
}


class ItalicTextDecorator(text: Text) : TextDecorator(text) {
    override fun render(): String {
        return "<i>${super.render()}</i>"  // Simulate italic HTML tag
    }
}

class UnderlineTextDecorator(text: Text) : TextDecorator(text) {
    override fun render(): String {
        return "<u>${super.render()}</u>"  // Simulate underline HTML tag
    }
}

class StrikeTextDecorator(text: Text) : TextDecorator(text) {
    override fun render(): String {
        return "<s>${super.render()}</s>"  // Simulate underline HTML tag
    }
}


fun main() {
    var text: Text = PlainText("Hello, World!")
    println(text.render())

    // Add bold formatting
    text = BoldTextDecorator(text)
    println(text.render())

    // Add italic formatting
    text = ItalicTextDecorator(text)
    println(text.render())

    // Add underline formatting
    text = UnderlineTextDecorator(text)
    println(text.render())

    text = StrikeTextDecorator(text)
    println(text.render())

}