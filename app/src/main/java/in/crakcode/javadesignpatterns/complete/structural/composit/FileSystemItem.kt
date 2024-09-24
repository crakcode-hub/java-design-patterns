package `in`.crakcode.javadesignpatterns.complete.structural.composit

interface FileSystemItem {
    fun getName(): String
    fun getSize(): Int  // Returns size in KB
}

class File(private val name: String, private val size: Int) : FileSystemItem {
    override fun getName(): String {
        return name
    }

    override fun getSize(): Int {
        return size
    }
}


class Folder(private val name: String) : FileSystemItem {
    private val items = mutableListOf<FileSystemItem>()
    fun addItem(item: FileSystemItem) {
        items.add(item)
    }

    override fun getName(): String {
        return name
    }

    override fun getSize(): Int {
        // Total size is the sum of the sizes of all items in the folder
        return items.sumOf { it.getSize() }
    }
}

fun main() {

        // Create individual files
        val file1 = File("file1.txt", 500)
        val file2 = File("file2.txt", 300)

        // Create a folder and add files
        val folder = Folder("Documents")
        folder.addItem(file1)
        folder.addItem(file2)

        // Create a subfolder
        val subFolder = Folder("SubDocuments")
        subFolder.addItem(File("file3.txt", 200))

        // Add subfolder to the main folder
        folder.addItem(subFolder)

        // Print total size of the main folder
        println("${folder.getName()} folder size: ${folder.getSize()} KB")
        // Output: Documents folder size: 1000 KB

}
