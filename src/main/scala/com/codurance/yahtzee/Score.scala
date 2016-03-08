package com.codurance.yahtzee

case class Score(category: Category, points: Int) {

	def print(console: Console): Unit = {
		console printLine "Yahtzee score"
		console printLine s"Ones: ${points}"
	}

}
