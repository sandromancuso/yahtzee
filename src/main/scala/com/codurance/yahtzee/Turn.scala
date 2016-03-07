package com.codurance.yahtzee

class Turn(dice: Dice, console: Console) {

	def start(category: Category): Score = {
		var rollResult = dice roll()

		console printLine(s"Dice: ${rollResult}")
		console read("Dice to re-run: ")
		rollResult = dice roll()
		console printLine(s"Dice: ${rollResult}")
		console read("Dice to re-run: ")
		rollResult = dice roll()
		console printLine(s"Dice: ${rollResult}")

		Score(category, 2)
	}

}
