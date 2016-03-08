package com.codurance.yahtzee

class Turn(dice: Dice, console: Console) {

	def start(category: Category): Score = {
		var rollResult = dice rollAll()
		console printLine s"Dice: $rollResult"

		rollResult = firstReRoll(rollResult)

		Score(category, category.pointsFor(rollResult))
	}

	private def firstReRoll(currentResult: String): String = {
		val dice_to_re_roll = console read "[1] Dice to re-run: "
		if ("" != dice_to_re_roll) {
			val rollResult = rerollDice(dice_to_re_roll)
			secondReRoll(rollResult)
		}
		else currentResult
	}

	private def secondReRoll(currentResult: String): String = {
		val dice_to_re_roll = console read "[2] Dice to re-run: "
		if ("" != dice_to_re_roll)
			 rerollDice(dice_to_re_roll)
		else currentResult
	}

	private def rerollDice(dice_to_reroll: String): String = {
		val rollResult = dice roll dice_to_reroll
		console printLine s"Dice: $rollResult"
		rollResult
	}

}
