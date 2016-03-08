package com.codurance.yahtzee

import com.codurance.UnitSpec
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class YahtzeeShould extends UnitSpec {

	"print name of the category passed as parameter" in new context {
		initialiseYahtzeeWith(OnesCategory)
		verifyCategoryNameWasPrinted("Ones")

		initialiseYahtzeeWith(TwosCategory)
		verifyCategoryNameWasPrinted("Twos")
	}

	"start a turn for a given category" in new context {
		initialiseYahtzeeWith(OnesCategory)

		verify(turn) start(OnesCategory)
	}

	"print score" in new context {
		given(turn.start(OnesCategory)) willReturn Score(OnesCategory, 4)

		initialiseYahtzeeWith(OnesCategory)

		verify(scoreCard) print console
	}

	trait context {
		val scoreCard = mock[ScoreCard]
		val console = mock[Console]
		val turn = mock[Turn]

		var yahtzee: Yahtzee = new Yahtzee(ScoreCard(List(OnesCategory)), turn, console)

		def initialiseYahtzeeWith(category: Category) = {
			given(scoreCard.categories) willReturn List(category)
			yahtzee = new Yahtzee(scoreCard, turn, console)

			yahtzee startGame()
		}

		def verifyCategoryNameWasPrinted(categoryName: String) =
			verify(console) printLine(s"Category: ${categoryName}")

	}

}
