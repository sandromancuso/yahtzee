package com.codurance

import com.codurance.yahtzee.{Category, Console, Yahtzee}
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class YahtzeeShould extends UnitSpec {

	val console = mock[Console]
	val ones_category = new Category("Ones")

	var yahtzee = new Yahtzee(ones_category, console)

	"print name of the category passed as parameter" in {
		initialiseYahtzeeWith(Category("Ones"))
		verifyCategoryNameWasPrinted("Ones")

		initialiseYahtzeeWith(Category("Twos"))
		verifyCategoryNameWasPrinted("Twos")
	}

	def initialiseYahtzeeWith(category: Category) = {
		yahtzee = new Yahtzee(category, console)
		yahtzee startGame()
	}

	def verifyCategoryNameWasPrinted(categoryName: String) =
		verify(console) printLine(s"Category: ${categoryName}")

}
