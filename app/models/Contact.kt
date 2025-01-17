package Kotlin03_ChatBot.app.models

import java.time.LocalDateTime

class Contact(
    val id: Int = Contact.generateId(),
    var name: String,
    var phoneNumber: String,
    val createdAt: String = LocalDateTime.now().toString()
) {

    fun updateNumber(newNumber: String){
        this.phoneNumber = newNumber
    }


    companion object{
        private var idCounter = 0

        fun generateId(): Int{
            return ++idCounter
        }
    }


}