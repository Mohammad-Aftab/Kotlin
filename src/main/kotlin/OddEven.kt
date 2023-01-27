fun main(){

    print("Enter a number: ")
    val input = readln().toInt()

    if (input % 2 == 0){
        println("$input is Even.")
    }else{
        println("$input is Odd.")
    }
}