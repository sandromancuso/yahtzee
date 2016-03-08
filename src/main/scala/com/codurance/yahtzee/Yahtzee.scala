package com.codurance.yahtzee

class Yahtzee(scoreCard: ScoreCard,
              turn: Turn,
              console: Console) {

	def startGame(): Unit = {
		scoreCard.categories.foreach(c => {
			console.printLine(s"Category: ${c.name}")
			scoreCard.setScore(turn start c)
		})
		scoreCard print console
	}

}
