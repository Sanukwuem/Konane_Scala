import scala.util.control._

var number = 0 //number counting the number of columns and rows
var col = 0
var row = 0
var boardSize = 8
var count = 0
var numbOfColumns = 8
var state = 1


val boardArray = Array.ofDim[String](8, 8)


// Start of game
initialBoard
pickPieces
mainGame



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



def pickPieces = {
	
	println("\n\nPick First Piece. Choices include (1,8), (8,1), (4,5), (5,4)")
	println("\nEnter Row")
	val row = scala.io.StdIn.readInt()
	println("Enter Column")
	val col = scala.io.StdIn.readInt()
	
	empty(row,col)
	printBoard
	println()
	
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

	if(row == 5 && col == 4){
		println("\n\nPick Adjacent Piece. Choices include (4,4) (5,5) (6,4) and (5,3)")
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
<<<<<<< HEAD
	
	if (state == 1){
	println("\n\nPlayer's Turn")
	println("\nDark Player Turn: ")
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
	
	state = 2
	}
	
	if (state == 2){
		minimax
	}
	
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

def minimax = {
 
val loop = new Breaks

loop.breakable {
for (col <- 0 until boardSize){
	for (row <- 0 until boardSize){
		val row2 = row+2
		val col2 = col
		
		val row3 = row-2
		val col3 = col
		
		val row4 = row
		val col4 = col+2
		
		val row5 = row
		val col5 = col-2
		
		
		    if (boardArray(row)(col) == "O" && row <= 5 && boardArray(row+1)(col) == "X"){
			if(boardArray(row2)(col2) == "."){
			var newRow = row+1
			var newCol = colConversion(col)
			var newRow2 = row2+1
			var newCol2 = colConversion(col2)
			println("\n")
			println("\n" + "Computer jumped from " + newRow + "," + newCol + " to " + newRow2 + "," + newCol2)
			println("\n")
			makeJump(newRow, newCol, newRow2, newCol2)
			loop.break
			}
			} else if (boardArray(row)(col) == "O" && row >= 2 && boardArray(row-1)(col) == "X"){
			if(boardArray(row3)(col3) == "."){
			println(row)
			println(col)
			println(row3)
			println(col3)
			var newRow = row+1
			var newCol = colConversion(col)
			var newRow2 = row3+1
			var newCol2 = colConversion(col3)
			println("\n")
			println("\n" + "Computer jumped from " + newRow + "," + newCol + " to " + newRow2 + "," + newCol2)
			println("\n")
			makeJump(newRow, newCol, newRow2, newCol2)
			loop.break
			}
			} else if (boardArray(row)(col) == "O" && col <= 5 && boardArray(row)(col+1) == "X"){
			if(boardArray(row4)(col4) == "."){
			var newRow = row+1
			var newCol = colConversion(col)
			var newRow2 = row4+1
			var newCol2 = colConversion(col4)
			println("\n")
			println("\n" + "Computer jumped from " + newRow + "," + newCol + " to " + newRow2 + "," + newCol2)
			println("\n")
			makeJump(newRow, newCol, newRow2, newCol2)
			loop.break
			}
			} else if (boardArray(row)(col) == "O" && col >= 2 && boardArray(row)(col-1) == "X"){
			if(boardArray(row5)(col5) == "."){
			println(row)
			println(col)
			println(row5)
			println(col5)
			var newRow = row+1
			var newCol = colConversion(col)
			var newRow2 = row5+1
			var newCol2 = colConversion(col5)
			println("\n")
			println("\n" + "Computer jumped from " + newRow + "," + newCol + " to " + newRow2 + "," + newCol2)
			println("\n")
			makeJump(newRow, newCol, newRow2, newCol2)
			loop.break
			}
			}
			 
		}	
	}
}	


	state = 1
}

def makeJump(row:Int, col:Int, row2:Int, col2:Int): Boolean = {
	
	val newCol = colConversion(col)
	val newCol2 = colConversion(col2)

	if(canMakeJump(row, col, row2, col2))
	{
		jump(row,col,row2,col2)
		empty(row,col)

		printBoard
		return true
	}
	else
	{
		println("Couldnt make jump")
		printBoard
		return false
	}
	
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

def canMakeJump(row:Int, col:Int, row2:Int, col2:Int): Boolean = {

	val newCol = colConversion(col)+1
	val newCol2 = colConversion(col2)+1

	if(!isValidSpace(row, col) || !isValidSpace(row2, col2))
		return false;
	if(spaceIsEmpty(row, col) || !spaceIsEmpty(row2, col2))
		return false;

	val rowTemp = row2 - row
	val colTemp = newCol2 - newCol
	
	if(rowTemp == 2 && colTemp == 0)
	{
		if(spaceIsEmpty(row+1, col) || !spaceIsEmpty(row+2, col))
			return false
		else 
			return true
	}	
	if(rowTemp == -2 && colTemp == 0)
	{
		if(spaceIsEmpty(row-1, col) || !spaceIsEmpty(row-2, col))
			return false
		else 
			return true
	}	
	if(rowTemp == 0 && colTemp == 2)
	{
		if(spaceIsEmpty(row, col - 1) || !spaceIsEmpty(row, col - 2))
			return false
		else 
			return true
	}	
	if(rowTemp == 0 && colTemp == -2)
	{
		if(spaceIsEmpty(row, col + 1) || !spaceIsEmpty(row, col + 2))
			return false
		else 
			return true
	}	

	return false	
}

def empty(row:Int, col:Int) = {
	
	val newCol = colConversion(col)

	boardArray(row-1)(newCol) = "."

}

def isValidSpace(row:Int, col:Int): Boolean = {

	return (row <= 8 && row >= 1 && col <= 8 && col >= 1)
}

def spaceIsEmpty(row:Int, col:Int): Boolean = {

	val newCol = colConversion(col)	

	return (boardArray(row-1)(newCol) == ".")
}

def jump(row:Int, col:Int, row2:Int, col2:Int) = {

	val newCol = colConversion(col)
	val newCol2 = colConversion(col2)

	boardArray(row2-1)(newCol2) = boardArray(row-1)(newCol)

	val rowTemp = row2 - row
	val colTemp = newCol2 - newCol
	
	if(rowTemp == 2 && colTemp == 0)
	{
		empty(row+1, col)
	}	
	if(rowTemp == -2 && colTemp == 0)
	{
		empty(row-1, col)
	}	
	if(rowTemp == 0 && colTemp == 2)
	{
		empty(row, col-1)
	}	
	if(rowTemp == 0 && colTemp == -2)
	{
		empty(row, col+1)
	}
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
	case 0 => 8
}
