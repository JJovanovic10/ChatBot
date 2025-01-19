package Kotlin03_ChatBot.app.chatbot

import Kotlin03_ChatBot.app.managers.ContactManager
import Kotlin03_ChatBot.app.managers.NoteManager
import Kotlin03_ChatBot.app.managers.TaskManager
import java.lang.Exception

class ChatBot(
    val taskManager: TaskManager = TaskManager(),
    val contactManager: ContactManager = ContactManager(),
    val noteManager: NoteManager = NoteManager()
){

    fun respondToUser(input: String){

        when(input){
            "add task" -> {
                try {
                    println("Enter a new title and description")
                    val newTitle = readLine()!!.toString()
                    val newDescription = readLine()!!.toString()
                    taskManager.addTask(newTitle, newDescription)
                    println("Task added successfully")
                } catch (e: Exception){
                    println("Can't add new task")
                }
            }
            "update task" -> {
                try{
                    println("Enter id of task u want to update: ")
                    val id = readln().toInt()
                    println("Enter a new title and description: ")
                    val newTitle = readLine()!!.toString()
                    val newDescription = readLine()!!.toString()
                    taskManager.updateTask(id, newTitle, newDescription)
                    println("Task updated successfully")
                } catch (e: Exception){
                  println("Can't update task")
                }
            }
            "delete task" -> {

            }

        }


    }



}