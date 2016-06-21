package com.codurance.yahtzee

class Yahtzee(scoreCard: ScoreCard,
              turn: Turn,
              console: Console) {

	def startGame(): Unit = {
		scoreCard.categories.foreach(category => {
			printCategoryName(category)
			val categoryScore = turn.start(category)
			scoreCard.set(categoryScore)
		})
		scoreCard.printFinalScoreTo(console)
	}

	private def printCategoryName(category: Category): Unit = {
		console printLine s"Category: ${category.name}"
	}
}
