package com.codurance.yahtzee

class Yahtzee(categories: List[Category],
              turn: Turn,
              console: Console) {

	def startGame(): Unit = {
		categories.foreach(c => {
			console.printLine(s"Category: ${c.name}")
			val score = turn start(c)
			score print(console)
			console.printLine(s"Final score: ${score.points}")
		})
	}

}
