package com.codurance.yahtzee

class Turn(dice: Dice, console: Console) {

	def start(category: Category): Score = {
		var rollResult = dice rollAll()
		console printLine s"Dice: ${rollResult}"

		rollResult = dice roll (console read "[1] Dice to re-run: ")
		console printLine s"Dice: ${rollResult}"

		rollResult = dice roll(console read "[2] Dice to re-run: ")
		console printLine s"Dice: ${rollResult}"

		Score(category, category.pointsFor(rollResult))
	}

}
