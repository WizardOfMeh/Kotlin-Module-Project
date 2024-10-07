data class Archive(
    val id: Int,
    val name: String,
    val notes: MutableList<Note>
) {
    data class Note(
        val id: Int,
        val title: String,
        val content: String
    )
}