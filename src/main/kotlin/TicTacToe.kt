class TicTacToe {

    //Creating a 2D array for the 9-Spots
    private var array2D = arrayOf(
        arrayOf('_', '_', '_'),
        arrayOf('_', '_', '_'),
        arrayOf('_', '_', '_')
    )

    //a variable to check whose turn it is
    private var checkTurn = 0

    //a variable flag to end the game when someone wins
    private var gameEnded = false

    //a map for the i and j position for the 2D array with respect to the values 1 - 9
    private fun inputMap(n: Int): Array<Int> {
        return when (n) {
            1 -> arrayOf(0, 0)
            2 -> arrayOf(0, 1)
            3 -> arrayOf(0, 2)
            4 -> arrayOf(1, 0)
            5 -> arrayOf(1, 1)
            6 -> arrayOf(1, 2)
            7 -> arrayOf(2, 0)
            8 -> arrayOf(2, 1)
            9 -> arrayOf(2, 2)
            else -> arrayOf(9, 9)//an invalid value for wrong inputs
        }
    }

    //main game function
    fun game() {
        printArray(array2D)

        while (checkTurn < 9 && !gameEnded) {
            if (checkTurn % 2 == 0) {
                println("Player 1's turn!")
                play(1)
            } else {
                println("Player 2's turn!")
                play(2)
            }

            //Draw case
            if (!gameEnded && checkTurn == 9){
                println("Draw!")
            }
        }
    }

    //game input function
    private fun play(player: Int) {
        println("Call your turn (1 - 9)...")
        val playerInput = readLine()!!.toInt()
        val position = inputMap(playerInput)

        if (!position.contains(9)) {//to check invalid input
            if (player == 1) {
                if (array2D[position[0]][position[1]] == '_') {
                    array2D[position[0]][position[1]] = 'X'
                    checkTurn++
                }else{
                    println("Invalid Move!")
                }
            } else {
                if (array2D[position[0]][position[1]] == '_') {
                    array2D[position[0]][position[1]] = 'O'
                    checkTurn++
                }else{
                    println("Invalid Move!")
                }
            }
            printArray(array2D)
            gameRules()
        } else {
            println("Invalid Input!")
        }
    }

    //a function to keep the game rules and check the winner
    private fun gameRules() {
        when {
            //Checking horizontal rules
            ((array2D[0][0] == array2D[0][1]) && (array2D[0][1] == array2D[0][2]) && (array2D[0][0] != '_')) -> checkWinner(
                array2D[0][0]
            )

            ((array2D[1][0] == array2D[1][1]) && (array2D[1][1] == array2D[1][2]) && (array2D[1][0] != '_')) -> checkWinner(
                array2D[1][0]
            )

            ((array2D[2][0] == array2D[2][1]) && (array2D[2][1] == array2D[2][2]) && (array2D[2][0] != '_')) -> checkWinner(
                array2D[2][0]
            )

            //Checking vertical rules
            ((array2D[0][0] == array2D[1][0]) && (array2D[1][0] == array2D[2][0]) && (array2D[0][0] != '_')) -> checkWinner(
                array2D[0][0]
            )

            ((array2D[0][1] == array2D[1][1]) && (array2D[1][1] == array2D[2][1]) && (array2D[0][1] != '_')) -> checkWinner(
                array2D[0][1]
            )

            ((array2D[0][2] == array2D[1][2]) && (array2D[1][2] == array2D[2][2]) && (array2D[0][2] != '_')) -> checkWinner(
                array2D[0][2]
            )

            //Checking diagonal rules
            ((array2D[0][0] == array2D[1][1]) && (array2D[1][1] == array2D[2][2]) && (array2D[0][0] != '_')) -> checkWinner(
                array2D[0][0]
            )

            ((array2D[0][2] == array2D[1][1]) && (array2D[1][1] == array2D[2][0]) && (array2D[0][2] != '_')) -> checkWinner(
                array2D[0][2]
            )
        }
    }

    //a function to check who has won the game
    private fun checkWinner(c: Char) {
        if (c == 'X') {
            println("Player 1 wins the game!")
            gameEnded = true
        } else if (c == 'O') {
            println("Player 2 wins the game!")
            gameEnded = true
        }
    }


    //a function to print the array
    private fun printArray(array2D: Array<Array<Char>>) {

        for (i in array2D.indices) {
            for (j in array2D.indices) {
                print("${array2D[i][j]} ")
            }
            println()
        }
    }
}

fun main() {

    val game = TicTacToe()
    game.game()
}
