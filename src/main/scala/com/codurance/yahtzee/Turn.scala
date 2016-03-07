package com.codurance.yahtzee

class Turn(dice: Dice, console: Console) {

	def start(category: Category): Score = {
		val rollResult = dice roll()

		console printLine(s"Dice: ${rollResult}")

		Score(category, 2)
	}

}
