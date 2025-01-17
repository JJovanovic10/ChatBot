package Kotlin03_ChatBot.app.models

import java.time.LocalDateTime

class Task(
    val id: Int = Task.generateId(),
    var title: String,
    var description: String,
    var isCompleted: Boolean,
    var updatedAt: String?
){


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