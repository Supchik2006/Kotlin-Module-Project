class NoteView (val note: Note) {
    fun start() {
        val menu = Menu("Заметка: \"${note.name}\"\n${note.text}") {
            val items = mutableListOf<MenuItem>()
            items.add(MenuItem("Назад") { NavigationResult.EXIT })
            items
        }
        menu.getMenu()
    }
}