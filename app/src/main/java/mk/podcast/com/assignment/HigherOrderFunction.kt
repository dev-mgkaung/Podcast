package mk.podcast.com.assignment

// What is higher oder function ?
/**
 * function that takes functions as parameters or returns a function as a value
 * store a  variable
 *  pass a parameter
 *  return a value from other higher oreder function
 */

var numList = listOf(1,2,3,4,5)

fun numberListCalculator(numList: List<Int>, operator: Char , calculate :  (Int,Int,Char)->Int ) : Int
{
    var initailValue : Int = 0

    for ( num in numList)
    {
        calculate ( initailValue , num ,operator)
    }
    return initailValue
}

val calculateFunc  : ( num1 : Int , num2 : Int , operator : Char ) -> Int ={
    num1, num2, operator ->
    when(operator)
    {
        '+' -> num1+num2
        '-' -> num1-num2
        else -> 0
    }
}

fun main()
{

    /*
     First Way
     */
val result = numberListCalculator(
    numList = numList ,
    operator = '+' ,
    calculate = {
        num1 , num2 , operator ->
        when(operator)
        {
            '+' ->  num1 + num2
            '-' ->  num1 - num2
            '*' ->  num1 * num2
            '/' ->  num1 / num2
            else ->  0
        }
    }
)
    println("$result")

    /*
    Second  Way
    */
    val secResult = numberListCalculator(numList = numList, '-', calculate = calculateFunc)
    println("$secResult")
}