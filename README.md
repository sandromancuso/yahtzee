Yahtzee
=======

## General requirements

Build a console Yahtzee application. 

## First round
 
The game should support 3 categories (ones, twos, and threes). Player needs to get the biggest number of 1s, 2s, and 3s
 for each category respectively.

The player will play categories in turn.
 
	> Category: Ones
	> Dice: D1:2 D2:4 D3:1 D4:6 D5:1
	> Dice to re-run: D1 D2 D4
	> Dice: D1:1 D2:5 D3:1 D4:2 D5:1 
	> Dice to re-run: D2 D4
	> Dice: D1:1 D2:1 D3:1 D4:5 D5:1
	> Category Ones score: 4
 	 
	> Category: Twos
	> Dice: D1:2 D2:4 D3:1 D4:6 D5:1
	> ....
 	
	> Category: Threes
	> Dice: D1:2 D2:4 D3:1 D4:6 D5:1
	> ....
 	
	> Yahtzee score
	> Ones: 4
	> Twos: [Total for Twos]
	> Threes: [Total for Threes]
	> Final score: [sum of the points in each category]
	> 

## Second round

The player should roll the dice (up to three times) and only choose the most suitable category to add the points to
after finishing each turn. 

	> Dices: D1:2 D2:4 D3:1 D4:6 D5:1
	> Dices to re-run: D1 D2 D4
	> Dices: D1:1 D2:5 D3:1 D4:2 D5:1 
	> Dices to re-run: D2 D4
	> Dices: D1:1 D2:1 D3:1 D4:5 D5:1

	> Available categories:
	> [1] Ones
	> [2] Twos
	> [3] Threes
	> Category to add dice to: 1 
	> ....
 	
	> Dices: D1:2 D2:4 D3:2 D4:1 D5:3
	> Dices to re-run: D1 D2 D4
	> Dices: D1:1 D2:5 D3:2 D4:2 D5:3 
	> Dices to re-run: D1 D2 D5
	> Dices: D1:2 D2:4 D3:2 D4:2 D5:5

	> Available categories:
	> [2] Twos
	> [3] Threes
	> Category to add dice to: 2 
	> ....
	
	> Yahtzee score
	> Ones: 4
	> Twos: 6
	> Threes: [Total for Threes]
	> Final score: [sum of the points in each category]
	> 

## Third round

Multi-player. Allow the game to interact with more than one player. Players should play in turns. 

	> [player 1] Dices: D1:2 D2:4 D3:1 D4:6 D5:1
	> [player 1] Dices to re-run: D1 D2 D4
	> [player 1] Dices: D1:1 D2:5 D3:1 D4:2 D5:1 
	> [player 1] Dices to re-run: D2 D4
	> [player 1] Dices: D1:1 D2:1 D3:1 D4:5 D5:1
	
	> [player 1] Available categories:
	> [player 1] [1] Ones
	> [player 1] [2] Twos
	> [player 1] [3] Threes
	> [player 1] Category to add dice to: 1 
	> ....
	
	> [player 2] Dices: D1:2 D2:4 D3:2 D4:1 D5:3
	> [player 2] Dices to re-run: D1 D2 D4
	> [player 2] Dices: D1:1 D2:5 D3:2 D4:2 D5:3 
	> [player 2] Dices to re-run: D1 D2 D5
	> [player 2] Dices: D1:2 D2:4 D3:2 D4:2 D5:5
	
	> [player 2] Available categories:
	> [player 2 [1] Ones
	> [player 2] [2] Twos
	> [player 2] [3] Threes
	> [player 2] Category to add dice to: 2 
	> ....
	
	> Yahtzee score for player 1
	> Ones: [Total for Ones]
	> Twos: [Total for Twos]
	> Threes: [Total for Threes]
	> Final score: [sum of the points in each category]
	> 
	
	> Yahtzee score for player 2
	> Ones: [Total for Ones]
	> Twos: [Total for Twos]
	> Threes: [Total for Threes]
	> Final score: [sum of the points in each category]
	> 
	> Winner: Player [N]