Sean Anukwuem
Andrew Logan
Project 4
Programming Languages
Novemeber 30, 2016


------------------------------------------------------------------------------------
Compilation:

scala Konane.scala
------------------------------------------------------------------------------------
Instructions:

The First step is running scala Konane.scala. You will then see a board full of dark
and light pieces (X's and O's). Follow the instructions and pick two pieces to start 
the game. After you pick the first couple pieces rotate back and forth from the dark
player to the light player following the rules of the game. The first player who 
reaches zero loses.
------------------------------------------------------------------------------------
Details:

The program starts with the initialBoard Function which has nested loop to get the 
number of rows and columns based on the board size. The first, third, fifth, and 
seventh columns all begin with an "X" and the others an "O". Each X and O is put into
an array that stores all the pieces of the game.

Next the function pick pickPieces is called where the program prompts the user for
the place they want to start the game at and an adjacent piece. Depending on the choice
of the piece, the program will read out different numbers that the user is allowed to
pick. A call to printBoard is made which takes the multi-array and formats it as a 
new board.

Finally MainGame is called which continuously rotates back and forth from Dark Player
Turn to Light Player Turn until someones total amount of pieces equals 0. mainGame calls
makeJump which will make the jump based on the old column and row position and the new 
column and row position. Whenever a value jumped or leaves a location, it is replaced 
with a period.
------------------------------------------------------------------------------------
Positives:

The program makes great use of modules that can be changed to support added functions.
Also recursion is used effectively throughout the program.
------------------------------------------------------------------------------------
Negatives:

Does not support playing against a CPU at this time. The players go back and forth
between each other until the game is over.
------------------------------------------------------------------------------------


