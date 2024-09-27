package `in`.crakcode.javadesignpatterns.complete.behavioral.state

// UI State Sealed Class





import kotlinx.coroutines.*

class State {
    fun fetchData(onResult: (UiState<String>) -> Unit) {
        onResult(UiState.Loading)
        // Simulating network call using Coroutine
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000) // Simulating delay
            val success = true // Simulate success or failure

            withContext(Dispatchers.Main) {
                if (success) {
                    onResult(UiState.Success("Fetched data successfully!"))
                } else {
                    onResult(UiState.Error("Failed to fetch data."))
                }
            }
        }
    }
}

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}
