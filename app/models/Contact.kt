package Kotlin03_ChatBot.app.models

import java.time.LocalDateTime

class Contact(
    var name: String,
    var phoneNumber: String,
    val createdAt: String = LocalDateTime.now().toString()
) {

    val id: Int

    init{
        id = generateId()
    }

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