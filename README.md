Yahtzee Kata
============

## General requirements

Build a playable console [Yahtzee](https://en.wikipedia.org/wiki/Yahtzee) application. It's worth reading about Yahtzee before you start if you are not very familiar with the game.  

## First round
 
The game should support 3 categories (Ones, Twos, and Threes). Player needs to roll the biggest number of 1s, 2s, and 3s
 for each category respectively.

The player will play categories in turn. The following is what you should see if you run the application:
 
	> Category: Ones
	> Dices: D1:2 D2:4 D3:1 D4:6 D5:1
	> Dices to re-run: 
    $ D1 D2 D4
	> Dices: D1:1 D2:5 D3:1 D4:2 D5:1 
	> Dices to re-run: 
    $ D2 D4
	> Dices: D1:1 D2:1 D3:1 D4:5 D5:1
	> Category Ones score: 4
 	 
	> Category: Twos
	> Dices: D1:2 D2:4 D3:1 D4:6 D5:1
	> ....
 	
	> Category: Threes
	> Dices: D1:2 D2:4 D3:1 D4:6 D5:1
	> ....
 	
	> Yahtzee score
	> Ones: 4
	> Twos: [Total for Twos]
	> Threes: [Total for Threes]
	> Final score: [sum of the points in each category]
	> 

## Second round - requirement change

The player should roll the dice (up to three rolls) but only choose the most suitable category to add the points to
after finishing each turn. 

	> Dices: D1:2 D2:4 D3:1 D4:6 D5:1
	> Dices to re-run: 
    $ D1 D2 D4
	> Dices: D1:1 D2:5 D3:1 D4:2 D5:1 
	> Dices to re-run: 
    $ D2 D4
	> Dices: D1:1 D2:1 D3:1 D4:5 D5:1

	> Available categories:
	> [1] Ones
	> [2] Twos
	> [3] Threes
	> Category to add points to: 1 
	> ....
 	
	> Dices: D1:2 D2:4 D3:2 D4:1 D5:3
	> Dices to re-run: 
    $ D1 D2 D4
	> Dices: D1:1 D2:5 D3:2 D4:2 D5:3 
	> Dices to re-run: 
    $ D1 D2 D5
	> Dices: D1:2 D2:4 D3:2 D4:2 D5:5

	> Available categories:
	> [2] Twos
	> [3] Threes
	> Category to add points to: 2 
	> ....
	
	> Yahtzee score
	> Ones: 4
	> Twos: 6
	> Threes: [Total for Threes]
	> Final score: [sum of the points in each category]
	> 

Categories can be selected in any order. Categories can only be selected once.

## Third round - new requirement

Multi-player. Allow the game to interact with more than one player. Players should play in turns. 

	> [player 1] Dices: D1:2 D2:4 D3:1 D4:6 D5:1
	> [player 1] Dices to re-run: 
    $ D1 D2 D4
	> [player 1] Dices: D1:1 D2:5 D3:1 D4:2 D5:1 
	> [player 1] Dices to re-run: 
    $ D2 D4
	> [player 1] Dices: D1:1 D2:1 D3:1 D4:5 D5:1
	
	> [player 1] Available categories:
	> [player 1] [1] Ones
	> [player 1] [2] Twos
	> [player 1] [3] Threes
	> [player 1] Category to add points to: 1 
	> ....
	
	> [player 2] Dices: D1:2 D2:4 D3:2 D4:1 D5:3
	> [player 2] Dices to re-run: 
    $ D1 D2 D4
	> [player 2] Dices: D1:1 D2:5 D3:2 D4:2 D5:3 
	> [player 2] Dices to re-run: 
    $ D1 D2 D5
	> [player 2] Dices: D1:2 D2:4 D3:2 D4:2 D5:5
	
	> [player 2] Available categories:
	> [player 2] [1] Ones
	> [player 2] [2] Twos
	> [player 2] [3] Threes
	> [player 2] Category to add points to: 2 
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

## Fourth round - new requirements

Implement all other missing [Yahtezee](https://en.wikipedia.org/wiki/Yahtzee) categories. 
