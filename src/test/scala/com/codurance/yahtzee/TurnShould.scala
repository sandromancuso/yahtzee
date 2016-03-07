package com.codurance.yahtzee

import com.codurance.UnitSpec
import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify

class TurnShould extends UnitSpec {

	"Prints the first dice roll after it starts" in {
		val dice = mock[Dice]
		val console = mock[Console]
		val turn = new Turn(dice, console)

		given(dice roll()) willReturn("D1:2 D2:4 D3:1 D4:6 D5:1")

		turn start()

		verify(console) printLine("Dice: D1:2 D2:4 D3:1 D4:6 D5:1")
	}

	"return return the score of that turn" in {
		val dice = mock[Dice]
		val console = mock[Console]
		val turn = new Turn(dice, console)

		given(dice roll()) willReturn("D1:2 D2:4 D3:1 D4:6 D5:1")

		val score = turn start()

		score should be(Score(2))
	}

}
