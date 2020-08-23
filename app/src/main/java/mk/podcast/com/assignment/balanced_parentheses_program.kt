package mk.podcast.com.assignment

import java.util.*

class  balanced_parentheses_program {
    companion object {
        fun balancedParenthesesAlgorithm() {
            do {
                val scanner = Scanner(System.`in`)
                print("Please enter BalancedParentheses number =>")
                val value = scanner.next()
            } while (!value.checkBalance(value))
            println("Done")
        }

        fun String.checkBalance(expression: String): Boolean {
            val parentheses = arrayOf("\\(|\\)", "\\[|\\]", "\\{|\\}")
            val length = expression.length
            for (i in parentheses.indices) {
                val newLength = expression.replace(parentheses[i].toRegex(), "").length
                val diff = length - newLength
                if (diff % 2 != 0) {
                    println("$expression => It’s not balanced.")
                    return false
                }
            }
            val regex = Regex(parentheses[0])
            var matches = regex.findAll(expression).count()
            matches=matches / 2
            val regex2 = Regex(parentheses[1])
            var matches2 = regex2.findAll(expression).count()
            matches2=matches2 / 2
            val regex3 = Regex(parentheses[2])
            var matches3 = regex3.findAll(expression).count()
            matches3=matches3 / 2
            println("$expression => It’s not balanced. pair of { = $matches3 , pair of [ = $matches2 , pair of ( = $matches")
            return true
        }

    }


}