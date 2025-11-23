# Tic-Tac-Toe-Order-of-Play
1. Project Title

Tic-Tac-Toe: Order of Play 

2. Description / Overview

This project is an enhanced Tic-Tac-Toe game written in Java that uses Object-Oriented Programming (OOP) principles. It features two gameplay modes Player vs Player (PvP) and Player vs AI (PvE) and introduces a unique twist: random consequences are applied each turn, affecting gameplay by skipping turns, granting extra turns, or forcing random moves.
The project showcases clean OOP structuring and interaction among multiple classes.

3. OOP Concepts Applied

a. Encapsulation

Each class manages its own data and behavior.
Example:

⦁	`Board` encapsulates the game grid and all board-related operations.
⦁	`HumanPlayer` and `AIPlayer` manage their own move logic and player info.

b. Inheritance

⦁	Both `HumanPlayer` and `AIPlayer` implement the common `Player` interface.
⦁	Different player types share required functionalities but implement them differently.

c. Polymorphism

The program refers to players through the `Player` interface, allowing interchangeable use of:
⦁	 `HumanPlayer`
⦁	 `AIPlayer`
Consequences apply polymorphically through the `Consequence` interface.

d. Abstraction

⦁	`Player` and `Consequence` act as abstract interfaces.
⦁	 They define what methods must exist, while subclasses define how they work.

4. Program Structure

Main Classes and Responsibilities
                                                                                      
⦁	Main - Entry point of the program, handles mode selection, game loop, and random consequence selection.
⦁	Board - Manages game grid, checks wins, checks full board, and prints the board.                         
⦁	Player (interface) - Defines methods all players must implement (`makeMove`, `getSymbol`, `getName`).                 
⦁	HumanPlayer - Handles input-based moves from the scanner.                                                      
⦁	AIPlayer - Automatically picks random valid moves.                                                          
⦁	Consequence (interface) - Defines the consequence system.                                                                  
⦁	SkipTurnConsequence - Forces the player to skip a turn.                                                                
⦁	ExtraTurnConsequence - Grants a player an additional turn.                                                              
⦁	RandomMoveConsequence - Automatically makes a random move for the player.                                                

Class Relationship Diagram 

            ┌─────────────┐
            │   Player     │ (interface)
            └──────┬──────┘
         ┌──────────┴──────────┐
         │                       │
 ┌──────────────┐       ┌──────────────┐
 │ HumanPlayer   │       │  AIPlayer     │
 └──────────────┘       └──────────────┘

 ┌─────────────────────────┐
 │        Main             │
 │ (game loop, mode, RNG)  │
 └───────┬─────────────────┘
         │
 ┌──────────────┐
 │    Board      │
 └──────────────┘

            ┌─────────────────────┐
            │   Consequence       │ (interface)
            └───────┬────────────┘
      ┌──────────────┼──────────────┬──────────────────┐
      │              │              │                  │
┌──────────────┐┌──────────────┐┌──────────────┐
│ SkipTurn      ││ ExtraTurn     ││ RandomMove    │
└──────────────┘└──────────────┘└──────────────┘

5. How to Run the Program

Compile the Program
Make sure all `.java` files are in the same directory, then run:

javac Main.java

Run the Program

java Main

Mode Selection

When prompted:

1 - PvP (Player vs Player)
2 - PvE (Player vs AI)


Choose your mode by entering "1" or "2".

6. Sample Output

Example startup display:

 █████    █████   ██████  
██   ██  ██   ██  ██   ██ 
██   ██  ██   ██  ██████  
██   ██  ██   ██  ██      
 █████    █████   ██      
=================================
  TIC-TAC-TOE: ORDER OF PLAY
=================================

Welcome to Tic-Tac-Toe!
Choose mode:
1 - PvP (Player vs Player)
2 - PvE (Player vs Entity/AI)


Example consequence trigger:
Player 1's turn (X)
Player 1 gets an EXTRA TURN due to consequence!

Example board:
  +---+---+---+
1 | X | O |   |
  +---+---+---+
2 |   | X |   |
  +---+---+---+
3 |   |   | O |
  +---+---+---+

    1   2   3


7. Author and Acknowledgement

Author:
Eurango, Lenie D.
Fajarda, Dan Froilan M.
Gadon, Glory Grace V.
Gayeta, Teodore Alexis M.

Acknowledgements:
Thanks to our instructor and classmates for guidance and support.

8. Other Sections

a. Future Enhancements
Add smarter AI (minimax algorithm).
Add GUI version (JavaFX or Swing).
Add multiplayer online mode.
Add score tracking (wins/draws/losses).

b. References
Classroom resources/lecture notes
Online Java OOP tutorials
