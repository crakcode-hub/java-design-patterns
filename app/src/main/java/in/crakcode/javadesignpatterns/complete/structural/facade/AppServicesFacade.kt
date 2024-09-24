package `in`.crakcode.javadesignpatterns.complete.structural.facade

class AppServicesFacade(
    private val cameraService: CameraService,
    private val locationService: LocationService,
    private val storageService: StorageService
) {
    fun capturePhotoAndSaveLocation() {
        val photo = cameraService.takePhoto()
        val location = locationService.getCurrentLocation()
        storageService.saveFile(photo, location)
    }
}


class CameraService {
    fun takePhoto(): ByteArray {
        // Logic to access the camera and take a photo
        println("Camera: Taking a photo...")
        return ByteArray(0) // Dummy photo data
    }
}

class LocationService {
    fun getCurrentLocation(): String {
        // Logic to fetch the current GPS location
        println("Location: Fetching current location...")
        return "Lat: 37.7749, Long: -122.4194" // Dummy location
    }
}


class StorageService {
    fun saveFile(photo: ByteArray, location: String) {
        // Logic to save the photo and location data
        println("Storage: Saving photo and location ($location) to storage...")
    }
}


fun main() {
    val cameraService = CameraService()
    val locationService = LocationService()
    val storageService = StorageService()

    // Create the Facade
    val appServicesFacade = AppServicesFacade(cameraService, locationService, storageService)

    // Use the Facade to handle complex logic
    appServicesFacade.capturePhotoAndSaveLocation()
}