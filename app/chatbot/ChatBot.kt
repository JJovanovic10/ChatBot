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

        println("Choose what you want to manipulate: tasks, contacts, notes")
        when(input){
            "tasks" -> {
                println("Choose option: add task, update task, delete task, list tasks")
                val inputStr = readLine()!!.toString()
                when(inputStr){
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
                        try{
                            println("Enter id of task u want to delete: ")
                            val id = readln().toInt()
                            taskManager.deleteTask(id)
                            println("Task deleted successfully")
                        } catch (e: Exception){
                            println("Can't delete task")
                        }
                    }
                    "list tasks" -> {
                        try{
                            taskManager.listTask().forEach { task ->
                                println("ID: ${task.id}, Title: ${task.title}, Description: ${task.description}")
                            }
                        } catch (e: Exception){
                            println("Can't list tasks")
                        }
                    }
                    else -> println("Invalid input")
                }
            }
            "contacts" -> {
                println("Choose option: add contact, update contact, delete contact, list contacts")
                val inputStr = readLine()!!.toString()
                when(inputStr){
                    "add contact" -> {
                        try{
                            println("Enter name and phone number of new contact")
                            val name = readLine()!!.toString()
                            val phoneNumber = readLine()!!.toString()
                            contactManager.addContact(name, phoneNumber)
                            println("Contact added successfully")
                        } catch (e: Exception){
                            println("Can't add new contact")
                        }
                    }
                    "update contact" -> {
                        try{
                            println("Enter id of contact u want to update")
                            val id = readln().toInt()
                            println("Enter new phone number")
                            val newNumber = readln().toString()
                            contactManager.updateContactNumber(id, newNumber)
                            println("Contact updated successfully")
                        } catch (e: Exception){
                            println("Can't update contact")
                        }
                    }
                    "delete contact" -> {
                        try{
                            println("Enter id of contact u want to delete")
                            val id = readln().toInt()
                            contactManager.deleteContact(id)
                            println("Contact deleted successfully")
                        } catch (e: Exception){
                            println("Can't delete contact")
                        }
                    }
                    "list contacts" -> {
                        try{
                            contactManager.listContacts().forEach { contact ->
                                println("ID: ${contact.id}, Name: ${contact.name}, Number: ${contact.phoneNumber}")
                            }
                        } catch (e: Exception){
                            println("Can't list contacts")
                        }
                    }
                    else -> println("Invalid input")
                }
            }
            "notes" -> {

            }
            else -> println("Invalid input")
        }


    }



}