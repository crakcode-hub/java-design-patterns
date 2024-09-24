package `in`.crakcode.javadesignpatterns.complete.structural.facade

class RoomDatabase {
    fun saveData(data: String) {
        println("Data saved in Room database: $data")
    }

    fun fetchData(): String {
        return "Data from Room database"
    }
}

class FirebaseDatabase {
    fun saveData(data: String) {
        println("Data saved in Firebase database: $data")
    }

    fun fetchData(): String {
        return "Data from Firebase database"
    }
}


class DatabaseFacade(
    private val roomDatabase: RoomDatabase = RoomDatabase(),
    private val firebaseDatabase: FirebaseDatabase = FirebaseDatabase()
) {
    fun saveToDatabases(data: String) {
        roomDatabase.saveData(data)
        firebaseDatabase.saveData(data)
    }

    fun fetchFromRoom(): String {
        return roomDatabase.fetchData()
    }

    fun fetchFromFirebase(): String {
        return firebaseDatabase.fetchData()
    }
}


fun main() {
    val databaseFacade = DatabaseFacade()

// Saving data to both Room and Firebase
    databaseFacade.saveToDatabases("Test Data")

// Fetching data from Room and Firebase
    val roomData = databaseFacade.fetchFromRoom()
    val firebaseData = databaseFacade.fetchFromFirebase()

    println(roomData)
    println(firebaseData)

}
