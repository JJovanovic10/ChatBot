package Kotlin03_ChatBot.app.models

import java.time.LocalDateTime

class Note (
    var title: String,
    var content: String,
    val createdAt: String = LocalDateTime.now().toString(),
    var updatedAt: String = createdAt
){

    val id: Int

    init{
        id = generateId()
    }

    fun updateNoteContent(content: String){
        this.content = content
        this.updatedAt = LocalDateTime.now().toString()
    }

    companion object {
        private var indexCounter = 0

        fun generateId(): Int {
            return ++indexCounter
        }
    }

}