package Kotlin03_ChatBot.app.managers

import Kotlin03_ChatBot.app.models.Contact

class ContactManager {

    val contacts: MutableList<Contact> = mutableListOf()

    fun addContact(name: String, phoneNumber: String){
        val newContact = Contact(name, phoneNumber)
        contacts.add(newContact)
    }

    fun updateContactNumber(id: Int, phoneNumber: String){
        val newContact = contacts.find {it.id == id}
        newContact?.updateNumber(phoneNumber)
    }
    fun deleteContact(id: Int){
        contacts.removeIf {it.id == id}
    }

    fun listContacts(): List<Contact>{
        return contacts
    }

}