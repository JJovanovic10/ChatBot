package Kotlin03_ChatBot.app.managers

import Kotlin03_ChatBot.app.models.Note

class NoteManager {

    val notes: MutableList<Note> = mutableListOf()

    fun addNote(title: String, description: String){
        val newNote = Note(title, description)
        notes.add(newNote)
    }
    fun updateNote(id: Int, content: String){
        val updatedNote = notes.find {it.id == id}
        updatedNote?.updateNoteContent(content)
    }

    fun deleteNote(id: Int){
        notes.removeIf {it.id == id}
    }

    fun listNotes(): List<Note> {
        return notes
    }

}