data class Archive (val name: String, val notes: MutableList<Note> = mutableListOf())

data class Note(val name: String, val text: String)

data class MenuItem(val title: String, val action: () -> NavigationResult )

enum class NavigationResult {
    CONTINUE,
    EXIT
}