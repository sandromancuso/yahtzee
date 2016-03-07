package com.codurance.yahtzee

import com.codurance.UnitSpec
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class YahtzeeShould extends UnitSpec {

	"print name of the category passed as parameter" in new context {
		initialiseYahtzeeWith(Category("Ones"))
		verifyCategoryNameWasPrinted("Ones")

		initialiseYahtzeeWith(Category("Twos"))
		verifyCategoryNameWasPrinted("Twos")
	}

	"print the dice roll" in new context {
		initialiseYahtzeeWith(Category("Ones"))

		verify(turn) start()
	}

	"print score" in new context {
		initialiseYahtzeeWith(Category("Ones"))

		verify(score) print()
	}

	trait context {
		val score = mock[Score]
		val console = mock[Console]
		val turn = mock[Turn]
		val ones_category = new Category("Ones")

		var yahtzee: Yahtzee = new Yahtzee(ones_category, turn, console)

		def initialiseYahtzeeWith(category: Category) = {
			given(turn start()) willReturn(score)
			yahtzee = new Yahtzee(category, turn, console)

			yahtzee startGame()
		}

		def verifyCategoryNameWasPrinted(categoryName: String) =
			verify(console) printLine(s"Category: ${categoryName}")

	}

}
