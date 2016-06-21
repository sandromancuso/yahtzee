package com.codurance.yahtzee

case class ScoreCard(categories: List[Category]) {

	var scores: List[(Category, Option[Int])] = setInitialScores()

	def set(score: CategoryScore) = {
		scores = scores.map(s => if (s._1 == score.category) (s._1, Some(score.points)) else s)
	}

	def printFinalScoreTo(console: Console) = {
		console printLine "Yahtzee score"
		scores.foreach(s => console printLine s"${s._1.name}: ${s._2.getOrElse(0)}")
		console printLine "Final score: " + totalScore()
	}

	private def totalScore(): Int = scores.map(_._2.getOrElse(0)).sum

	private def setInitialScores(): List[(Category, Option[Int])] =
		categories.map(c => (c, None))

}
