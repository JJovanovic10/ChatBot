package Kotlin03_ChatBot

import Kotlin03_ChatBot.app.chatbot.ChatBot
import Kotlin03_ChatBot.app.managers.ContactManager
import Kotlin03_ChatBot.app.managers.NoteManager
import Kotlin03_ChatBot.app.managers.TaskManager

fun main(){

 val taskManager = TaskManager()
 val contactManager = ContactManager()
 val noteManager = NoteManager()

 val chatBot = ChatBot(taskManager, contactManager, noteManager)

 while(true){
      println("Choose what you want to manipulate: tasks, contacts, notes")
      val input = readln().trim() ?: continue
      if(input.lowercase() == "exit"){
           println("Exit")
           break
      }
      chatBot.respondToUser(input)
 }


}