package Kotlin03_ChatBot.app.models

import java.time.LocalDateTime

class Task(
    var title: String,
    var description: String,
    var isCompleted: Boolean = false,
    var updatedAt: String? = LocalDateTime.now().toString()
){

    val id: Int

    init{
        id = generateId()
    }

    fun toggleStatus(): Boolean {
        isCompleted = !isCompleted
        return isCompleted
    }

    fun updateTask(newTitle: String, newDescription: String){
        this.title = newTitle
        this.description = newDescription
        this.updatedAt = LocalDateTime.now().toString()
    }

    companion object{
        private var idCounter = 0

        fun generateId(): Int {
            return ++idCounter
        }
    }

}