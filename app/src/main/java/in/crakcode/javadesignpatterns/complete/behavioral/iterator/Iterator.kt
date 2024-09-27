package `in`.crakcode.javadesignpatterns.complete.behavioral.iterator

interface Iterator<T> {
    fun hasNext(): Boolean
    fun next(): T

    fun hasPrevious() : Boolean

    fun previous() : T
}

class Book(val name: String)

class BookCollection(private val books: List<Book>) {

    fun createIterator(): BookIterator {
        return BookIterator(books)
    }
}



class BookIterator(private val books: List<Book>) : Iterator<Book> {
    private var index = books.size-1

    override fun hasNext(): Boolean {
        return index < books.size
    }

    override fun next(): Book {
        return books[index++]
    }

    override fun hasPrevious(): Boolean {
        return index >= 0
    }

    override fun previous(): Book {
        return books[index--]
    }
}


fun main() {
    val books = listOf(
        Book("Kotlin for Beginners"),
        Book("Design Patterns in Kotlin"),
        Book("Advanced Android Development")
    )

    val bookCollection = BookCollection(books)
    val iterator = bookCollection.createIterator()

    println("Books in collection:")
    while (iterator.hasPrevious()) {
        val book = iterator.previous()
        println(book.name)
    }
}
