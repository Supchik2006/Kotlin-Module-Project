import java.util.Scanner

object Reader {
    val scanner = Scanner(System.`in`)

    fun read(s: String): String {
        while (true) {
            println(s)
            val input = scanner.nextLine().trim()
            if (!input.isEmpty()) {
                return input
            }
            println("Ошибка: значение не может быть пустым. Попробуйте снова.")
        }
    }
}