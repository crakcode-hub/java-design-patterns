package `in`.crakcode.javadesignpatterns.complete.structural.proxy

class NetworkAPI {
    fun fetchData(): String {
        println("Fetching data from the network...")
        return "Network Data"
    }
}

class NetworkAPIProxy(
    private val realAPI: NetworkAPI = NetworkAPI()
) {
    private var cachedData: String? = null

    fun fetchData(): String {
        if (cachedData == null) {
            println("Data not cached. Fetching from network...")
            cachedData = realAPI.fetchData() // Fetch and cache the data
        } else {
            println("Returning cached data...")
        }
        return cachedData ?: "No data"
    }
}


fun main() {
    val networkProxy = NetworkAPIProxy()

    val data1 = networkProxy.fetchData() // First time, fetch from network
    println(data1)

    val data2 = networkProxy.fetchData() // Second time, return cached data
    println(data2)

}