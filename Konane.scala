//////////////////////////////////////////
var number = 0 //number counting the number of columns and rows
var col = 0
var row = 0
var boardSize = 8
var count = 0
var numbOfColumns = 8
var numbOfRows = 8

val boardArray = Array.ofDim[String](9,9)
///////////////////////////////////////////

// Start of game
initialBoard




//////////////////////////////////////////////////////////////////////////////////////////

//board
def initialBoard = {
print("   ")
for (n <- 1 to numbOfColumns ){
print(n + "   ")
}
for (col <- 0 until boardSize) {
		println()
		print (numbOfRows + " |")
		numbOfRows = numbOfRows - 1
	for (row <- 0 until boardSize){
		count = count + 1
		
		//boardArray(col)(row) = "W"
		
		if (count > 0 && count <= 8
		|| count > 16 && count <= 24
		|| count > 32 && count <= 40
		|| count > 48 && count <= 56) { 
		if (count%2 == 0){
		boardArray(col)(row) = "O"
		print(boardArray(col)(row) + " |" + " ")
		}
		else {
		boardArray(col)(row) = "X"
		print(boardArray(col)(row) + " |" + " ")
		}
		}
		
		if (count > 8 && count <= 16
		|| count > 24 && count <= 32
		|| count > 40 && count <= 48
		|| count > 56 && count <= 64) {
		if (count%2 == 0){
		boardArray(col)(row) = "X"
		print(boardArray(col)(row) + " |" + " ")
		}
		else {
		boardArray(col)(row) = "O"
		print(boardArray(col)(row) + " |" + " ")
		}
		}	
	}
}
}

///////////////////////////////////////////////////////////////////////////////////////////

def newBoard = {


}