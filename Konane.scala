//////////////////////////////////////////
var number = 0 //number counting the number of columns and rows
var col = 0
var row = 0
var boardSize = 8
var count = 0
var numbOfColumns = 8


val boardArray = Array.ofDim[String](9,9)
///////////////////////////////////////////

// Start of game
initialBoard
pickPieces




//////////////////////////////////////////////////////////////////////////////////////////

//board
def initialBoard = {
var numbOfRows = 8
print("\n   ")
for (n <- 1 to numbOfColumns ){
print(n + "   ")
}
for (col <- 0 until boardSize) {
		println()
		print (numbOfRows + " |")
		numbOfRows = numbOfRows - 1
	for (row <- 0 until boardSize){
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