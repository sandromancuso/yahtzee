package com.codurance.yahtzee

object YahtzeeLauncher extends App {

	val console = new Console
	val category = Category("Ones")
	val randomDiceValue = new RandomDieValue
	val dice = new Dice(randomDiceValue)
	val turn = new Turn(dice, console)
	val scoreCard = ScoreCard(List(category))
	val yahtzee = new Yahtzee(scoreCard, turn, console)

	yahtzee startGame()
}
