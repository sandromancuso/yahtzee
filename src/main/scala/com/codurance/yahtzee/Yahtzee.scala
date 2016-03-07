package com.codurance.yahtzee

class Yahtzee(category: Category, console: Console) {

	def startGame(): Unit =
		console.printLine(s"Category: ${category.name}")

}
