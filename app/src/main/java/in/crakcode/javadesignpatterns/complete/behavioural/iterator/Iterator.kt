package `in`.crakcode.javadesignpatterns.complete.behavioural.iterator

interface Iterator<T> {
    fun hasNext(): Boolean
    fun next(): T
}

class Book(val name: String)

class BookCollection(private val books: List<Book>) {

    fun createIterator(): BookIterator {
        return BookIterator(books)
    }
}



class BookIterator(private val books: List<Book>) : Iterator<Book> {
    private var index = 0

    override fun hasNext(): Boolean {
        return index < books.size
    }

    override fun next(): Book {
        return books[index++]
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
    while (iterator.hasNext()) {
        val book = iterator.next()
        println(book.name)
    }
}
