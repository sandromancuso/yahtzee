package com.codurance.yahtzee

object YahtzeeLauncher extends App {

	val console = new Console
	val category = Category("Ones")
	val randomDiceValue = new RandomDieValue
	val dice = new Dice(randomDiceValue)
	val turn = new Turn(dice, console)
	val yahtzee = new Yahtzee(category, turn, console)

	yahtzee startGame()
}
