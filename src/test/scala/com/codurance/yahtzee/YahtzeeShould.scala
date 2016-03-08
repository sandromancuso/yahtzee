package com.codurance.yahtzee

import com.codurance.UnitSpec
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class YahtzeeShould extends UnitSpec {

	"print name of the category passed as parameter" in new context {
		initialiseYahtzeeWith(ones_category)
		verifyCategoryNameWasPrinted("Ones")

		initialiseYahtzeeWith(twos_category)
		verifyCategoryNameWasPrinted("Twos")
	}

	"start a turn for a given category" in new context {
		initialiseYahtzeeWith(ones_category)

		verify(turn) start(ones_category)
	}

	"print score" in new context {
		given(turn.start(ones_category)) willReturn Score(ones_category, 4)

		initialiseYahtzeeWith(ones_category)

		verify(scoreCard) print console
	}

	trait context {
		val scoreCard = mock[ScoreCard]
		val console = mock[Console]
		val turn = mock[Turn]
		val ones_category = new Category("Ones")
		val twos_category = new Category("Twos")

		var yahtzee: Yahtzee = new Yahtzee(ScoreCard(List(ones_category)), turn, console)

		def initialiseYahtzeeWith(category: Category) = {
			given(scoreCard.categories) willReturn List(category)
			yahtzee = new Yahtzee(scoreCard, turn, console)

			yahtzee startGame()
		}

		def verifyCategoryNameWasPrinted(categoryName: String) =
			verify(console) printLine(s"Category: ${categoryName}")

	}

}
