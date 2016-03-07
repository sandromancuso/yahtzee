package com.codurance.yahtzee

class Yahtzee(category: Category,
              score: Score,
              turn: Turn,
              console: Console) {

	def startGame(): Unit = {
		console.printLine(s"Category: ${category.name}")
		turn start()
		score print()
	}

}
