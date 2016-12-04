//////////////////////////////////////////
var number = 0 //number counting the number of columns and rows
var col = 0
var row = 0
var boardSize = 8
var count = 0
var numbOfColumns = 8


val boardArray = Array.ofDim[String](8, 8)
///////////////////////////////////////////

// Start of game
initialBoard
pickPieces
mainGame

//////////////////////////////////////////////////////////////////////////////////////////

//board
def initialBoard = {
	var numbOfRows = 8
	print("\n   ")
	for (n <- 1 to numbOfColumns ){
		print(n + "   ")
	}
	for (row <- 0 until boardSize){
		println()
		print (numbOfRows + " |")
		numbOfRows = numbOfRows - 1
		for (col <- 0 until boardSize) {
			count = count + 1
			
			
			if (count > 0 && count <= 8
			|| count > 16 && count <= 24
			|| count > 32 && count <= 40
			|| count > 48 && count <= 56) { 
				if (count%2 == 0){
					boardArray(row)(col) = "O"
					print(boardArray(row)(col) + " |" + " ")
				}
				else {
					boardArray(row)(col) = "X"
					print(boardArray(row)(col) + " |" + " ")
				}
			}
			
			if (count > 8 && count <= 16
			|| count > 24 && count <= 32
			|| count > 40 && count <= 48
			|| count > 56 && count <= 64) {
				if (count%2 == 0){
					boardArray(row)(col) = "X"
					print(boardArray(row)(col) + " |" + " ")
				}
				else {
					boardArray(row)(col) = "O"
					print(boardArray(row)(col) + " |" + " ")
				}
			}	
		}
	}
}

///////////////////////////////////////////////////////////////////////////////////////////

def pickPieces = {
	
	println("\n\nPick First Piece. Choices include (1,8), (8,1), (4,5), (5,4)")
	println("\nEnter Row")
	val row = scala.io.StdIn.readInt()
	println("Enter Column")
	val col = scala.io.StdIn.readInt()
	
	empty(row,col)
	printBoard
	
	if(row == 1 && col == 8){
		println("\n\nPick Adjacent Piece. Choices include (1,7) and (2,8)")
		println("\nEnter Row")
		val row = scala.io.StdIn.readInt()
		println("Enter Column")
		val col = scala.io.StdIn.readInt()
		empty(row,col)	
	}
	
	if(row == 4 && col == 5){
		println("\n\nPick Adjacent Piece. Choices include (3,5) (4,6) (5,5) and (4,4)")
		println("\nEnter Row")
		val row = scala.io.StdIn.readInt()
		println("Enter Column")
		val col = scala.io.StdIn.readInt()
		empty(row,col)
	}
	
	if(row == 8 && col == 1){
		println("\n\nPick Adjacent Piece. Choices include (7,1) and (8,2)")
		println("\nEnter Row")
		val row = scala.io.StdIn.readInt()
		println("Enter Column")
		val col = scala.io.StdIn.readInt()
		empty(row,col)
	}
	printBoard	
}

def mainGame: String = {
	var countX = 0
	var countO = 0
	var r = 0
	var c = 0

	println("\n\nDark Player Turn: ")
	println("Specify where you are jumping from and to")
	println("\nFrom")
	println("Enter Row")
	val row = scala.io.StdIn.readInt()
	println("Enter Column")
	val col = scala.io.StdIn.readInt
	
	println("\nTo")
	println("Enter Row 2")
	val row2 = scala.io.StdIn.readInt()
	println("Enter Column 2")
	val col2 = scala.io.StdIn.readInt()
	makeJump(row, col, row2, col2)
		
	println("\n\nLight Player Turn: ")
	println("Specify where you are jumping from and to")
	println("\nFrom")
	println("Enter Row")
	val row3 = scala.io.StdIn.readInt()
	println("Enter Column")
	val col3 = scala.io.StdIn.readInt
	
	println("\nTo")
	println("Enter Row 2")
	val row4 = scala.io.StdIn.readInt()
	println("Enter Column 2")
	val col4 = scala.io.StdIn.readInt()

	makeJump(row3, col3, row4, col4)
	
	for (r <- 0 until boardSize){
		for (c <- 0 until 8){
			if(boardArray(r)(c) == "X"){
				countX = countX + 1
			}
			if(boardArray(r)(c) == "O"){
				countO = countO + 1
				
			}
			
		}
	}
	println("\n\nDark Pieces Left " + countX)
	println("Light Pieces Left " + countO)
	
	if(countX == 0){
		println("\n\nGame over, Light Player Wins")
		System.exit(0)
	}
	if(countO == 0){
		println("\n\nGame over, Light Player Wins")
		System.exit(0)
	}
	
	mainGame
	
}

def makeJump(row:Int, col:Int, row2:Int, col2:Int) = {
	jump(row,col,row2,col2)
	empty(row,col)
	
	if(row - row2 == 2){
		empty(row - 1, col)
	}
	if(row - row2 == -2){
		empty(row + 1, col)
	}
	if(col - col2 == 2){
		empty(row, col - 1)
	}
	if(col - col2 == -2){
		empty(row, col + 1)
	}
	
	if(row - row2 == 4){
		empty(row - 1, col)
		empty(row - 3, col)
	}
	if(row - row2 == -4){
		empty(row + 1, col)
		empty(row + 3, col)
	}
	if(col - col2 == 4){
		empty(row, col - 1)
		empty(row, col - 3)
		
	}
	if(col - col2 == -4){
		empty(row, col + 1)
		empty(row, col + 3)
	}
	
	printBoard
	
}

def printBoard = {
	var numbOfRows = 8
	
	// 1 to 8
	print("   ")
	for (n <- 1 to numbOfColumns ){
		print(n + "   ")
	}
	for (col <- 0 until boardSize) {
		// 8 to 1
		println()
		print (numbOfRows + " |")
		numbOfRows = numbOfRows - 1
	for (row <- 0 until boardSize){
		print(boardArray(row)(col) + " |" + " ")
	}
}
}

def empty(row:Int, col:Int) = {
	if(col == 8){
		boardArray(row-1)(col-8) = "."	
	}
	if(col == 7){
		boardArray(row-1)(col-6) = "."
	}
	if(col == 6){
		boardArray(row-1)(col-4) = "."
	}
	if(col == 5){
		boardArray(row-1)(col-2) = "."
	}
	if(col == 4){
		boardArray(row-1)(col) = "."
	}
	if(col == 3){
		boardArray(row-1)(col+2) = "."
	}
	if(col == 2){
		boardArray(row-1)(col+4) = "."
	}
	if(col == 1){
		boardArray(row-1)(col+6) = "."
	}
}

def jump(row:Int, col:Int, row2:Int, col2:Int) = {

	val newCol = colConversion(col)
	val newCol2 = colConversion(col2)

	boardArray(row2-1)(newCol2) = boardArray(row-1)(newCol)
}

def colConversion(col: Int): Int = col match {
	case 8 => 0
	case 7 => 1
	case 6 => 2
	case 5 => 3
	case 4 => 4
 	case 3 => 5
 	case 2 => 6
 	case 1 => 7
}
