class NoteMenu(private val note: Archive.Note) {
    fun show() {
        println("Заметка '${note.title}':")
        println("Содержание: ${note.content}")
        println("Нажмите Enter для возврата.")
        readLine()
    }
}