package mk.podcast.com.assignment

import java.util.*

class palindrome_program
{
    companion object
    {

        fun palindromeAlgorithm()
        {
             do{
                 val scanner = Scanner(System.`in`)
                 print("Please enter palindrome number =>")
                 val value = scanner.next()
               }while(!value.isPalindome(value))
            println("Done")
        }

        fun String.isPalindome(inputData: String) : Boolean {
            var reverseData: String = ""
            val length: Int = inputData?.let { it.length }
            for (i in length - 1 downTo 0 step 1) reverseData += inputData[i]
            if (!inputData.equals(reverseData)) {
                println("“You fail!, Please try with other text...”")
                return false
            } else {
                println("The text you entered is Palindrome and you pass the test.")
                return true
            }
        }

    }
}