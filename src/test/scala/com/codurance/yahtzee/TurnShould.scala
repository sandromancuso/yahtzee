package com.codurance.yahtzee

import com.codurance.UnitSpec
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TurnShould extends UnitSpec {

	trait context {
		val dice = mock[Dice]
		val category = Category("Ones")
		val console = mock[Console]
		val turn = new Turn(dice, console)
	}

	"Runs a full turn with two dice re-run" in new context {
		given(dice roll()) willReturn(
				"D1:2 D2:4 D3:1 D4:6 D5:1",
				"D1:1 D2:5 D3:1 D4:2 D5:1",
				"D1:1 D2:1 D3:1 D4:5 D5:1")

		turn start(category)

		val inOrder = Mockito.inOrder(console)
		inOrder.verify(console) printLine("Dice: D1:2 D2:4 D3:1 D4:6 D5:1")
		inOrder.verify(console) read("Dice to re-run: ")
		inOrder.verify(console) printLine("Dice: D1:1 D2:5 D3:1 D4:2 D5:1")
		inOrder.verify(console) read("Dice to re-run: ")
		inOrder.verify(console) printLine("Dice: D1:1 D2:1 D3:1 D4:5 D5:1")
	}

	"return the score of that turn" in new context {
		given(dice roll()) willReturn("D1:2 D2:4 D3:1 D4:6 D5:1")

		val score = turn start(category)

		score should be(Score(category, 2))
	}

}
