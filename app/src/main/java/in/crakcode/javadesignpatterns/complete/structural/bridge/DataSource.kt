package `in`.crakcode.javadesignpatterns.complete.structural.bridge

interface DataSource {
    fun fetchData(): String
}

class RemoteDataSource : DataSource {
    override fun fetchData(): String {
        // Simulate fetching data from an API
        return "Data from API"
    }
}

class LocalDataSource : DataSource {
    override fun fetchData(): String {
        // Simulate fetching data from a local database
        return "Data from Local Database"
    }
}


interface Repo {
    fun getData() : String
}

class UserRepository(val dataSource: DataSource) : Repo {
    override fun getData(): String {
        return "User Repository: ${dataSource.fetchData()}"
    }
}

class ProductRepository(val dataSource: DataSource) : Repo {
    override fun getData(): String {
        return "Product Repository: ${dataSource.fetchData()}"
    }
}


fun main() {
    fun main() {
        // Use remote API data source
        val remoteDataSource = RemoteDataSource()
        val userRepository = UserRepository(remoteDataSource)
        println(userRepository.getData())  // Output: User Repository: Data from API

        // Use local database data source
        val localDataSource = LocalDataSource()
        val productRepository = ProductRepository(localDataSource)
        println(productRepository.getData())  // Output: Product Repository: Data from Local Database
    }

}