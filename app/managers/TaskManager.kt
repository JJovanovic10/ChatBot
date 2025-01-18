package Kotlin03_ChatBot.app.managers

import Kotlin03_ChatBot.app.models.Task
import java.time.LocalDate
import java.time.LocalDateTime

class TaskManager {

    val tasks: MutableList<Task> = mutableListOf()

    fun addTask(title: String, description: String){
        val newTask = Task(title, description)
        tasks.add(newTask)
    }

    fun deleteTask(id: Int){
        tasks.removeIf{it.id == id}
    }

    fun toggleTaskStatus(id: Int){
        val task = tasks.find {it.id == id}
        task?.toggleStatus()
    }

    fun updateTask(id: Int, title: String, description: String){
        val updatedTask = tasks.find {it.id == id}
        updatedTask?.updateTask(title, description)
    }

    fun listTask(): List<Task>{
        return tasks
    }

}