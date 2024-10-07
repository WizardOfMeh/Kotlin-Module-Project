class ArchiveMenu(private val archive: Archive) {
    fun show() {
        while (true) {
            println("Меню архива '${archive.name}':")
            println("1. Создать заметку")
            println("2. Выбрать заметку")
            println("3. Назад")

            when (readLine()?.toIntOrNull() ?: continue) {
                1 -> createNote()
                2 -> selectNote()
                3 -> return
                else -> println("Неверный выбор, попробуйте снова.")
            }
        }
    }

    private fun createNote() {
        println("Введите название заметки:")
        val title = readLine() ?: ""
        if (title.isBlank()) {
            println("Имя заметки не может быть пустым.")
            return
        }
        println("Введите содержание заметки:")
        val content = readLine() ?: ""
        if (content.isBlank()) {
            println("Содержание заметки не может быть пустым.")
            return
        }
        val note = Archive.Note(archive.notes.size + 1, title, content)
        archive.notes.add(note)
        println("Заметка '$title' создана.")
    }

    private fun selectNote() {
        if (archive.notes.isEmpty()) {
            println("Заметки отсутствуют.")
            return
        }

        println("Выберите заметку:")
        archive.notes.forEachIndexed { index, note ->
            println("${index + 1}. ${note.title}")
        }

        val choice = readLine()?.toIntOrNull() ?: return
        if (choice in 1..archive.notes.size) {
            val noteMenu = NoteMenu(archive.notes[choice - 1])
            noteMenu.show()
        } else {
            println("Неверный выбор, попробуйте снова.")
        }
    }
}