package `in`.crakcode.javadesignpatterns.complete.behavioral.memento

// Memento: Stores the state of the text
class TextEditorMemento(val content: String)

// Originator: The text editor that creates and restores mementos
class TextEditor {
    private var content: String = ""

    fun type(words: String) {
        content = words
    }

    fun getContent(): String = content

    fun save(): String{
        return content
    }

    fun restore(memento: String) {
        content = memento
    }
}

// Caretaker: Keeps track of the mementos
class EditorHistory {
    private val history = mutableListOf<String>()

    fun save(memento: String) {
        history.add(memento)
    }

    fun undo(): String? {
        return if (history.isNotEmpty()) {
            history.removeAt(history.size - 1)
        } else {
            null
        }
    }
}

// Usage
fun main() {
    val editor = TextEditor()
    val history = EditorHistory()

    editor.type("Hello, ")
    history.save(editor.save())

    editor.type("world! ")
    history.save(editor.save())

    editor.type("Let's learn design patterns.")
    println("Current Content: ${editor.getContent()}") // Prints: Hello, world! Let's learn design patterns.

    editor.restore(history.undo()!!)  // Undo to "Hello, world! "
    println("After Undo: ${editor.getContent()}") // Prints: Hello, world!

    editor.restore(history.undo()!!)  // Undo to "Hello, "
    println("After Another Undo: ${editor.getContent()}") // Prints: Hello,
}
