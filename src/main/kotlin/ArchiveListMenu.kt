
class ArchiveListMenu {
    private val archives = mutableListOf<Archive>()

    fun start() {
        val menu = Menu("Список архивов:") {
            val items = mutableListOf<MenuItem>()

            items.add(MenuItem("Создать архив") {
                createArchive()
            })

            archives.forEach { archive ->
                items.add(MenuItem(archive.name) {
                    openArchive(archive)
                })
            }

            items.add(MenuItem("Выход") {
                NavigationResult.EXIT
            })

            items
        }
        menu.getMenu()
    }

    private fun createArchive(): NavigationResult {
        val name = Reader.read("Введите название архива: ")
        archives.add(Archive(name))
        println("Архив \"$name\" создан.")
        return NavigationResult.CONTINUE
    }

    private fun openArchive(archive: Archive): NavigationResult {
        NoteListMenu(archive).start()
        return NavigationResult.CONTINUE
    }
}