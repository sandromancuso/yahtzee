package com.codurance.yahtzee

import com.codurance.UnitSpec
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class YahtzeeShould extends UnitSpec {

	"print name of all categories" in new context {
		runYahtzeeWith(OnesCategory, TwosCategory)

		verifyCategoryNameWasPrinted("Ones")
		verifyCategoryNameWasPrinted("Twos")
	}

	"start turns for each category" in new context {
		runYahtzeeWith(OnesCategory, TwosCategory)

		verify(turn) start OnesCategory
		verify(turn) start TwosCategory
	}

	"print final score" in new context {
		given(turn.start(OnesCategory)) willReturn CategoryScore(OnesCategory, 4)

		runYahtzeeWith(OnesCategory)

		verify(scoreCard) printFinalScoreTo console
	}

	trait context {
		val scoreCard = mock[ScoreCard]
		val console = mock[Console]
		val turn = mock[Turn]

		var yahtzee: Yahtzee = new Yahtzee(ScoreCard(List(OnesCategory)), turn, console)

		def runYahtzeeWith(categories: Category*) = {
			given(scoreCard.categories) willReturn categories.toList
			yahtzee = new Yahtzee(scoreCard, turn, console)

			yahtzee startGame()
		}

		def verifyCategoryNameWasPrinted(categoryName: String) =
			verify(console) printLine(s"Category: ${categoryName}")

	}

}
