package com.codurance.yahtzee

import com.codurance.UnitSpec
import org.mockito.BDDMockito.given

class DiceShould extends UnitSpec {

	"should return the dice roll representation" in {
		val randomDieValue = mock[RandomDieValue]
		given(randomDieValue next()) willReturn(2, 4, 1, 6, 1, 1, 6, 2, 5, 3)

		val dice = new Dice(randomDieValue)

		dice.roll should be("D1:2 D2:4 D3:1 D4:6 D5:1")
		dice.roll should be("D1:1 D2:6 D3:2 D4:5 D5:3")
	}

}
