package `in`.crakcode.javadesignpatterns.complete.structural.adapter

interface Reversible {
    fun reverse(): String
}

class NormalString(private val text: String) {
    fun getString(): String {
        return text
    }
}


class StringReversalAdapter(private val normalString: NormalString) : Reversible {
    override fun reverse(): String {
        return normalString.getString().reversed()
    }
}


fun main() {
    val normalString = NormalString("hello")
    val reversalAdapter = StringReversalAdapter(normalString)
    println(reversalAdapter.reverse())  // Output: "olleh"
}