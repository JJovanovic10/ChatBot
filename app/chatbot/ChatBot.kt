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
            "tasks" -> {
                println("Choose option: add task, update task, delete task, list tasks")
                val inputStr = readln()
                when(inputStr){
                    "add task" -> {
                        safeInput("Enter a new title and decsription"){ userInput ->
                            val (title, description) = userInput.split(" ")
                            taskManager.addTask(title, description)
                        }


                    }
                    "update task" -> {
                        println("Enter id of tas u want to update")
                        val id = readln().toInt()
                        safeInput("Enter a new title and description: ") {userInput ->
                            val(title, description) = input.split(" ")
                            taskManager.updateTask(id, title, description)
                        }
                    }
                    "delete task" -> {
                        safeInput("Enter id of task u want to delete:"){userInput ->
                            val id = readln().toInt()
                            taskManager.deleteTask(id)
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
                val inputStr = readln()
                when(inputStr){
                    "add contact" -> {
                        safeInput("Enter name and phone number of new contact: "){userInput ->
                            val (name, phoneNumber) = userInput.split(" ")
                            contactManager.addContact(name, phoneNumber)
                        }
                    }
                    "update contact" -> {
                        println("Enter id of contact u want to update")
                        val id = readln().toInt()
                        safeInput("Enter new phone number") {userInput ->
                            val phoneNumber = readln()
                            contactManager.updateContactNumber(id, phoneNumber)
                        }
                    }
                    "delete contact" -> {
                        safeInput("Enter id of contact u want to delete") {userInput ->
                            val id = readln().toInt()
                            contactManager.deleteContact(id)
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
                println("Choose option: add note, update note, delete note, list notes")
                val inputStr = readln()
                when(inputStr){
                    "add note" -> {
                        safeInput("Add title and content of new note"){userInput ->
                            val (title, content) = userInput.split(" ")
                            noteManager.addNote(title, content)
                        }
                    }
                    "update note" -> {
                        println("Choose id of note u want to update: ")
                        val id = readln().toInt()
                        safeInput("Enter new note content"){userInput ->
                            val content = readln()
                            noteManager.updateNote(id, content)
                        }
                    }
                    "delete note" -> {
                        safeInput("Enter id of note u want to delete: "){userInput ->
                            val id = readln().toInt()
                            noteManager.deleteNote(id)
                        }
                    }
                    "list notes" -> {
                        try{
                            noteManager.listNotes().forEach { note ->
                                println("ID: ${note.id}, Title: ${note.title}, Content: ${note.content}")
                            }
                        } catch (e: Exception){
                            println("Can't list notes")
                        }
                    }
                }
            }
            else -> println("Invalid input")
        }

    }

    fun safeInput(prompt: String, action: (String) -> Unit){
        try{
            println(prompt)
            val input = readln()
            action(input)
        } catch (e: Exception){
            println("Error: ${e.message}")
        }
    }

}