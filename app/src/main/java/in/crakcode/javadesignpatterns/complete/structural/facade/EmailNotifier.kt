package `in`.crakcode.javadesignpatterns.complete.structural.facade

class EmailNotifier {
    fun sendEmail(to: String, message: String) {
        println("Sending email to $to: $message")
    }
}

class SMSNotifier {
    fun sendSMS(to: String, message: String) {
        println("Sending SMS to $to: $message")
    }
}

class PushNotifier {
    fun sendPushNotification(to: String, message: String) {
        println("Sending push notification to $to: $message")
    }
}

class NotificationFacade(
    private val emailNotifier: EmailNotifier = EmailNotifier(),
    private val smsNotifier: SMSNotifier = SMSNotifier(),
    private val pushNotifier: PushNotifier = PushNotifier()
) {
    fun sendNotification(type: String, to: String, message: String) {
        when (type) {
            "email" -> emailNotifier.sendEmail(to, message)
            "sms" -> smsNotifier.sendSMS(to, message)
            "push" -> pushNotifier.sendPushNotification(to, message)
            else -> println("Invalid notification type")
        }
    }
}


fun main() {
    val notificationFacade = NotificationFacade()
    notificationFacade.sendNotification("email", "test@example.com", "Hello via Email!")
    notificationFacade.sendNotification("sms", "1234567890", "Hello via SMS!")
    notificationFacade.sendNotification("push", "user123", "Hello via Push Notification!")

}
