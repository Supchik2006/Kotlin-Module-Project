class NoteListMenu(val archive: Archive) {

    fun start() {
        val menu = Menu("Заметки архива \"${archive.name}\":") {
            val items = mutableListOf<MenuItem>()

            items.add(MenuItem("Создать заметку") {
                createNote()
            })

            archive.notes.forEach { note ->
                items.add(MenuItem(note.name) {
                    openNote(note)
                })
            }

            items.add(MenuItem("Назад") {
                NavigationResult.EXIT
            })

            items
        }
        menu.getMenu()
    }

    private fun createNote(): NavigationResult {
        val name = Reader.read("Введите название заметки: ")
        val text = Reader.read("Введите текст заметки: ")
        archive.notes.add(Note(name, text))
        println("Заметка \"$name\" создана.")
        return NavigationResult.CONTINUE
    }

    private fun openNote(note: Note): NavigationResult {
        NoteView(note).start()
        return NavigationResult.CONTINUE
    }
}