

class Menu(val title: String, val itemsProvider: () -> List<MenuItem>) {
    fun getMenu() {
        while (true) {
            val items = itemsProvider()

            println(title)
            items.forEachIndexed { index, item -> println("$index. ${item.title}") }
            print("Введите номер пункта: ")

            val choice = Reader.scanner.nextLine().toIntOrNull()

            when (choice) {
                null -> {
                    println("Ошибка: нужно ввести число. Попробуйте снова.")
                }
                !in items.indices -> {
                    println("Ошибка: такого пункта нет. Введите корректный номер.")
                }
                else -> {
                    val result = items[choice].action()
                    if (result == NavigationResult.EXIT) {
                        return
                    }
                }
            }
        }
    }
}