import kotlin.math.abs

fun main() {
    println("С помощью данной программ пользователь, введя целое число n и основание степени x может узнать,\n существует ли целочисленный показатель степени y для которого выполняется равенство x (в степени) y = n.\n")
    while (true) {
        println("Введите целое число n и основание степени x через пробел (или введите 'exit' для выхода):")

        val input = readLine()?.trim()
        if (input.equals("exit", ignoreCase = true)) {
            println("Программа завершена.")
            break
        }

        val sections = input?.split(" ")

        if (sections == null || sections.size != 2) {
            println("Ошибка: введите два числа через пробел. Пример: 11 8")
            println()
            continue
        }

        try {
            val n = sections[0].toInt()
            val x = sections[1].toInt()

            if (x == 0) {
                if (n == 0) {
                    println("Любое число в степени 0 даёт 1. Таким образом, 0^y = 0 при y >= 1.")
                } else {
                    println("Целочисленный показатель не существует для x = 0, если n != 0.")
                }
                continue
            }

            if (x == 1) {
                if (n == 1) {
                    println("Целочисленный показатель (y) может быть любым значением для x = 1 и n = 1.")
                } else {
                    println("Целочисленный показатель не существует для x = 1 и n != 1.")
                }
                println()
                continue
            }

            var y = 0
            var currentPower = 1
            val absN = abs(n)

            while (currentPower < absN) {
                currentPower *= x
                y++
            }

            if (currentPower == absN) {
                if (n < 0 && y % 2 == 0) {
                    println("Целочисленный показатель не существует для отрицательного n при четной степени.")
                } else {
                    println("Целочисленный показатель y: $y (для x = $x и n = $n)")
                }
            } else {
                println("Целочисленный показатель не существует.")
            }

        } catch (e: NumberFormatException) {
            println("Ошибка: введены некорректные числа. Попробуйте еще раз")
        }

        println()
    }
}