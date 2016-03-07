package com.codurance.yahtzee

class Turn(dice: Dice, console: Console) {

	def start(): Score = {
		val rollResult = dice roll()

		console printLine(s"Dice: ${rollResult}")

		Score(2)
	}

}
