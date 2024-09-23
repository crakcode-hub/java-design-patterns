package `in`.crakcode.javadesignpatterns.complete.structural.bridge

interface MessageSender {
    fun sendMessage(message: String)
}


class SMSSender : MessageSender {
    override fun sendMessage(message: String) {
        println("Sending SMS: $message")
    }
}

class EmailSender : MessageSender {
    override fun sendMessage(message: String) {
        println("Sending Email: $message")
    }
}


class TextMessage(val sender: MessageSender) {
      fun send(content: String) {
        sender.sendMessage(content)
    }
}

class EmailMessage(val sender: MessageSender)  {
     fun send(content: String) {
        sender.sendMessage(content)
    }
}


fun main() {

    val smsSender = SMSSender()
    val emailSender = EmailSender()

    val textMessage = TextMessage(smsSender)
    textMessage.send("Hello via SMS")  // Output: Sending SMS: Hello via SMS

    val emailMessage = EmailMessage(emailSender)
    emailMessage.send("Hello via Email")
}