package com.codurance.yahtzee

import com.codurance.UnitSpec
import org.mockito.Mockito

class ScoreCardShould extends UnitSpec {

	"print zero score for all categories when they have no scores" in {
		val console = mock[Console]
		val scoreCard = ScoreCard(List(OnesCategory, TwosCategory))

		scoreCard printFinalScoreTo console

		val inOrder = Mockito.inOrder(console)
		inOrder.verify(console) printLine "Yahtzee score"
		inOrder.verify(console) printLine "Ones: 0"
		inOrder.verify(console) printLine "Twos: 0"
		inOrder.verify(console) printLine "Final score: 0"
	}

	"print categories scores" in {
		val console = mock[Console]
		val scoreCard = ScoreCard(List(OnesCategory, TwosCategory))

		scoreCard set(CategoryScore(OnesCategory, 4))
		scoreCard set(CategoryScore(TwosCategory, 6))

		scoreCard printFinalScoreTo console

		val inOrder = Mockito.inOrder(console)
		inOrder.verify(console) printLine "Yahtzee score"
		inOrder.verify(console) printLine "Ones: 4"
		inOrder.verify(console) printLine "Twos: 6"
		inOrder.verify(console) printLine "Final score: 10"
	}

}
