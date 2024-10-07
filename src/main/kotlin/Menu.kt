class Menu {
    private val archives = mutableListOf<Archive>()

    fun show() {
        while (true) {
            println("Главное меню:")
            println("1. Создать архив")
            println("2. Выбрать архив")
            println("3. Выход")

            when (readLine()?.toIntOrNull() ?: continue) {
                1 -> createArchive()
                2 -> selectArchive()
                3 -> return
                else -> println("Неверный выбор, попробуйте снова.")
            }
        }
    }

    private fun createArchive() {
        println("Введите название архива:")
        val name = readLine() ?: ""
        if (name.isBlank()) {
            println("Имя архива не может быть пустым.")
            return
        }
        val archive = Archive(archives.size + 1, name, mutableListOf())
        archives.add(archive)
        println("Архив '$name' создан.")
    }

    private fun selectArchive() {
        if (archives.isEmpty()) {
            println("Архивы отсутствуют.")
            return
        }

        println("Выберите архив:")
        archives.forEachIndexed { index, archive ->
            println("${index + 1}. ${archive.name}")
        }

        val choice = readLine()?.toIntOrNull() ?: return
        if (choice in 1..archives.size) {
            val archiveMenu = ArchiveMenu(archives[choice - 1])
            archiveMenu.show()
        } else {
            println("Неверный выбор, попробуйте снова.")
        }
    }
}