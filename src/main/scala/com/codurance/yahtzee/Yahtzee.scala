package com.codurance.yahtzee

class Yahtzee(scoreCard: ScoreCard,
              turn: Turn,
              console: Console) {

	def startGame(): Unit = {
		scoreCard.categories.foreach(category => {
			console.printLine(s"Category: ${category.name}")
			scoreCard.setScore(turn start category)
		})
		scoreCard print console
	}

}
